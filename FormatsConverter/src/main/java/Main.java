import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Arrays;

/**
 * TODO Написать приложение которое производит конвертаций форматов Json <--> Yaml:
 *  - на вход приложения в виде аргумента программы принимаем расположение директор, если аргумент отсутствует то происходит анализ текущей папки +
 *  - валидируем формат (YAML, JSON) +
 *  - сохраняем полученный файл в папке converted (старое имя + новое расширение) +
 *  - результаты конвертации сохраняем в файле result.txt в формате
 *  - имя_файла -> новое_имя_файла, длительность конвертации, старый размер -> новый размер
 *  если конвертация не возможно надо записать что файл не сконвертировался
 *  Результатом должен быть jar file исполняемый, заготовку для проекта можно взять с урока 18
 */

public class Main {
    public static void main(String[] args) throws IOException {

        /*
        если в аргументы программы не указан путь директории то используется директория где лежит файл .jar
        иначе используется указанная директория в аргументе
         */

        String path; //C:\Users\Tango\Desktop\example
        if (args.length == 0) {
            path = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        } else {
            path = args[0];
        }

        Converter.convert(path);

        /*
        set потому что файлы не могут иметь одинаковых названий с расширениями, только уникальные

        Set<String> listPathFilesYaml = Stream.of(new File(path).listFiles())
                .filter(File::isFile)
                .filter(file -> file.getName().contains(".yaml"))
                .map(File::getPath)
                .collect(Collectors.toSet());

        Set<String> listPathFilesJson = Stream.of(new File(path).listFiles())
                .filter(File::isFile)
                .filter(file -> file.getName().contains(".json"))
                .map(File::getPath)
                .collect(Collectors.toSet());

         */
    }
}
