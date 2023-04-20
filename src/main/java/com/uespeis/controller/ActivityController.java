package com.uespeis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uespeis.service.ActivityParentService;
import com.uespeis.service.ActivityService;
import com.uespeis.service.ActivityUserQuestionResponseService;
import com.uespeis.service.ActivityUserQuestionService;
import com.uespeis.service.ActivityUserRealizatedService;

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
    
}
