package lesson17;

import lesson17.interfaces.FilesGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileCreator implements FilesGenerator {
    // хранит полную локальную дату времени компьютера
    private static final LocalDateTime currentDateTime = LocalDateTime.now();
    // форматирует локальную дату по указанным ключам
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
    // название файла куда будут записываться результаты выполнения программы (имя файла включает отформатированное локальное время)
    private static final String nameFile = "result-" + currentDateTime.format(formatter) + ".txt";
    // строка с директорией где будет создаваться файл с результатами выполнения программы
    private static final String dirWhereSaveFile = "lessons/src/lesson17/results";
    // Файл который хранит директорию заданную в @String dirWhereSaveFile
    private static final File makeDirectoryToSaveResults = new File(dirWhereSaveFile);
    // Файл который хранит файл заданный в @String nameFile в директории @File makeDirectoryToSaveResults
    private static final File fileResults = new File(makeDirectoryToSaveResults, nameFile);
    private static BufferedWriter writer;

    /**
     * Метод проверяет наличие файла куда будет записываться результат выполнения программы,
     * а так же проверяет наличие каталога где будет хранится этот файл.
     * Создаёт объект класса @BufferedWriter что бы записать текст в поток вывода символов
     * в конструкторе создаётся объект @FileWriter который записывает поток символов в указанны
     * File @fileResults который хранит в себе путь каталога и название файла
     *
     * @throws IOException
     */
    @Override
    public void checkFilesExists() throws IOException {
        // проверка существует ли директория, если нет то создаёт
        if (!makeDirectoryToSaveResults.exists()) {
            makeDirectoryToSaveResults.mkdir();
        }

        // проверка существует ли файл с заданным именем, если нет то создаёт
        if (!fileResults.exists()) {
            fileResults.createNewFile();
        }

        try {
            writer = new BufferedWriter(new FileWriter(fileResults));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод записывает поток символов из StringBuilder @str
     * который переводит в String. В конце закрывает поток.
     *
     * @throws IOException
     */
    @Override
    public void writeToFile(StringBuilder str) throws IOException {
        writer.write(str.toString());
        writer.close();
    }
}
