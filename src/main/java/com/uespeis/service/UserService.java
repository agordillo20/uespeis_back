package com.uespeis.service;

import com.uespeis.model.User;

public interface UserService {

    public void saveUser(User user);

    public boolean auth(String user,String pwd);

    public void update(User u);
}
