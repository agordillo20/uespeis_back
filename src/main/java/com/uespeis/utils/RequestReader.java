package com.uespeis.utils;

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
            result.put(split[0], URLDecoder.decode(split[1], StandardCharsets.ISO_8859_1));
        }
        return result;
    }

}
