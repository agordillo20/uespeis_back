package com.uespeis.service_impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.uespeis.model.Profile;
import com.uespeis.model.User;
import com.uespeis.repository.UserRepository;
import com.uespeis.service.UserService;
import com.uespeis.utils.Codifiquer;

@Service
public class UserServiceImpl implements UserService {

    private static final Integer EXPIRATION_TIME=1800000;
    private static final String SECRET="Uespeis";
    
    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String auth(String user, String pwd) {
        String jwt = null;
        var userGet = userRepository.getUserByEmail(user);
        if (userGet != null) {
            var result = Codifiquer.compare(userGet.getPassword(), pwd);
            if (result) {
                userGet.setLastAccess(LocalDateTime.now());
                saveUser(userGet);
                jwt = createJWTToken(userGet);
            }
        }
        return jwt;
    }

    private String createJWTToken(User u){
        return JWT.create()
            .withSubject(String.valueOf(u.getId()))
            .withClaim("role", u.getRol())
            .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .sign(Algorithm.HMAC512(SECRET.getBytes()));
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

    @Override
    public void completeProfile(Integer idUser, Profile prof) {
        Optional<User> u  = userRepository.findById(idUser);
        if(u.isPresent()){
            Profile uProf = u.get().getProfile();
            if(uProf!=null){
                prof.setId(uProf.getId());
            }
            u.get().setProfile(prof);
            userRepository.save(u.get());
        }
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);
    }

}
