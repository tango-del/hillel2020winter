import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 1. Прошел по всем директориям вниз:
 * - собрал бы все имена файлов в мапу Map<String, List<String>> = Map<ИмяФайла. List<Путей к файлу с таким именем>>
 * - отфильтровать оставив в мапе только те файла где лист содержит не один элемент
 * <p>
 * 2. пройтись по ставленой коллекции и проверить размер файлов если размер не совпадает то файлы разные - удалить из коллекции то что не совпадают
 * https://mkyong.com/java/how-to-get-file-size-in-java/
 * <p>
 * 3. и уже у оставшихся фалой вычислять контрольную сумму
 * https://www.baeldung.com/java-checksums
 * <p>
 * Mkyong.com (https://mkyong.com/java/how-to-get-file-size-in-java/)
 * How to get file size in Java - Mkyong.com
 * In Java, we can use `Files.size` to get the size of a file in bytes.
 * <p>
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
     * @param pathWhereNeedToScan - в качестве строки хранит директорию где будет производиться поиск
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @fillMapValuesToSetCollection - вернёт ссылку на Set<String> в котором будут записаны абсолютные пути к файлам
     * @strBuilder - прикрепит себе все String в коллекции Set @filePaths
     * <p>
     * Вызывает метод @writeToFile который создаст текстовый файл result.txt в указанной директории
     * и запишет в него содержимое @strBuilder
     */
    public static void init(String pathWhereNeedToScan) throws IOException, NoSuchAlgorithmException {
        FilesFinder filesFinder = new FilesFinder();
        FileWork fileWork = new FileWork();
        StringBuilder strBuilder = new StringBuilder();

        File directory = new File(pathWhereNeedToScan);

        Map<String, List<String>> lists = new HashMap<>();

        filesFinder.fillHashMap(lists, directory);

        filesFinder.removeAlone(lists);

        List<String> pathsFileNameAndSizeDuplicates = filesFinder.deleteFilesWithDifferentSize(lists);

        List<String> pathsFileDuplicates = filesFinder.filterHashSum(pathsFileNameAndSizeDuplicates);

        pathsFileDuplicates.forEach(System.out::println);

//        pathsFileDuplicates.forEach(i -> {
//            strBuilder.append(i)
//                    .append(System.lineSeparator());
//        });

        //fileWork.writeToFile(directory, strBuilder);
    }
}
