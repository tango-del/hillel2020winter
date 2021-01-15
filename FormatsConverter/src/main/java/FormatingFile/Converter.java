package FormatingFile;

import FileCreatings.FileWork;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Converter {

    private static StringBuilder strBuilder = new StringBuilder();
    //append(System.lineSeparator()) - добавляет новую строку

    public static void convert(String path) throws IOException {

        FileWork fileWork = new FileWork();

        JsonToYaml jsonToYaml = new JsonToYaml();
        YamlToJson yamlToJson = new YamlToJson();

        File filePath = new File(path);

        fileWork.createFileDir(path);
        //FileCreator.checkDirExists(path);

        Arrays.stream(filePath.listFiles())
                .filter(File::isFile)
                .filter(file -> file.getName().contains(".json") || file.getName().contains(".yaml"))
                .map(File::getPath)
                .forEach(f -> {
                    String fileName = new File(f.split("[.]", 0)[0]).getName();
                    try {
                        if (f.contains(".json")) {
                            jsonToYaml.convertFile(f, fileName, strBuilder);

                        } else if (f.contains(".yaml")) {

                            yamlToJson.convertFile(f, fileName, strBuilder);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        fileWork.writeToFile(strBuilder);
    }


    /**
     * Class {@code Object} is the root of the class hierarchy.
     * * Every class has {@code Object} as a superclass. All objects,
     * including arrays, implement the methods of this class.
     *
     * @throws IOException
     */

    public static float convertByteToKilobyte(long number) {
        return (float) number / 1024;
    }
}
