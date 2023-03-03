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
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean auth(String user, String pwd) {
        boolean resultG = false;
        var userGet = userRepository.getUserByName(user);
        if(userGet!=null){
            var result=Codifiquer.compare(userGet.getPassword(), pwd);
            if(result){
                userGet.setLastAccess(LocalDateTime.now());
                saveUser(userGet);
            }
            resultG=result;
        }
        return resultG;
    }

}
