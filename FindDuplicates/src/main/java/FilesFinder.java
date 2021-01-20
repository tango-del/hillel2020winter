import Interfaces.SearchFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class FilesFinder implements SearchFiles {
    /**
     * Данный метод проходит по массиву @File listFiles.
     * У каждого файла в массиве происходит проверка что этот файл является директорией а не файлом, если ответ @true тогда вызывается @recursive этого же метода
     * в который передаётся этот же файл (директория).
     * Если ответ @false - тогда идёт проверка что размер этого файла @length() не превышает указанное значение в байтах.
     * @fileData записывает байты в виде массива с помощью FileInputStream и закрывает вконце поток.
     *
     * @uniqueFileHash записывает в 16-тиричной системой счисления контрольную сумму файла.
     *
     * @identicalList - записывает в себя Map @value по указанному @key. Добавляет в список новый File и отсылает Map этот @value в указанный @key
     *
     * @param filesList - HashMap который запишет в себя @key контрольная сумма (MD5) @value - путь к файлам с данной контрольной суммой
     * @param directory - File директория в которой будет происходить поиск файлов
     * @throws NoSuchAlgorithmException
     */
    @Override
    public void findAndSaveDuplicateFilesInHashMap(Map<String, List<File>> filesList, File directory) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        for (File dirChild : directory.listFiles()) {
            if (dirChild.isDirectory()) {
                findAndSaveDuplicateFilesInHashMap(filesList, dirChild);
            } else {
                try {
                    if (dirChild.length() < 157286400) { // число в байтах
                        FileInputStream fileInput = new FileInputStream(dirChild);
                        byte[] fileData = new byte[(int) dirChild.length()];
                        fileInput.read(fileData);
                        fileInput.close();
                        String uniqueFileHash = new BigInteger(1, messageDigest.digest(fileData)).toString(16);
                        List<File> identicalList = filesList.get(uniqueFileHash); // null - если в Map нету @value по заданному @key
                        if (identicalList == null) {
                            identicalList = new ArrayList<>();
                        }
                        identicalList.add(dirChild);
                        filesList.put(uniqueFileHash, identicalList);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Метод создаёт Collection Set @filePaths.
     * Проходит циклом по всем @values у @lists
     * Проверяет что длина List<File> @setList больше чем 1 файл
     * проходит двумя циклами по длине массива где i - первый файл в списке, j - следующий по индексу
     * У обоих файлов идёт проверка на эквивалентность имени и размера файла, если истина то добавляет абсолютные пути
     * обоих файлов в Collection Set @filePaths который хранит только уникальные строки.
     *
     * @param lists - HashMap в котором записаны @key контрольная сумма @value List<File> с одиноковой контрольной суммой
     * @return - ссылку на Collection Set @filePaths
     */
    @Override
    public Set<String> fillMapValuesToSetCollection(Map<String, List<File>> lists) {
        Set<String> filePaths = new HashSet<>();

        for (List<File> setList : lists.values()) {
            if (setList.size() > 1) {
                for (int i = 0; i < setList.size(); i++) {
                    for (int j = i + 1; j < setList.size(); j++) {
                        if (setList.get(i).getName().equals(setList.get(j).getName()) && setList.get(i).length() == setList.get(j).length()) {
                            filePaths.add(setList.get(i).getPath());
                            filePaths.add(setList.get(j).getPath());
                        }
                    }
                }
            }
        }
        return filePaths;
    }
}
