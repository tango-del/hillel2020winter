import OperationSystems.OsDetector;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Программа ищет дубликаты файлов. Если в аргументах программы не записан путь директории тогда применяется директория где будет хранится .jar файл
 * В этой же директории создаётся result.txt файл в котором будут записаны абсолютные пути к файлам дубликатам
 */
@Slf4j
public class StartProgram {

    public static void main(String[] args) {
        String pathWhereNeedToScan;

        log.info(">-----PROGRAM START----<");

        if (args.length == 0) {
            log.info("You didn't choose any directory. So I copied the path where the jar file is located");
            pathWhereNeedToScan = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        } else {
            pathWhereNeedToScan = args[0];
            log.info("You choose path: " + pathWhereNeedToScan);
        }

        try {
            init(pathWhereNeedToScan);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        log.info(">----PROGRAM FINISH----<");
    }

    /**
     * Метод создаёт HashMap<String, List<String>> @lists
     * fillHashMap записывает в @lists key - имя файла value - список строк с абсолютными путями к файлам.
     * removeAlone удаляет у @lists ключи в которых длина списка строк равна 1.
     * Создаётся список @pathsFileNameAndSizeDuplicates
     * deleteFilesWithDifferentSize возвращает ссылку на список в котором записаны пути к файлам с одинаковым размеров и именами.
     * filterHashSum - возвращает ссылку на список в котором записаны пути к файлам с одинаковой контрольной суммой @MD5
     *
     * @param pathWhereNeedToScan - в качестве строки хранит директорию где будет производиться поиск
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @strBuilder - прикрепит в себя каждую строку List @pathsFileNameAndSizeDuplicates
     * writeToFile создаст тектсовый файл result.txt в который запишет содержимое @strBuilder
     */
    private static void init(String pathWhereNeedToScan) throws IOException, NoSuchAlgorithmException, InterruptedException {
        FilesFinder filesFinder = new FilesFinder();
        FileWork fileWork = new FileWork();
        StringBuilder strBuilder = new StringBuilder();
        File directory = new File(pathWhereNeedToScan);
        List<String> pathsFileNameAndSizeDuplicates;

        log.info("Detecting your Operation System");
        Thread.sleep(2500);

        String OS = OsDetector.detectSystem();

        log.info("Your system is " + OS);

        FilesFinder.chooseOperationSystem(OS);

        Thread.sleep(2500);

        log.info("Start fill HashMap (filename, file path) with all files");

        Map<String, List<String>> lists = new HashMap<>();

        try {
            filesFinder.fillHashMap(lists, directory);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        log.info(">Done<");

        Thread.sleep(2500);

        log.info("Start removing all single values in HashMap");

        filesFinder.removeAlone(lists);

        Thread.sleep(2500);

        log.info(">Done<");

        log.info("Start searching Files with same Name and Size");

        pathsFileNameAndSizeDuplicates = filesFinder.deleteFilesWithDifferentSize(lists);

        log.info(">Done<");

        Thread.sleep(2500);

        log.info("Start search Files with same Checksum MD5");

        pathsFileNameAndSizeDuplicates = filesFinder.filterHashSum(pathsFileNameAndSizeDuplicates);

        log.info(">Done<");

        Thread.sleep(2500);

        log.info("Start writing file list in result.txt");

//        pathsFileNameAndSizeDuplicates.forEach(System.out::println);

        strBuilder.append("Total duplicated Files : ").append(pathsFileNameAndSizeDuplicates.size()).append(System.lineSeparator());
        pathsFileNameAndSizeDuplicates.forEach(u -> strBuilder.append(u).append(System.lineSeparator()));
        fileWork.writeToFile(directory, strBuilder);

        log.info(">Done<");

        log.info("Total File Duplicates : " + pathsFileNameAndSizeDuplicates.size());
    }
}
