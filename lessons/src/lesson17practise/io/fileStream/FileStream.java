package lesson17practise.io.fileStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileStream {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("C:\\Users\\Tango\\IdeaProjects\\hillel2020winter\\lessons\\src\\lesson17practise\\io\\fileStream\\input.txt");
        int size = inputStream.available();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.print((char) inputStream.read());
        }
        inputStream.close();
    }
}
