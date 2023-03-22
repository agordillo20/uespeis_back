package com.uespeis.service;

import java.util.List;

import com.uespeis.model.Form;

public interface FormService {
    List<Form> getAllFormsByUserId(Integer idUser);

    Form getActiveFormByUserId(Integer idUser);

    void save(Form form);
}
