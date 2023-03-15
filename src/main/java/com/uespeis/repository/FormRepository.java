package com.uespeis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.uespeis.model.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Integer> {

    @Query("SELECT f from Form f where f.idUser=?1")
    List<Form> getAllFormsByUserId(Integer idUser);

    @Query("SELECT f from Form f where f.idUser=?1 and loocked=false")
    Form getActiveFormByUserId(Integer idUser);
}
