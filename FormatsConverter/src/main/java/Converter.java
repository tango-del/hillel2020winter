import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Converter {

    private static StringBuilder str = new StringBuilder();
    //append(System.lineSeparator()) - добавляет новую строку

    public static void convert(String path) throws IOException {

        File filePath = new File(path);

        FileCreator.checkDirExists(path);

        Arrays.stream(filePath.listFiles())
                .filter(File::isFile)
                .filter(file -> file.getName().contains(".json") || file.getName().contains(".yaml"))
                .map(File::getPath)
                .forEach(f -> {
                    String fileName = new File(f.split("[.]", 0)[0]).getName();
                    try {
                        if (f.contains(".json")) {
                            converterJson(f, fileName);

                        } else if (f.contains(".yaml")) {

                            converterYaml(f, fileName);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        FileCreator.writeToFile(str);
//        Arrays.stream(filePath.listFiles()) //в стрим вызывается File с заданны путём у которого вызыввается список всех файлов
//                .filter(File::isFile) // фильтрация файлов, без директорий
//                .filter(file -> file.getName().contains(".yaml")) // фильтрация заданых форматов файлов
//                .map(File::getPath)
//                .forEach(f -> {
//                    try {
//                        String fileName = new File(f.split("[.]", 0)[0]).getName();
//                        converterYaml(f, fileName);
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                });
//
//        Arrays.stream(filePath.listFiles())
//                .filter(File::isFile)
//                .filter(file -> file.getName().contains(".json"))
//                .map(File::getPath)
//                .forEach(f -> {
//                    try {
//                        String fileName = new File(f.split("[.]", 0)[0]).getName();
//                        converterJson(f, fileName);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                });
    }


    /**
     * Class {@code Object} is the root of the class hierarchy.
     * * Every class has {@code Object} as a superclass. All objects,
     * including arrays, implement the methods of this class.
     *
     * @throws IOException
     */
    private static void converterJson(String pathJson, String fileName) throws IOException {
        Instant start = Instant.now();

        String json = ReadFile.readToString(pathJson);

        ObjectMapper objectMapper2 = new ObjectMapper();

        JsonNode jsonNode = objectMapper2.readTree(json);

        File file = FileCreator.checkFileExists(fileName + ".yaml");

        File fileJson = new File(pathJson);

        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillis();

        str.append("Start convert Json to Yaml: ").append(fileName).append(".json ").append("--> ").append(fileName).append(".yaml")
                .append(System.lineSeparator())
                .append(convertByteToKilobyte(fileJson.length())).append(" KB - size original file")
                .append(System.lineSeparator())
                .append(convertByteToKilobyte(file.length())).append(" KB - size new file")
                .append(System.lineSeparator())
                .append("Time spend: ")
                .append(timeElapsed)
                .append(System.lineSeparator())
                .append("------------")
                .append(System.lineSeparator());


        new YAMLMapper().writeValue(file, jsonNode);

    }

    private static void converterYaml(String pathYaml, String fileName) throws IOException {
        Instant start = Instant.now();

        String yam = ReadFile.readToString(pathYaml);

        ObjectMapper objectMapper = new ObjectMapper();

        Yaml yaml = new Yaml();

        Object objectYaml = yaml.load(yam);

        File fileYaml = new File(pathYaml);

        File file = FileCreator.checkFileExists(fileName + ".json");

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, objectYaml);

        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillis();

        str.append("Start convert Yaml to Json: ").append(fileName).append(".yaml ").append("--> ").append(fileName).append(".json")
                .append(System.lineSeparator())
                .append(convertByteToKilobyte(fileYaml.length())).append(" KB - size original file")
                .append(System.lineSeparator())
                .append(convertByteToKilobyte(file.length())).append(" KB - size new file")
                .append(System.lineSeparator())
                .append("Time spend: ")
                .append(timeElapsed)
                .append(System.lineSeparator())
                .append("------------")
                .append(System.lineSeparator());
    }

    private static double convertByteToKilobyte(long number) {
        return (double) number / 1000;
    }
}
