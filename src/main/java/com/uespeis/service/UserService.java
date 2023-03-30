package com.uespeis.service;

import java.util.Optional;
import com.uespeis.model.Profile;
import com.uespeis.model.User;

public interface UserService {

    public User saveUser(User user);

    public String auth(String user, String pwd);

    public String getRol(String user);

    public User findUserByEmail(String email);

    public void completeProfile(Integer idUser,Profile prof);

    public Optional<User> getUserById(Integer id);

}
