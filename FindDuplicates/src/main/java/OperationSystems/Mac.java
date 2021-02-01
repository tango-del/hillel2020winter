package OperationSystems;

import Interfaces.SystemRules;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class Mac implements SystemRules {
    private static List<String> systemDirs;

    @Override
    public boolean systemExclusionRules(String fileName) throws IOException {
        for (String i : systemDirs) {
            if (fileName.contains(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void writePropValuesToStrings() throws IOException {
        systemDirs = new LinkedList<>();
        Properties prop = new Properties();
        String propFile = "MacSysDirs.properties";
        InputStream inputStream = Mac.class.getClassLoader().getResourceAsStream(propFile);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file: " + propFile + " not found in the classpath");
        }
        inputStream.close();

        prop.forEach((k, v) -> systemDirs.add(v.toString()));
    }
}
