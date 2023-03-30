package com.uespeis.controller;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uespeis.model.Profile;
import com.uespeis.model.Questions;
import com.uespeis.service_impl.FormParentServiceImpl;
import com.uespeis.service_impl.FormServiceImpl;
import com.uespeis.service_impl.ProfileServiceImpl;
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
        var entrada = new org.json.JSONObject(mensaje);
        String altura = entrada.getString("altura");
        Integer alturaConvertida = null;
        if (!altura.equals("")){
            alturaConvertida = Integer.valueOf(altura);
        }
        String peso = entrada.getString("peso");
        Double pesoConvertido = null;
        if (!peso.equals("")){
            pesoConvertido = Double.valueOf(peso);
        }
        String genero = entrada.getString("genero");
        if (genero.equals("")){
            genero = null;
        }
        String estadoCivil = entrada.getString("estadoCivil");
        if (estadoCivil.equals("")){
            estadoCivil = null;
        }
        String edad = entrada.getString("edad");
        Integer edadConvertida = null;
        if (!edad.equals("")){
            edadConvertida = Integer.valueOf(edad);
        }
        String estudios = entrada.getString("estudios");
        if (estudios.equals("")){
            estudios = null;
        }
        String estadoLaboral = entrada.getString("estadoLaboral");
        if (estadoLaboral.equals("")){
            estadoLaboral = null;
        }

        JSONObject result = new JSONObject();
        result.put("result",
                serviceProfile.filterProfile(edadConvertida, alturaConvertida, pesoConvertido, genero, estudios, estadoCivil, estadoLaboral));
        return result;
    }
}
