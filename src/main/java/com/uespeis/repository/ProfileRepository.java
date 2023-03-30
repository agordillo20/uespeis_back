package com.uespeis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.uespeis.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    @Query(value = "Select distinct(p.civilStatus) from Profile p")
    List<String> getAvailableValuesByCivilStatus();

    @Query(value = "Select distinct(p.gender) from Profile p")
    List<String> getAvailableValuesByGenre();

    @Query(value = "Select distinct(p.employmentStatus) from Profile p")
    List<String> getAvailableValuesByLaboralStatus();

    @Query(value = "Select distinct(p.study) from Profile p")
    List<String> getAvailableValuesByStudy();

    @Query("select p from Profile p where (coalesce(?1) is null or (p.age = ?1))" +
            "and (coalesce(?2) is null or (p.height = ?2))" +
            "and (coalesce(?3) is null or (p.weight = ?3))" +
            "and (coalesce(?4) is null or (p.gender = ?4))" +
            "and (coalesce(?5) is null or (p.study = ?5))" +
            "and (coalesce(?6) is null or (p.civilStatus = ?6))" +
            "and (coalesce(?7) is null or (p.employmentStatus = ?7))")
    List<Profile> filterProfile(Integer edad, Integer altura, Double peso, String genero, String estudios,
            String estadoCivil,
            String estadoLaboral);
}
