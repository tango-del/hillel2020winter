package FileCreatings;

import Interfaces.FileInterface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Класс имплементирует интерфейс работой с файлами
 */
public class FileWork implements FileInterface {

    private static File dirConverted;

    private static BufferedWriter writer;

    private static File fileResult;

    /**
     * Метод создаёт объект File у которого путь указан в @path имя файла указанно в @fileDir
     *
     * Проверка на то что данный файл не создан, если true то создаёт его в системе
     *
     * @param path - в качестве строки хранит абсолютную директорию в соответствии
     * той системы на которой запускается программа
     * @throws IOException
     */
    @Override
    public void createFileDir(String path) throws IOException {
        String fileDir = "converted";

        dirConverted = new File(path, fileDir);

        if (!dirConverted.exists()) {
            dirConverted.mkdir();
        }
    }

    /**
     * Метод создаёт File в качестве директории используется @dirConverted
     * где будут храниться все новые файлы, имя файла берётся у @fileName
     *
     * Проверка на то что данный файл не создан, если true то создаёт его в системе
     *
     * @param fileName - хранит в с себе название с файла с раширением
     * @return - возвращает ссылку на созданный файл в указанной директории
     * @throws IOException
     */
    @Override
    public File createFileWithExt(String fileName) throws IOException {
        File file = new File(dirConverted, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    // TODO Объяснить еще раз что делает метод
    @Override
    public String readFileToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    /**
     * Метод создаёт File @fileResult с названием строки @param resultTxt
     * в директории которая хранится в объекте класса @dirConverted
     * После проверяет на отсутствие, если true то создаёт его.
     * @throws IOException
     */
    @Override
    public void createFileResultTxt() throws IOException {

        String resultTxt = "result.txt";

        fileResult = new File(dirConverted, resultTxt);

        if (!fileResult.exists()) {
            fileResult.createNewFile();
        }
    }

    /**
     * Метод сперва создаёт файл @createFileResultTxt
     *
     * После создаёт объект класса @BufferedWriter что бы записать текст в поток вывода символов
     * в конструкторе создаётся объект @FileWriter который записывает поток символов в указанны
     * File @fileResult который хранит в себе путь каталога и название файла.
     *
     * После записывает поток символов из StringBuilder @str
     * который переводит в String. В конце закрывает поток.
     *
     * @param str - Хранит в себе строку для записи в файл
     * @throws IOException
     */
    @Override
    public void writeToFile(StringBuilder str) throws IOException {
        try {
            createFileResultTxt();
            writer = new BufferedWriter(new FileWriter(fileResult));
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.write(str.toString());
        writer.close();
    }
}
