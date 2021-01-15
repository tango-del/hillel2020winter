package FormatingFile;

import FileCreatings.FileWork;
import Interfaces.FormatConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class YamlToJson implements FormatConverter {

    private static FileWork fileWork = new FileWork();

    @Override
    public void convertFile(String pathFile, String fileName, StringBuilder strBuilder) throws IOException {
        Instant start = Instant.now();

//        String yam = ReadFile.readToString(pathYaml);
        String yam = fileWork.readFileToString(pathFile);

        ObjectMapper objectMapper = new ObjectMapper();

        Yaml yaml = new Yaml();

        Object objectYaml = yaml.load(yam);

        File fileYaml = new File(pathFile);

        File file = fileWork.createFileWithExt(fileName + ".json");

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, objectYaml);

        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillis();

        strBuilder.append("Start convert Yaml to Json: ").append(fileName).append(".yaml ").append("--> ").append(fileName).append(".json")
                .append(System.lineSeparator())
                .append(Converter.convertByteToKilobyte(fileYaml.length())).append(" KB - original file size")
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
