package com.uespeis.repository;

import com.uespeis.model.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resources, Integer>{
    
}
