import Interfaces.SearchFiles;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class FilesFinder implements SearchFiles {

    /**
     * Метод проходит по массиву @File listFiles.
     * У каждого файла в массиве происходит проверка что этот файл является директорией а не файлом, если ответ @true тогда вызывается @recursive этого же метода
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
    public void fillHashMap(Map<String, List<String>> filesList, File directory) {

        for (File file : directory.listFiles()) {

            if (!file.isHidden() && file.canRead()) {
                if (file.isDirectory()) {
                    fillHashMap(filesList, file);
                } else {
                    String fileName = file.getName();
                    List<String> identicalList = filesList.get(fileName);
                    if (identicalList == null) {
                        identicalList = new ArrayList<>();
                    }
                    identicalList.add(file.getPath());
                    filesList.put(fileName, identicalList);
                }
            }


//            if (file.isDirectory()) {
//                fillHashMap(filesList, file);
//            } else {
//                String fileName = file.getName();
//                List<String> identicalList = filesList.get(fileName);
//                if (identicalList == null) {
//                    identicalList = new ArrayList<>();
//                }
//                identicalList.add(file.getPath());
//                filesList.put(fileName, identicalList);
//            }

        }
    }

    /**
     * Метод ищет файлы с одинаковыми размерами и записывает их абсолютные пути в List<String> @fileDuplicates.
     * <p>
     * foreach проходит по всем @values у HashMap.
     * Каждое @value это List<String> (список абсолютных путней) - поэтому внутренний foreach проходит по каждому списку.
     *
     * @param filesList - HashMap: key -> имя файла, value -> List<String> абсолютный путь к файлу
     * @return - List<String> fileDuplicates - общий список всех абсолютных путуй к файлам которые имеют одинаковое имя с расширением и одниковый размер.
     * @throws IOException
     * @fileSize - записывает в себя размер файла в байтах у файла в указанном пути
     * Cоздаётся List<String> @identicalList который запрашивает ссылку на List у @newMap по указаному ключу.
     * Если HashMap возвращает null -> тогда такого ключа нету, @identicalList инициализируется и в него добавляется абсолютьный путь к фалу.
     * После в @newMap добавляется новый key и value.
     * <p>
     * Следующий foreach снова проходит по всем @values у HashMap @newMap
     * если у List<String> длина > 1 тогда все элементы списка добавляет в List<String> @fileDuplicates
     */
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

    private static <E> List<String> filterSingleValuesInHashMap(Map<E, List<String>> newMap) {
        List<String> fileDuplicates = new ArrayList<>();
        for (List<String> files : newMap.values()) {
            if (files.size() > 1) {
                fileDuplicates.addAll(files);
            }
        }
        return fileDuplicates;
    }

    /**
     * Метод проходит через весь @filesList, удаляет все ключи которые удовлетворяют предикат.
     * Условие предиката - длина значения List<String> равна 1
     * Если у списка 1 элемент - означает файлов с таким именем только 1, имя файла содержиться в key
     *
     * @param filesList - HashMap: key -> имя файла, value -> List<String> абсолютный путь к файлу
     */
    public void removeAlone(Map<String, List<String>> filesList) {
        filesList.entrySet().removeIf(key -> key.getValue().size() == 1);
    }

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

//    /**
//     * Метод создаёт Collection Set @filePaths.
//     * Проходит циклом по всем @values у @lists
//     * Проверяет что длина List<File> @setList больше чем 1 файл
//     * проходит двумя циклами по длине массива где i - первый файл в списке, j - следующий по индексу
//     * У обоих файлов идёт проверка на эквивалентность имени и размера файла, если истина то добавляет абсолютные пути
//     * обоих файлов в Collection Set @filePaths который хранит только уникальные строки.
//     *
//     * @param lists - HashMap в котором записаны @key контрольная сумма @value List<File> с одиноковой контрольной суммой
//     * @return - ссылку на Collection Set @filePaths
//     */
//    public Set<String> fillMapValuesToSetCollection(Map<String, List<File>> lists) {
//        Set<String> filePaths = new HashSet<>();
//
//        for (List<File> setList : lists.values()) {
//            if (setList.size() > 1) {
//                for (int i = 0; i < setList.size(); i++) {
//                    for (int j = i + 1; j < setList.size(); j++) {
//                        if (setList.get(i).getName().equals(setList.get(j).getName()) && setList.get(i).length() == setList.get(j).length()) {
//                            filePaths.add(setList.get(i).getPath());
//                            filePaths.add(setList.get(j).getPath());
//                        }
//                    }
//                }
//            }
//        }
//        return filePaths;
//    }
}
