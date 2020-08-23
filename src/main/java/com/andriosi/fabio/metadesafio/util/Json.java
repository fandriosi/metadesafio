package com.andriosi.fabio.metadesafio.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    public String getJson(Object obj){
        String json = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            json = objectMapper.writeValueAsString(obj);
        }catch (JsonProcessingException e){
            e.getMessage();
        }
        return  json;
    }
}
