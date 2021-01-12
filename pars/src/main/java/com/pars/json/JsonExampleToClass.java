package com.pars.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.pars.User;

public class JsonExampleToClass {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{" +
                "        'firstName': 'Alex'," +
                "        'lastName': 'Stepurko'," +
                "        'age': '33'," +
                "        'email': 'stepurko@info.com'," +
                "        'technology': 'Java'" +
                "      }";

        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);

        user.setTechnology("PHP");

        System.out.println(user.toString());

        System.out.println(gson.toJson(user));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //objectMapper.configure(JsonParser.Feature.ALLOW_MISSING_VALUES, true);
        User us = objectMapper.readValue(json, User.class);
        System.out.println(us.toString());
    }
}
