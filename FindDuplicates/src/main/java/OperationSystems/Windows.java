package OperationSystems;

import Interfaces.SystemRules;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Windows implements SystemRules {
    private static String windows;
    private static String program_files;

    @Override
    public boolean systemExclusionRules(String fileName) throws IOException {
//        writePropValuesToStrings();
        return !fileName.contains(windows) && !fileName.contains(program_files);

//        if (resourceBundle.getString("program_files64").equals(fileName) || resourceBundle.getString("program_files86").equals(fileName) || resourceBundle.getString("program_files").equals(fileName) || resourceBundle.getString("windows").equals(fileName)) {
//            return false;
//        }
//        return true;
//        return switch (fileName) {
//            case "Windows", "Program Files", "Program Files (x86)", "Program Files (x64)" -> false;
//            default -> true;
//        };
    }

    public void writePropValuesToStrings() throws IOException {
        Properties prop = new Properties();
        String propFile = "WinSysDirs.properties";
        InputStream inputStream = Windows.class.getClassLoader().getResourceAsStream(propFile);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file: " + propFile + " not found in the classpath");
        }

        windows = prop.getProperty("windows");
        program_files = prop.getProperty("program_files");
        inputStream.close();
    }

    public static void testBundle() throws IOException {
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("src/main/resources/WinSysDirs.properties");
//        System.out.println(resourceBundle.getString("program_files64"));
    }
}