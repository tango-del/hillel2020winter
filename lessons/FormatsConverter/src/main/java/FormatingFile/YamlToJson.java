package FormatingFile;

import FileCreatings.FileWork;
import Interfaces.FormatConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

/**
 * Класс конвертирует формат yaml в формат json
 */
public class YamlToJson implements FormatConverter {

    private static FileWork fileWork = new FileWork();

    /**
     * Метод записывает в строку @yam содержимое файла по указанному @pathFile
     * *
     * Программа не знает какой тип данных записан в yaml поэтому используется
     * Class Object который является родителем в иерархии классовю
     * *
     * В @objectYaml записывается строка @yam c помощью Yaml @yaml метод load
     * File @fileYaml записывает директорию которая хранится в виде строки @pathFile
     * File @file записывает файл с именем @fileName и указанным расширением,
     * в него записываются значение у @objectYaml
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
