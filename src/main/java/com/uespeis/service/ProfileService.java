package com.uespeis.service;

import java.util.List;

public interface ProfileService {
    
    public List<String> getAvailableValuesByCivilStatus();

    public List<String> getAvailableValuesByGenre();

    public List<String> getAvailableValuesByLaboralStatus();

    public List<String> getAvailableValuesByStudy();

}
