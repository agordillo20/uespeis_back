package com.uespeis.service;

import java.util.List;

import com.uespeis.model.Profile;

public interface ProfileService {

    public List<String> getAvailableValuesByCivilStatus();

    public List<String> getAvailableValuesByGenre();

    public List<String> getAvailableValuesByLaboralStatus();

    public List<String> getAvailableValuesByStudy();

    public List<Profile> filterProfile(Integer edad, Integer altura, Double peso, String genero, String estudios,
            String estadoCivil, String estadoLaboral);
}
