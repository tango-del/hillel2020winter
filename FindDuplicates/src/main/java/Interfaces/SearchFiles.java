package Interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public void fillHashMap(Map<String, List<String>> filesList, File directory) throws FileNotFoundException;
    public List<String> deleteFilesWithDifferentSize(Map<String, List<String>> filesList) throws IOException;
    public void removeAlone(Map<String, List<String>> filesList);
    public List<String> filterHashSum(List<String> newList) throws IOException, NoSuchAlgorithmException;
}
