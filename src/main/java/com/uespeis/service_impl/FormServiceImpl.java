package com.uespeis.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.repository.FormRepository;
import com.uespeis.service.FormService;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    FormRepository formRepository;
}
