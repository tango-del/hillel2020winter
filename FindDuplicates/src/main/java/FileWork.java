import Interfaces.FileInterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWork implements FileInterface {

    private static BufferedWriter writer;

    private static File fileResult;

    /**
     * Метод создаёт @File в котором путь указан @directory и именем указанным в String @resultTxt
     * Проверяет что такой файл отсутствует, если да то создаёт.
     *
     * @param directory - хранит путь к директории где будет создаваться файл result
     * @throws IOException
     */

    public void createFileResultTxt(File directory) throws IOException {
        String resultTxt = "result.txt";

        fileResult = new File(directory, resultTxt);

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
     * @param directory - хранит путь к директории где будет создаваться файл result
     * @param str - хранит строки которые запишуться в result.txt
     * @throws IOException
     */

    public void writeToFile(File directory, StringBuilder str) throws IOException {
        try {
            createFileResultTxt(directory);
            writer = new BufferedWriter(new FileWriter(fileResult));
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.write(str.toString());
        writer.close();
    }
}
