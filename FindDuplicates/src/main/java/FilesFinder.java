import Interfaces.SearchFiles;
import Interfaces.SystemRules;
import OperationSystems.Linux;
import OperationSystems.Mac;
import OperationSystems.Windows;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Stream;

public class FilesFinder implements SearchFiles {

    private static SystemRules systemRules;

    public static void chooseOperationSystem(String OS) throws IOException {
        switch (OS) {
            case "Windows":
                systemRules = new Windows();
                systemRules.writePropValuesToStrings();
                break;
            case "Linux":
                systemRules = new Linux();
                systemRules.writePropValuesToStrings();
                break;
            case "Mac":
                systemRules = new Mac();
                systemRules.writePropValuesToStrings();
                break;
            default:
                throw new RuntimeException("OS not support");
        }
    }

    /**
     * Метод проходит по массиву @directory.listFiles
     * Первая проверка является ли файл скрытым и его можно прочитать.
     * Дальше у каждого файла в массиве происходит проверка что этот файл является директорией а не файлом, если ответ @true тогда вызывается @recursive этого же метода
     * в который передаётся этот же файл (директория).
     * <p>
     * Если ответ @false - тогда создаётся List<String> @identicalList который запрашивает ссылку на List у @filesList по указаному ключу.
     * <p>
     * Если HashMap возвращает null -> тогда такого ключа нету, @identicalList инициализируется и в него добавляется абсолютьный путь к фалу.
     * <p>
     * После в @filesList добавляется новый key и value
     *
     * @param filesList - HashMap: key -> имя файла, value -> List<String> абсолютный путь к файлу
     * @param directory - директория в которой будет происходить анализ всех файлов
     */
    @Override
    public void fillHashMap(Map<String, List<String>> filesList, File directory) throws FileNotFoundException {

        Arrays.stream(directory.listFiles())
                .filter(file -> Files.isReadable(file.toPath()))
                .filter(file -> !file.isHidden())
                .filter(file -> {
                    try {
                        return systemRules.systemExclusionRules(file.getName());
                    } catch (IOException e) {
                        throw new RuntimeException();
                    }
                })
                .forEach(file ->
                {
                    if (file.isDirectory()) {
//                        System.out.println("dir -> " + file);
                        try {
                            fillHashMap(filesList, file);
                        } catch (FileNotFoundException e) {
                            System.out.println("invalid file");
                        }
                    } else {
//                        System.out.println("file -> " + file);
                        String fileName = file.getName();
                        List<String> identicalList = filesList.get(fileName);
                        if (identicalList == null) {
                            identicalList = new ArrayList<>();
                        }
                        identicalList.add(file.getPath());
                        filesList.put(fileName, identicalList);
                    }
                });
    }

//        for (File file : directory.listFiles()) {
//
//
//            if (file != null | !file.isHidden() | file.canRead()) {
//
//                if (file.isDirectory()) {
//                    fillHashMap(filesList, file);
//
//                } else {
//                    String fileName = file.getName();
//                    List<String> identicalList = filesList.get(fileName);
//                    if (identicalList == null) {
//                        identicalList = new ArrayList<>();
//                    }
//                    identicalList.add(file.getPath());
//                    filesList.put(fileName, identicalList);
//                }
//            }
//        }

    /**
     * Метод ищет файлы с одинаковыми размерами и записывает их абсолютные пути в List<String> @fileDuplicates.
     * <p>
     * Создаётся HashMap @newMap в котором key - размер файла, value - список с путями к файлам
     * foreach проходит по всем @values у @filesList
     * внутренний foreach проходит по каждому списку, итерация каждой строки в котором записан абсолютный путь к файлу.
     *
     * @param filesList - HashMap: key -> имя файла, value -> List<String> абсолютный путь к файлу
     * @return - List<String> fileDuplicates - общий список всех абсолютных путуй к файлам которые имеют одинаковое имя с расширением и одниковый размер.
     * @throws IOException
     * @fileSize - записывает в себя размер файла в байтах по указанному пути.
     * Cоздаётся List<String> @identicalList который запрашивает ссылку на List у @newMap по указаному ключу.
     * Если HashMap возвращает null -> тогда такого ключа нету, @identicalList инициализируется и в него добавляется абсолютьный путь к фалу.
     * После в @newMap добавляется новый key и value
     * @fileSize - записывает в себя размер файла в байтах у файла в указанном пути
     */
    @Override
    public List<String> deleteFilesWithDifferentSize(Map<String, List<String>> filesList) throws IOException {

        Map<Long, List<String>> newMap = new HashMap<>();

        for (List<String> list : filesList.values()) {
            for (String s : list) {
                long fileSize = Files.size(Paths.get(s));
                List<String> identicalList = newMap.get(fileSize);
                if (identicalList == null) {
                    identicalList = new ArrayList<>();
                }
                identicalList.add(s);
                newMap.put(fileSize, identicalList);
            }
        }

        List<String> fileDuplicates = filterSingleValuesInHashMap(newMap);

        return fileDuplicates;
    }


    /**
     * Метод проходит через весь @filesList, удаляет все ключи которые удовлетворяют предикат.
     * Условие предиката - длина значения List<String> равна 1
     * Если у списка 1 элемент - означает файлов с таким именем только 1, имя файла содержиться в key
     *
     * @param filesList - HashMap: key -> имя файла, value -> List<String> абсолютный путь к файлу
     */
    @Override
    public void removeAlone(Map<String, List<String>> filesList) {
        filesList.entrySet().removeIf(key -> key.getValue().size() == 1);
    }

    /**
     * Метод проходит foreach @newList
     *
     * @param newList - общий список всех абсолютных путуй к файлам которые имеют одинаковое имя с расширением и одниковый размер
     * @return - общий список путей к файлам с одинаковыми контрольными суммами MD5
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @fileData записывает байты в виде массива с помощью FileInputStream и закрывает вконце поток.
     * @uniqueFileHash записывает в 16-тиричной системой счисления контрольную сумму файла.
     * <p>
     * Cоздаётся List<String> @identicalList который запрашивает ссылку на List у @newMap по указаному ключу.
     * Если HashMap возвращает null -> тогда такого ключа нету, @identicalList инициализируется и в него добавляется абсолютьный путь к фалу.
     * После в @newMap добавляется новый key и value
     */
    @Override
    public List<String> filterHashSum(List<String> newList) throws IOException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        Map<String, List<String>> newMap = new HashMap<>();


        for (String str : newList) {
            FileInputStream fileInput = new FileInputStream(str);
            byte[] fileData = new byte[(int) new File(str).length()];
            fileInput.read(fileData);
            fileInput.close();

            String uniqueFileHash = new BigInteger(1, messageDigest.digest(fileData)).toString(16);

            List<String> identicalList = newMap.get(uniqueFileHash);
            if (identicalList == null) {
                identicalList = new ArrayList<>();
            }
            identicalList.add(str);
            newMap.put(uniqueFileHash, identicalList);
        }

        List<String> fileDuplicates = filterSingleValuesInHashMap(newMap);

        return fileDuplicates;
    }

    /**
     * Метод создаёт список @fileDuplicates в который запишет значения всех других массивов у которых длина больше 1
     *
     * @param newMap - HashMap key - типизированный тип данных, value - список строк с абсолютными путями
     * @param <E>
     * @return
     */
    private static <E> List<String> filterSingleValuesInHashMap(Map<E, List<String>> newMap) {
        List<String> fileDuplicates = new ArrayList<>();
        for (List<String> files : newMap.values()) {
            if (files.size() > 1) {
                fileDuplicates.addAll(files);
            }
        }
        return fileDuplicates;
    }
}
