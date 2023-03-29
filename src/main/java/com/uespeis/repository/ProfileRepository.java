package com.uespeis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.uespeis.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {

    @Query(value = "Select distinct(p.civilStatus) from Profile p")
    List<String> getAvailableValuesByCivilStatus();

    @Query(value = "Select distinct(p.gender) from Profile p")
    List<String> getAvailableValuesByGenre();

    @Query(value = "Select distinct(p.employmentStatus) from Profile p")
    List<String> getAvailableValuesByLaboralStatus();

    @Query(value = "Select distinct(p.study) from Profile p")
    List<String> getAvailableValuesByStudy();
    
}
