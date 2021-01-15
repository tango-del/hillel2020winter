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

    @Override
    public void createFileDir(String path) throws IOException {
        String fileDir = "converted";

        dirConverted = new File(path, fileDir);

        if (!dirConverted.exists()) {
            dirConverted.mkdir();
        }
    }

    @Override
    public File createFileWithExt(String fileName) throws IOException {
        File file = new File(dirConverted, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

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
     * Метод создаёт файл с названием строки @param resultTxt
     * в директории которая хранится в объекте класса @File dirConverted
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
     * Метод
     *
     * @param str - Хранит в себе текст для записи в файл
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
