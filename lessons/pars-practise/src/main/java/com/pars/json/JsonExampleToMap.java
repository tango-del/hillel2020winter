package com.pars.json;

import com.google.gson.Gson;

import java.util.Map;
import java.util.Set;

public class JsonExampleToMap {
    public static void main(String[] args) {
        String json = "{ " +
                "'name': 'Alex Stepurko', " +
                "'Java': true, " +
                "'age': 35, " +
                "'permission': ['READ', 'WRITE', 'CREATE'], " +
                "'identifiers': {'phone': '123456', 'email': alex@info.com}" +
                "}";

        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);

        System.out.println(map);

        Set<String> set = map.keySet();

        for (String str : set) {
            System.out.println("--------");
            System.out.println(str + " ... ");
            System.out.println(map.get(str));
            System.out.println(map.get(str).getClass());
        }
    }
}
