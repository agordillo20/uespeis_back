package com.uespeis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uespeis.model.FormParent;

@Repository
public interface FormParentRepository extends JpaRepository<FormParent, Integer> {    

}
