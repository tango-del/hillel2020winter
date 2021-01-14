import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {

    private static String fileDir = "converted";


    private static String resultFile = "result.txt";


    private static File dirConvertResults;

    private static BufferedWriter writer;

    public static void checkDirExists(String path) throws IOException {

        dirConvertResults = new File(path, fileDir);

        if (!dirConvertResults.exists()) {
            dirConvertResults.mkdir();
        }

        File fileWithResult = new File(dirConvertResults, resultFile);

        if (!fileWithResult.exists()) {
            fileWithResult.createNewFile();
        }

        try {
            writer = new BufferedWriter(new FileWriter(fileWithResult));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File checkFileExists(String fileName) throws IOException {
        File file = new File(dirConvertResults, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static void writeToFile(StringBuilder str) throws IOException {
        writer.write(str.toString());
        writer.close();
    }
}
