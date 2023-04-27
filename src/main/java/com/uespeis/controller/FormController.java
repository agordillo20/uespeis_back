package com.uespeis.controller;

import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uespeis.model.Form;
import com.uespeis.model.Question;
import com.uespeis.model.QuestionResponse;
import com.uespeis.service_impl.FormServiceImpl;
import com.uespeis.service_impl.QuestionResponseServiceImpl;
import com.uespeis.utils.RequestReader;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/forms")
public class FormController {

    @Autowired
    private FormServiceImpl service;
    @Autowired 
    private QuestionResponseServiceImpl serviceQ;

    @PostMapping("/getAllFormsByUserId/{id}")
    public List<Form> getAll(@PathVariable("id") Integer id){
        List<Form> allFormsByUserId = service.getAllFormsByUserId(id);
        allFormsByUserId.forEach(form->{
            form.setUser(null);
            form.setResponses(null);
        });
        return allFormsByUserId;
    }

    @PostMapping("/getActiveFormByUserId/{id}")
    public Form getActiveFormByUserId(@PathVariable("id") Integer id){
        return service.getActiveFormByUserId(id);
    }

    @PostMapping("complete/{id}")
    public void completeForm(@PathVariable("id") Integer id,@RequestBody String mensaje){
        Form f = service.getActiveFormByUserId(id);
        f.setLoocked(true);
        service.save(f);
        Map<String, String> transformToMap = RequestReader.transformToMap(mensaje);
        JSONArray questions = new JSONArray(transformToMap.get("questions"));
        int longitud = questions.length();
        for(int i=0;i<longitud;i++){
            JSONObject element = questions.getJSONObject(i);
            QuestionResponse response = new QuestionResponse();
            response.setForm(f);
            response.setAnswer(element.getInt("answer"));
            ObjectMapper mapper = new ObjectMapper();
            element.remove("answer");
            try {
                Question q = mapper.readValue(element.toString(), new TypeReference<Question>(){});
                response.setQuestion(q);
                serviceQ.save(response);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

}
