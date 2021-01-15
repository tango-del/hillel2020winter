package Interfaces;

import java.io.File;
import java.io.IOException;

/**
 * Данный интерфейс хранит в себе реализации работы с различными видами файлов (директории и файлы с расширениями)
 * Все классы которые будут у него имплементироваться должны
 * реализовывать все перечисленные методы.
 */
public interface FileInterface {

    void createFileDir(String path) throws IOException;

    File createFileWithExt(String fileName) throws IOException;

    void createFileResultTxt() throws IOException;

    String readFileToString(String filePath);

    void writeToFile(StringBuilder str) throws IOException;
}
