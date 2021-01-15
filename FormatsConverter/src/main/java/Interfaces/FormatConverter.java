package Interfaces;

import java.io.IOException;

/**
 * Данный интерфейс хранит реализацию метода @FormatConverter
 * Все классы которые будут у него имплементироваться должны
 * реализовывать данный метод
 */
public interface FormatConverter {
    void convertFile(String pathFile, String fileName, StringBuilder strBuilder) throws IOException;
}
