package lesson17practise.io.byteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //fis = new FileInputStream("C:\\Users\\Tango\\IdeaProjects\\hillel2020winter\\lessons\\src\\lesson17practise\\io\\byteStream\\input.txt"); // -> from
            //fos = new FileOutputStream("C:\\Users\\Tango\\IdeaProjects\\hillel2020winter\\lessons\\src\\lesson17practise\\io\\byteStream\\output.txt"); // -> to
            fis = new FileInputStream("C:\\Users\\Tango\\IdeaProjects\\hillel2020winter\\lessons\\src\\lesson17practise\\io\\byteStream\\logo.jpg");
            fos = new FileOutputStream("C:\\Users\\Tango\\IdeaProjects\\hillel2020winter\\lessons\\src\\lesson17practise\\io\\byteStream\\resultlogo.jpg");
            int a;
            while ((a = fis.read()) != -1) {
                fos.write(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) fis.close();
            if (fos != null) fos.close();
        }
    }
}
