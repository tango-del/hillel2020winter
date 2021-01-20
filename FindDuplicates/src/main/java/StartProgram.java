import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Программа ищет дубликаты файлов. Если в аргументах программы не записан путь директории тогда применяется директория где будет хранится .jar файл
 * В этой же директории создаётся result.txt файл в котором будут записаны абсолютные пути к файлам дубликатам
 */
public class StartProgram {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String pathWhereNeedToScan;

        System.out.println(">-----PROGRAM START----<");

        if (args.length == 0) {
            System.out.println("You didn't choose any directory. So I copied the path where the jar file is located");
            pathWhereNeedToScan = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        } else {
            pathWhereNeedToScan = args[0];
            System.out.println("You choose path: " + pathWhereNeedToScan);
        }

        init(pathWhereNeedToScan);

        System.out.println(">----PROGRAM FINISH----<");
    }

    /**
     * Метод создаёт HashMap<String, List<File>> @lists, Set<String> @filePaths и StringBuilder
     * Вызывает @findAndSaveDuplicateFilesInHashMap в который отправляет ссылку на HashMap и директорию где будут сканироваться файлы.
     * В HashMap запишуться значение со списками файлов дубликатов.
     *
     * @fillMapValuesToSetCollection - вернёт ссылку на Set<String> в котором будут записаны абсолютные пути к файлам
     *
     * @strBuilder - прикрепит себе все String в коллекции Set @filePaths
     *
     * Вызывает метод @writeToFile который создаст текстовый файл result.txt в указанной директории
     * и запишет в него содержимое @strBuilder
     *
     * @param pathWhereNeedToScan - в качестве строки хранит директорию где будет производиться поиск
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static void init(String pathWhereNeedToScan) throws NoSuchAlgorithmException, IOException {
        FilesFinder filesFinder = new FilesFinder();
        FileWork fileWork = new FileWork();
        StringBuilder strBuilder = new StringBuilder();
        File directory = new File(pathWhereNeedToScan);
        Map<String, List<File>> lists = new HashMap<>();

        filesFinder.findAndSaveDuplicateFilesInHashMap(lists, directory);

        Set<String> filePaths = filesFinder.fillMapValuesToSetCollection(lists);

        filePaths.forEach(i -> {
            strBuilder.append(i)
                    .append(System.lineSeparator());
        });

        fileWork.writeToFile(directory, strBuilder);
    }
}
