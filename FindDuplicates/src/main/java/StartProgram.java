import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. Прошел по всем директориям вниз:
 * - собрал бы все имена файлов в мапу Map<String, List<String>> = Map<ИмяФайла. List<Путей к файлу с таким именем>>
 * - отфильтровать оставив в мапе только те файла где лист содержит не один элемент
 *
 * 2. пройтись по ставленой коллекции и проверить размер файлов если размер не совпадает то файлы разные - удалить из коллекции то что не совпадают
 * https://mkyong.com/java/how-to-get-file-size-in-java/
 *
 * 3. и уже у оставшихся фалой вычислять контрольную сумму
 * https://www.baeldung.com/java-checksums
 *
 * Mkyong.com (https://mkyong.com/java/how-to-get-file-size-in-java/)
 * How to get file size in Java - Mkyong.com
 * In Java, we can use `Files.size` to get the size of a file in bytes.
 *
 * Программа ищет дубликаты файлов. Если в аргументах программы не записан путь директории тогда применяется директория где будет хранится .jar файл
 * В этой же директории создаётся result.txt файл в котором будут записаны абсолютные пути к файлам дубликатам
 */
public class StartProgram {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
//        String pathWhereNeedToScan;
//
//        System.out.println(">-----PROGRAM START----<");
//
//        if (args.length == 0) {
//            System.out.println("You didn't choose any directory. So I copied the path where the jar file is located");
//            pathWhereNeedToScan = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
//        } else {
//            pathWhereNeedToScan = args[0];
//            System.out.println("You choose path: " + pathWhereNeedToScan);
//        }

        //init(pathWhereNeedToScan);

        Map<String, List<String>> filesList = new HashMap<>();

        File directory = new File("C:\\Users\\Tango\\Desktop\\example");

        fillHashMap(filesList, directory);

        removeAlone(filesList);

//        List<String> newList = deleteFilesWithDifferentSize(filesList);

        deleteFilesWithDifferentSize(filesList);

        System.out.println(">----PROGRAM FINISH----<");
    }

    /**
     * Прошел по всем директориям вниз:
     * - собрал бы все имена файлов в мапу Map<String, List<String>> = Map<ИмяФайла. List<Путей к файлу с таким именем>>
     */
    public static void fillHashMap(Map<String, List<String>> filesList, File directory) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                fillHashMap(filesList, file);
            } else {
                List<String> identicalList = filesList.get(file.getName());
                if (identicalList == null) {
                    identicalList = new ArrayList<>();
                }
                identicalList.add(file.getPath());
                filesList.put(file.getName(), identicalList);
            }
        }
    }
    /**
     * - отфильтровать оставив в мапе только те файла где лист содержит не один элемент
     */
    public static void removeAlone(Map<String, List<String>> filesList) {
        filesList.entrySet().removeIf(key -> key.getValue().size() == 1);
    }

    /**
     * 2. пройтись по ставленой коллекции и проверить размер файлов если размер не совпадает то файлы разные - удалить из коллекции то что не совпадают
     */
    public static void deleteFilesWithDifferentSize(Map<String, List<String>> filesList) throws IOException {
        /*
        TODO сделать скрин кода + дебаг, узнать как реализовывать поиск дубликатов по размеру
         спросить  List<String> или List<File>

         https://javadeveloperzone.com/java-basic/java-find-duplicate-objects-in-list/

         https://javarevisited.blogspot.com/2015/06/3-ways-to-find-duplicate-elements-in-array-java.html

         https://stackoverflow.com/questions/7414667/identify-duplicates-in-a-list
         */
        List<String> newList = new ArrayList<>();

        Set<Long> temp = new HashSet<>();

        for (List<String> list : filesList.values()) {

//            int[] a = { 1, 1, 2, 3, 5, 8, 13, 13 };
//            List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
//
//            for (Integer ch : list) {
//                System.out.println(ch + " :  " + Collections.frequency(list, ch));
//            }

            for (String i : list) {
                System.out.println(i + " :  " + Collections.frequency(list, i));
            }

            list.parallelStream().filter(f -> {
                try {
                    return !temp.add(Files.size(Paths.get(f)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }).forEach(newList::add);

//            for (int i = 0; i < list.size() - 1; i++) {
//                Path path = Paths.get(list.get(i));
//
//                if (!temp.add(Files.size(path))) {
//                    newList.add(list.get(i));
//                }
//
//                for (int j = i + 1; j < list.size(); j++) {
//                    Path path = Paths.get(list.get(i));
//
//                    Path path1 = Paths.get(list.get(j));
//
//                    if (!temp.add(Files.size(path)) || !temp.add(Files.size(path1))) {
//
//                    }
//
//                    if (Files.size(path) == Files.size(path1)) {
//
//                    }
//
//                }
//
//            }


//            list.stream().forEach(str -> {
//                Path path = Paths.get(str);
//            });
        }
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
