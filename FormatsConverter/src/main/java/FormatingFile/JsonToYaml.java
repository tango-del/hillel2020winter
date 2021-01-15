package FormatingFile;

import FileCreatings.FileWork;
import Interfaces.FormatConverter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class JsonToYaml implements FormatConverter {

    private static FileWork fileWork = new FileWork();

    @Override
    public void convertFile(String pathFile, String fileName, StringBuilder strBuilder) throws IOException {
        Instant start = Instant.now();

        YAMLMapper yamlMapper = new YAMLMapper();

//        String json = ReadFile.readToString(pathJson);
        String json = fileWork.readFileToString(pathFile);

        ObjectMapper objectMapper2 = new ObjectMapper();

        JsonNode jsonNode = objectMapper2.readTree(json);

//        File file = FileCreator.checkFileExists(fileName + ".yaml");
        File file = fileWork.createFileWithExt(fileName + ".yaml");

        File fileJson = new File(pathFile);

        Instant finish = Instant.now();

        yamlMapper.writeValue(file, jsonNode);

        long timeElapsed = Duration.between(start, finish).toMillis();

        strBuilder.append("Start convert Json to Yaml: ").append(fileName).append(".json ").append("--> ").append(fileName).append(".yaml")
                .append(System.lineSeparator())
                .append(Converter.convertByteToKilobyte(fileJson.length())).append(" KB - original file size")
                .append(System.lineSeparator())
                .append(Converter.convertByteToKilobyte(file.length())).append(" KB - new file size")
                .append(System.lineSeparator())
                .append("Time spend: ")
                .append(timeElapsed)
                .append(System.lineSeparator())
                .append("------------")
                .append(System.lineSeparator());


    }
}
