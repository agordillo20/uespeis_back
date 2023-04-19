package com.uespeis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uespeis.model.Activity;

@Repository
public interface ArchiveRepository extends JpaRepository<Activity, Integer> {

}
