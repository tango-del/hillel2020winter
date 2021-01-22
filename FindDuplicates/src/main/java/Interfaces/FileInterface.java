package Interfaces;

import java.io.File;
import java.io.IOException;

/**
 * Данный интерфейс реализует методы для создания текстового файла
 * в который запишуться абсолютные пути файлов дубликатов
 */
public interface FileInterface {
    public void createFileResultTxt(File directory) throws IOException;
    public void writeToFile(File directory, StringBuilder str) throws IOException;
}
