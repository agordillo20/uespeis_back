package com.uespeis.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.repository.ProfileRepository;
import com.uespeis.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {


    @Autowired
    private ProfileRepository repository;

    @Override
    public List<String> getAvailableValuesByCivilStatus() {
        return repository.getAvailableValuesByCivilStatus();
    }

    @Override
    public List<String> getAvailableValuesByGenre() {
        return repository.getAvailableValuesByGenre();
    }

    @Override
    public List<String> getAvailableValuesByLaboralStatus() {
        return repository.getAvailableValuesByLaboralStatus();
    }

    @Override
    public List<String> getAvailableValuesByStudy() {
        return repository.getAvailableValuesByStudy();
    }
    
    
}
