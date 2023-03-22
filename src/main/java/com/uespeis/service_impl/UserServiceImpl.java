package com.uespeis.service_impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.model.User;
import com.uespeis.repository.UserRepository;
import com.uespeis.service.UserService;
import com.uespeis.utils.Codifiquer;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public boolean auth(String user, String pwd) {
        boolean resultG = false;
        var userGet = userRepository.getUserByEmail(user);
        if (userGet != null) {
            var result = Codifiquer.compare(userGet.getPassword(), pwd);
            if (result) {
                userGet.setLastAccess(LocalDateTime.now());
                saveUser(userGet);
            }
            resultG = result;
        }
        return resultG;
    }

    @Override
    public String getRol(String user) {
        var userGet = userRepository.getUserByEmail(user);
        if (userGet != null) {
            return userGet.getRol();
        }
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

}
