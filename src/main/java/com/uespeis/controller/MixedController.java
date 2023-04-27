package com.uespeis.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.beanutils.ConvertUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uespeis.model.ActivityUserQuestion;
import com.uespeis.model.Profile;
import com.uespeis.model.Question;
import com.uespeis.service.QuestionResponseService;
import com.uespeis.service_impl.ActivityParentServiceImpl;
import com.uespeis.service_impl.ActivityUserQuestionResponseServiceImpl;
import com.uespeis.service_impl.FormServiceImpl;
import com.uespeis.service_impl.ProfileServiceImpl;
import com.uespeis.service_impl.QuestionResponseServiceImpl;
import com.uespeis.service_impl.UserServiceImpl;
import com.uespeis.utils.RequestReader;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/mixed")
public class MixedController {

    @Autowired
    private FormServiceImpl serviceForm;
    @Autowired
    private UserServiceImpl serviceUser;
    @Autowired
    private ProfileServiceImpl serviceProfile;
    @Autowired
    private QuestionResponseServiceImpl serviceUserQuestion;

    @Autowired
    private ActivityParentServiceImpl activityParentServiceImpl;
    @Autowired
    private ActivityUserQuestionResponseServiceImpl activityUserQuestionResponseServiceImpl;

    @PostMapping("/complete-profile")
    public ResponseEntity<Boolean> completeProfile(@RequestBody String mensaje) {
        Map<String, String> transformToMap = RequestReader.transformToMap(mensaje);
        boolean response = false;
        var userId = Integer.valueOf(transformToMap.get("userId"));
        ObjectMapper mapper = new ObjectMapper();
        try {
            Profile profile = mapper.readValue(transformToMap.get("profile"), new TypeReference<Profile>() {
            });
            serviceUser.completeProfile(userId, profile);
            response = true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(response);
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
        var filterQuestionResponse = serviceUserQuestion.filterQuestionResponse(idQuestion,answer);
        List<Profile> resultado = new ArrayList<>();
        filterQuestionResponse.forEach(qr-> resultado.add(qr.getForm().getUser().getProfile()));
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
