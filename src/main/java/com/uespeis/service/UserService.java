package com.uespeis.service;

import com.uespeis.model.Profile;
import com.uespeis.model.User;

public interface UserService {

    public User saveUser(User user);

    public boolean auth(String user, String pwd);

    public String getRol(String user);

    public User findUserByEmail(String email);

    public void completeProfile(Integer idUser,Profile prof);

}
