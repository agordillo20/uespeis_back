package com.uespeis.utils;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public class Codifiquer {

    private static Argon2PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

    private Codifiquer(){

    }
    
    public static String encode(String pass){
        return encoder.encode(pass);
    }

    public static boolean compare(String hash,String pass){
        return encoder.matches(pass, hash);
    }
}
