package com.uespeis.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.beanutils.ConvertUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uespeis.model.Profile;
import com.uespeis.model.Questions;
import com.uespeis.service.UserQuestionService;
import com.uespeis.service_impl.FormParentServiceImpl;
import com.uespeis.service_impl.FormServiceImpl;
import com.uespeis.service_impl.ProfileServiceImpl;
import com.uespeis.service_impl.UserQuestionServiceImpl;
import com.uespeis.service_impl.UserServiceImpl;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/mixed")
public class MixedController {

    @Autowired
    private FormParentServiceImpl serviceFormParent;
    @Autowired
    private FormServiceImpl serviceForm;
    @Autowired
    private UserServiceImpl serviceUser;
    @Autowired
    private ProfileServiceImpl serviceProfile;
    @Autowired
    private UserQuestionServiceImpl serviceUserQuestion;

    @PostMapping("/getActiveQuestionsFromUser")
    public List<Questions> getActiveQuestionsFromUser(@RequestBody String mensaje) {
        var entrada = new JSONArray(mensaje);
        Integer idUser = serviceUser.findUserByEmail(entrada.getString(0)).getId();
        Integer idParent = serviceForm.getActiveFormByUserId(idUser).getParent().getId();
        return serviceFormParent.getQuestionFromParentId(idParent);
    }

    @PostMapping("/complete-profile")
    public JSONObject completeProfile(@RequestBody String mensaje) {
        boolean response = false;
        var entrada = new org.json.JSONObject(mensaje);
        var userId = entrada.getInt("userId");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Profile profile = mapper.readValue(entrada.getString("profile"), new TypeReference<Profile>() {
            });
            serviceUser.completeProfile(userId, profile);
            response = true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        JSONObject result = new JSONObject();
        result.put("result", response);
        return result;
    }

    @PostMapping("/getFieldValue")
    public JSONObject getAllPosiblesValues() {
        JSONObject result = new JSONObject();
        result.put("result_st", serviceProfile.getAvailableValuesByStudy());
        result.put("result_cs", serviceProfile.getAvailableValuesByCivilStatus());
        result.put("result_gen", serviceProfile.getAvailableValuesByGenre());
        result.put("result_ls", serviceProfile.getAvailableValuesByLaboralStatus());
        return result;
    }

    @PostMapping("/filter/byUser")
    public JSONObject filterByUser(@RequestBody String mensaje) {
        //datos
        var entrada = new org.json.JSONObject(mensaje);
        Integer altura = (Integer) checkValueAndGet("altura",Integer.class,entrada);
        Double peso = (Double) checkValueAndGet("peso",Double.class,entrada);
        String genero = (String) checkValueAndGet("genero",String.class,entrada);
        String estadoCivil = (String) checkValueAndGet("estadoCivil",String.class,entrada);
        Integer edad = (Integer) checkValueAndGet("edad",Integer.class,entrada);
        String estudios = (String) checkValueAndGet("estudios",String.class,entrada);
        String estadoLaboral = (String) checkValueAndGet("estadoLaboral",String.class,entrada);
        //procesamiento/devolución
        JSONObject result = new JSONObject();
        result.put("result",
                serviceProfile.filterProfile(edad, altura, peso, genero, estudios, estadoCivil, estadoLaboral));
        return result;
    }

    @PostMapping("/filter/byQuestion")
    public JSONObject filterByQuestion(@RequestBody String mensaje) {
        //datos
        var entrada = new org.json.JSONObject(mensaje);
        Integer idQuestion = (Integer) checkValueAndGet("question_id",Integer.class,entrada);
        Integer answer = (Integer) checkValueAndGet("answer",Integer.class,entrada);
        //procesamiento
        var filterUserQuestions = serviceUserQuestion.filterUserQuestions(idQuestion,answer);
        List<Profile> resultado = new ArrayList<>();
        filterUserQuestions.forEach(uq->{
            var user = serviceUser.getUserById(uq.getIdUser());
            if(user.isPresent()){
                var profile = user.get().getProfile();
                if(profile!=null){
                    resultado.add(profile);
                }
            }
        });
        //devolución
        JSONObject result = new JSONObject();
        result.put("result",resultado);
        return result;
    }


    private Object checkValueAndGet(String field,Class<?> clazz,org.json.JSONObject entrada){
        String f = entrada.getString(field);
        Object newInstance = null;
        if(!f.equals("")){
            newInstance = ConvertUtils.convert(f, clazz);
        }
        return newInstance;
    }
}
