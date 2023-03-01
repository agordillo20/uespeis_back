package com.uespeis.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Codifiquer {

    private Codifiquer(){

    }
    
    public static String encode(String pass){
        return BCrypt.withDefaults().hashToString(15, pass.toCharArray());
    }

    public static boolean compare(String hash,String pass){
        BCrypt.Result result = BCrypt.verifyer().verify(pass.toCharArray(), hash);
        return result.verified;
    }
}
