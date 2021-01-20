package Interfaces;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Данный интерфейс хранит метод для поиска в указанной директории файлов
 * и сохранения их в HashMap. В качестве @key записывается контрольная сумма
 * @value список файлов с контрольной суммой.
 */
public interface SearchFiles {
    void findAndSaveDuplicateFilesInHashMap(Map<String, List<File>> filesList, File directory) throws NoSuchAlgorithmException;
    Set<String> fillMapValuesToSetCollection(Map<String, List<File>> lists);
}
