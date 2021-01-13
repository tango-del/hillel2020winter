package com.pars.yaml;

import com.pars.ReadFromFile;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class YamlParce {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
//        String yamlStr = ReadFromFile.readToString("pars/src/main/resources/user.yaml");
        String yamlStr = ReadFromFile.readToString("pars/src/main/resources/user1.yaml");
        Map<String, Object> obj = yaml.load(yamlStr);
        System.out.println(obj);
        System.out.println();
        System.out.println(yaml.dump(obj));
    }
}
