package com.uespeis.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class RequestReader {

    private RequestReader(){}

    public static Map<String,String> transformToMap(String mensaje){
        Map<String,String> result = new HashMap<>();
        String[] params = mensaje.split("&");
        for (int i = 0; i < params.length; i++) {
            String [] split = params[i].split("=");
            try {
                result.put(split[0], URLDecoder.decode(split[1], StandardCharsets.UTF_8.name()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
