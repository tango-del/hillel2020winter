package com.pars.yaml;

import com.pars.ReadFromFile;
import com.pars.UserList;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class YamlParceList {
    public static void main(String[] args) {
        Yaml yaml = new Yaml(new Constructor(UserList.class));
        String yamlStr = ReadFromFile.readToString("pars/src/main/resources/users.yaml");
        UserList user = yaml.load(yamlStr);
        System.out.println(user);
    }
}
