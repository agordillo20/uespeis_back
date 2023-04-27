package com.uespeis.service_impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uespeis.model.Form;
import com.uespeis.repository.FormRepository;
import com.uespeis.service.FormService;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    FormRepository repository;

    @Override
    public List<Form> getAllFormsByUserId(Integer idUser) {
        return repository.getAllFormsByUserId(idUser);
    }

    @Override
    public Form getActiveFormByUserId(Integer idUser) {
        return repository.getActiveFormByUserId(idUser);
    }

    @Override
    public void save(Form form) {
        repository.save(form);
    }

    

}
