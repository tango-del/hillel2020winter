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
     * Метод создаёт HashMap<String, List<String>> @lists
     * fillHashMap записывает в @lists key - имя файла value - список строк с абсолютными путями к файлам.
     * removeAlone удаляет у @lists ключи в которых длина списка строк равна 1.
     * Создаётся список @pathsFileNameAndSizeDuplicates
     * deleteFilesWithDifferentSize возвращает ссылку на список в котором записаны пути к файлам с одинаковым размеров и именами.
     * filterHashSum - возвращает ссылку на список в котором записаны пути к файлам с одинаковой контрольной суммой @MD5
     * @strBuilder - прикрепит в себя каждую строку List @pathsFileNameAndSizeDuplicates
     * writeToFile создаст тектсовый файл result.txt в который запишет содержимое @strBuilder
     *
     * @param pathWhereNeedToScan - в качестве строки хранит директорию где будет производиться поиск
     * @throws IOException
     * @throws NoSuchAlgorithmException
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

        pathsFileNameAndSizeDuplicates = filesFinder.filterHashSum(pathsFileNameAndSizeDuplicates);

//        List<String> pathsFileCheckSumDuplicates = filesFinder.filterHashSum(pathsFileNameAndSizeDuplicates);

        pathsFileNameAndSizeDuplicates.forEach(u -> strBuilder.append(u).append(System.lineSeparator()));
        fileWork.writeToFile(directory, strBuilder);
    }
}
