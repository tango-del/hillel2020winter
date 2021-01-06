package lesson17practise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FolderStructure {

    private static final String FILE = "[F] : ";
    private static final String DIR = "[D] : ";
    private static final String PREF = "--";

    public static void main(String[] args) throws IOException {

        String rootDir = "C:\\Users\\Tango\\IdeaProjects\\hillel2020winter\\lessons\\src";

        File f = new File(rootDir);

        for (File s : f.listFiles()) {
            getFileStructure(s, "");
        }
    }

    private static void getFileStructure(File file, String prefix) throws IOException {
        if (file.isFile()) {
            System.out.println(prefix + FILE.concat(file.getName()));
        } else {
            System.out.println(prefix + DIR.concat(file.getName()));
            for (File f : file.listFiles()){
                getFileStructure(f, prefix + PREF);
            }
        }
    }
}
