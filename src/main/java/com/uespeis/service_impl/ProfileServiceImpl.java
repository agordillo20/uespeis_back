package com.uespeis.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.model.Profile;
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

    @Override
    public List<Profile> filterProfile(Integer edad, Integer altura, Double peso, String genero, String estudios,
            String estadoCivil, String estadoLaboral) {
        return repository.filterProfile(edad, altura, peso, genero, estudios, estadoCivil, estadoLaboral);
    }

}
