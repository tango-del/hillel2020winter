package interfaces;

import java.io.IOException;

public interface FilesGenerator {
    void checkFilesExists() throws IOException;
    void writeToFile(StringBuilder str) throws IOException;
}
