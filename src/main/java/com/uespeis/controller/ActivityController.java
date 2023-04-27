package com.uespeis.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uespeis.model.Activity;
import com.uespeis.model.ActivityParent;
import com.uespeis.model.ActivityUserQuestion;
import com.uespeis.model.ActivityUserQuestionResponse;
import com.uespeis.model.ActivityUserRealizated;
import com.uespeis.model.Form;
import com.uespeis.model.User;
import com.uespeis.service.ActivityParentService;
import com.uespeis.service.ActivityService;
import com.uespeis.service.ActivityUserQuestionResponseService;
import com.uespeis.service.ActivityUserQuestionService;
import com.uespeis.service.ActivityUserRealizatedService;
import com.uespeis.service.FormService;
import com.uespeis.service.UserService;
import com.uespeis.utils.RequestReader;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/activity")
public class ActivityController {

    @Autowired
    private ActivityService aService;
    @Autowired
    private ActivityParentService apService;
    @Autowired
    private ActivityUserQuestionService auqService;
    @Autowired
    private ActivityUserQuestionResponseService auqrService;
    @Autowired
    private ActivityUserRealizatedService aurService;
    @Autowired
    private UserService uService;
    @Autowired
    private FormService fService;

    @PostMapping("/getActualActivity/{id}")
    public ResponseEntity<ActivityParent> getActualActivityForUser(@PathVariable("id") Integer id){
        List<ActivityParent> allActivities = apService.getAll();
        List<ActivityUserRealizated> findByUserId = aurService.findByUserId(id);
        if(!findByUserId.isEmpty()){
            Integer lastActivity = findByUserId.get(findByUserId.size()-1).getParent().getId();
            Optional<ActivityParent> findFirst = allActivities.stream().filter(ac->ac.getId()==lastActivity).findFirst();
            if(findFirst.isPresent()){
                Integer totalForPass = findFirst.get().getTotalForComplete();
                Integer totalRealizated = (int) findByUserId.stream().filter(aur->aur.getParent()==findFirst.get()).count();
                if(totalForPass==totalRealizated){
                    return ResponseEntity.ok().body(allActivities.get(allActivities.indexOf(findFirst.get())+1));
                }else{
                    return ResponseEntity.ok().body(findFirst.get());
                }
            }else{
                return ResponseEntity.ok().body(new ActivityParent());
            }
        }else{
            return ResponseEntity.ok().body(allActivities.get(0));
        }
    }

    @PostMapping("/getAllActivities/{id}")
    public ResponseEntity<List<Activity>> getAllActivitiesByParentId(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(apService.findById(id).getActivities());
    }

    @PostMapping("/getQuestionsFromParent/{id}")
    public ResponseEntity<List<ActivityUserQuestion>> getQuestionsFromParent(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(apService.findById(id).getActivitiesUserQuestions());
    }

    @PostMapping("/complete")
    public void completeQuestion(@RequestBody String mensaje){
        JSONObject json = new JSONObject(RequestReader.transformToMap(mensaje).get("response"));
        Optional<User> u = uService.getUserById(json.getInt("user"));
        if(u.isPresent()){
            ActivityUserQuestionResponse response = ActivityUserQuestionResponse.builder()
                .response(json.getString("response"))
                .id(json.getInt("id"))
                .activityUserQuestion(auqService.findById(json.getInt("activityUserQuestion")))
                .user(u.get())
                .build();
            auqrService.save(response);
        }
    }

    @PostMapping("/markActivityAsDone")
    public void markActivityAsDone(@RequestBody String mensaje){
        Map<String, String> transformToMap = RequestReader.transformToMap(mensaje);
        ActivityUserRealizated done = new ActivityUserRealizated();
        Optional<User> u = uService.getUserById(Integer.valueOf(transformToMap.get("userID")));
        ActivityParent findById = apService.findById(Integer.valueOf(transformToMap.get("parent")));
        if(u.isPresent()){
            done.setUser(u.get());
            done.setParent(findById);
            aurService.save(done);
            List<ActivityUserRealizated> findByUserId = aurService.findByUserId(u.get().getId());
            int totalActivitiesMustBe =  (int) apService.getAll().stream().mapToLong(a->a.getTotalForComplete()).sum();
            int totalForPass = findById.getTotalForComplete();
            int totalRealizatedOfActivity = (int) findByUserId.stream().filter(aur->aur.getParent().getId()==findById.getId()).count();
            if((totalForPass==totalRealizatedOfActivity) && (findByUserId.size()==totalActivitiesMustBe)){
                Form f = Form.builder()
                .loocked(false)
                .user(u.get())
                .build();
                fService.save(f);
            }
        }
    }
}
