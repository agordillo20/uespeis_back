package com.uespeis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uespeis.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("Select u from User u where u.email=?1")
    User getUserByName(String user);
}
