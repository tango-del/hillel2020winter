import FormatingFile.Converter;
import java.io.IOException;
import java.nio.file.FileSystems;

public class StartProgram {
    /**
     * Метод начинает работу программы конвертации файлов: .json <---> .yaml
     *
     * Используются библиотеки:
     * - jackson-core
     * - jackson-databind
     * - gson
     * - jackson-dataformat-yaml
     * - snakeyaml
     *
     * Для сборки в jar используется:
     * - maven-assembly-plugin
     *
     * @param args - если в аргументы программы не указан путь директории
     * то используется директория где лежит файл .jar файл.
     * Иначе используется указанная директория в аргументе
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String path; //C:\Users\Tango\Desktop\example
        if (args.length == 0) {
            path = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        } else {
            path = args[0];
        }

        Converter.convert(path);
    }
}
