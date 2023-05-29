package com.uespeis.controller;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uespeis.model.Activity;
import com.uespeis.model.ActivityParent;
import com.uespeis.model.ActivityUserQuestion;
import com.uespeis.model.ActivityUserQuestionResponse;
import com.uespeis.model.ActivityUserRealizated;
import com.uespeis.model.Form;
import com.uespeis.model.SubActivity;
import com.uespeis.model.User;
import com.uespeis.service.ActivityParentService;
import com.uespeis.service.ActivityService;
import com.uespeis.service.ActivityUserQuestionResponseService;
import com.uespeis.service.ActivityUserQuestionService;
import com.uespeis.service.ActivityUserRealizatedService;
import com.uespeis.service.FormService;
import com.uespeis.service.SubActivityService;
import com.uespeis.service.UserService;
import com.uespeis.utils.RequestReader;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/activity")
public class ActivityController {

    long oneDay = 86400000L;

    @Autowired
    private ActivityService aService;
    @Autowired
    private SubActivityService saService;
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


    //TODO:PDT esto en realidad es getNextActivity
    @PostMapping("/getNextActivity/{id}")
    public ResponseEntity<?> getNextActivity(@PathVariable("id") Integer id){
        List<ActivityParent> allActivities = apService.getAll();
        List<ActivityUserRealizated> findByUserId = aurService.findByUserId(id);
        if(!findByUserId.isEmpty()){
            ActivityUserRealizated last = findByUserId.get(findByUserId.size()-1);
            ActivityParent lastActivity = last.getParent().getParent();
            int index = allActivities.indexOf(lastActivity);
            if(index!=-1 && index!=allActivities.size()-1){
                if(getMinusTime(last)>=oneDay){
                    return ResponseEntity.ok().body(allActivities.get(index+1));
                }else{
                    return ResponseEntity.ok().body("tiempo restante - "+getMinusTime(last));
                }

            }else{
                return ResponseEntity.ok().body(new ActivityParent());
            }
            /*
            Optional<ActivityParent> findFirst = allActivities.stream().filter(ac->ac.getId()==lastActivity).findFirst();
            if(findFirst.isPresent()){
                Integer totalForPass = findFirst.get().getTotalForComplete();
                Integer totalRealizated = (int) findByUserId.stream().filter(aur->aur.getParent().getParent()==findFirst.get()).count();
                if(totalForPass==totalRealizated){
                    return ResponseEntity.ok().body(allActivities.get(allActivities.indexOf(findFirst.get())+1));
                }else{
                    return ResponseEntity.ok().body(findFirst.get());
                }
            }else{
                return ResponseEntity.ok().body(new ActivityParent());
            }*/
        }else{
            return ResponseEntity.ok().body(allActivities.get(0));
        }
    }

    private long getMinusTime(ActivityUserRealizated last){
        long lastActivityDo = last.getDate().getTime();
        long actual = new Date().getTime();
        return actual-lastActivityDo;
    }

    @PostMapping("/getActualActivityForDiagram/{id}")
    public ResponseEntity<Integer> getActualActivityForUser(@PathVariable("id") Integer id){
        List<ActivityParent> allActivities = apService.getAll();
        List<ActivityUserRealizated> findByUserId = aurService.findByUserId(id);
        return ResponseEntity.ok().body(
            !findByUserId.isEmpty()?
            findByUserId.get(findByUserId.size()-1).getParent().getParent().getId()+1:
            allActivities.get(0).getId()
        );
    }

    @PostMapping("/getActualActivity/{id}")
    public ResponseEntity<String> getActualActivityForUserV2(@PathVariable("id") Integer id){
        List<ActivityParent> allActivities = apService.getAll();
        List<ActivityUserRealizated> findByUserId = aurService.findByUserId(id);
        if(!findByUserId.isEmpty()){
            ActivityUserRealizated last = findByUserId.get(findByUserId.size()-1);
            long time = getMinusTime(last);
            int lastId = last.getParent().getParent().getId();
            Integer totalComplete = aurService.findByUserIdAndParent(id,last.getParent().getId());
            if(time>=oneDay){
                return ResponseEntity.ok().body(totalComplete<last.getParent().getTotalForComplete()?String.valueOf(lastId):String.valueOf(lastId+1));
            }else{
                return ResponseEntity.ok().body("tiempo restante - "+(oneDay-time)+"-"+(totalComplete<last.getParent().getTotalForComplete()?String.valueOf(lastId):String.valueOf(lastId+1)));
            }

        }else{
            ResponseEntity.ok().body(String.valueOf(allActivities.get(0).getId()));
        }
        return null;
    }

    @PostMapping("/getAllActivities/{id}")
    public ResponseEntity<List<Activity>> getAllActivitiesByParentId(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(apService.findById(id).getActivities());
    }

    @PostMapping("/getQuestionsFromParent/{id}")
    public ResponseEntity<List<ActivityUserQuestion>> getQuestionsFromParent(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(saService.findById(id).getActivitiesUserQuestions());
    }

    @PostMapping("/getAllSubActivitiesFromParent/{id}")
    public ResponseEntity<List<SubActivity>> getAllSubActivitiesFromParent(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(saService.getAllSubActivitiesFromActivityParent(id));
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

    //TODO:ver que se haga correctamente, pero deberia de estar bien
    @PostMapping("/markActivityAsDone")
    public void markActivityAsDone(@RequestBody String mensaje){
        Map<String, String> transformToMap = RequestReader.transformToMap(mensaje);
        ActivityUserRealizated done = new ActivityUserRealizated();
        Optional<User> u = uService.getUserById(Integer.valueOf(transformToMap.get("userID")));
        Activity findById = aService.findById(Integer.valueOf(transformToMap.get("parent")));
        if(u.isPresent()){
            done.setUser(u.get());
            done.setParent(findById);
            done.setDate(new Date());
            aurService.save(done);
            List<ActivityUserRealizated> findByUserId = aurService.findByUserId(u.get().getId());
            int totalActivitiesMustBe =  (int) aService.getAll().stream().mapToLong(a->a.getTotalForComplete()).sum();
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
    @PostMapping("/getAll")
    public ResponseEntity<List<ActivityParent>> getAll(){
        return ResponseEntity.ok().body(apService.getAll());
    }

    @PostMapping("/getQuestionsResponsesForChart")
    public ResponseEntity<Map<Integer, innerOb>> getQuestionsResponsesForChart(@RequestBody String mensaje){
        Map<String, String> transformToMap = RequestReader.transformToMap(mensaje);
        int user = Integer.parseInt(transformToMap.get("userID"));
        int parent = Integer.parseInt(transformToMap.get("parent"));
        List<ActivityUserQuestionResponse> fromParentAndUser = auqrService.getFromParentAndUser(parent,user);
        Map<Integer,innerOb> mp = new HashMap<>();
        fromParentAndUser.forEach(f->{
            if(mp.containsKey(f.getActivityUserQuestion().getId())){
                innerOb innerOb = mp.get(f.getActivityUserQuestion().getId());
                innerOb.setResponse(innerOb.getResponse()+";"+f.getResponse());
                mp.put(f.getActivityUserQuestion().getId(), innerOb);
            }else{
                innerOb ob = new innerOb();
                ob.setQuestion(f.getActivityUserQuestion().getQuestion());
                ob.setResponse(f.getResponse());
                mp.put(f.getActivityUserQuestion().getId(),ob);
            }
        });

        return ResponseEntity.ok().body(mp);
    }

    private class innerOb{
        private String response;
        private String question;
        
        public String getResponse() {
            return response;
        }
        public void setResponse(String response) {
            this.response = response;
        }
        public String getQuestion() {
            return question;
        }
        public void setQuestion(String question) {
            this.question = question;
        }
        
    }
}
