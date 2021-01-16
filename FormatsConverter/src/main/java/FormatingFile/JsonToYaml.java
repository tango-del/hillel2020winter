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

/**
 * Класс конвертирует формат json в формат yaml
 */
public class JsonToYaml implements FormatConverter {

    private static FileWork fileWork = new FileWork();

    /**
     * Метод записывает в строку @json содержимое файла по указанному @pathFile
     * @jsonNode - записывает обёрнутый Object в Map Tree ??
     * File @file записывает файл с именем @fileName и указанным расширением
     * File @fileJson записывает директорию которая хранится в виде строки @pathFile
     * У объекта @yamlMapper вызывается метод считывание значений у @jsonNode и записывает в File @file
     *
     * @timeElapsed записывает разницу времени которая была затрачена на конвертацию из одного файла в другой с его созданием
     *
     * В конце указанные данные записываются в StringBuilder
     *
     * @param pathFile - абсолютный путь к файлу
     * @param fileName - имя файла без расширения
     * @param strBuilder - динамическая запись строк без перезаписи ссылок
     * @throws IOException
     */
    @Override
    public void convertFile(String pathFile, String fileName, StringBuilder strBuilder) throws IOException {
        Instant start = Instant.now();

        YAMLMapper yamlMapper = new YAMLMapper();

        String json = fileWork.readFileToString(pathFile);

        ObjectMapper objectMapper2 = new ObjectMapper();

        JsonNode jsonNode = objectMapper2.readTree(json);

        File file = fileWork.createFileWithExt(fileName + ".yaml");

        File fileJson = new File(pathFile);

        yamlMapper.writeValue(file, jsonNode);

        Instant finish = Instant.now();

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
