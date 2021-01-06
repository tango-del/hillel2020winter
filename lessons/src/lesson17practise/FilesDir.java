package lesson17practise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FilesDir {
    public static void main(String[] args) throws IOException {
        String nameDir1 = "C:\\Users\\Tango\\IdeaProjects\\hillel2020winter\\lessons\\src\\lesson17practise\\test";
        String nameDir2 = nameDir1 + "\\test_in\\test_inn";
        String nameDir3 = nameDir1 + "\\test_in";
        String nameDir4 = nameDir1 + "\\test_in23";

        File dir = new File(nameDir2);
        File dir1 = new File(nameDir3);
        File dir2 = new File(nameDir4);

//        System.out.println(dir.mkdir());
//        System.out.println(dir1.mkdir());
//
//        File dirTest = new File("C:\\Users\\Tango\\IdeaProjects\\hillel2020winter\\lessons\\src\\lesson17practise\\tango\\sierra");
//
//        System.out.println(dirTest.mkdirs());
//
//        System.out.println("----------");
//        System.out.println(dir.getName()); // test_inn
//        System.out.println(dir.isFile());
//        System.out.println(dir.isDirectory());
//        System.out.println(dir.getParent());
//        System.out.println(dir.getAbsolutePath());
//
//        System.out.println("----------");
//        System.out.println(dir.canRead());
//        System.out.println(dir.canWrite());
//        System.out.println(dir.setReadable(false));
//        System.out.println(dir.setWritable(false));
//        System.out.println(dir.canRead());
//        System.out.println(dir.canWrite());
//
//        System.out.println("----------");
//        System.out.println(dir2.exists());
//        System.out.println(dir.exists());
//        System.out.println(dir.lastModified());
        String filename1 = "example1.txt";
        String filename2 = "example2.txt";
        String filename3 = "example3.txt";
        File file1 = new File(nameDir1, filename1);
        File file2 = new File(nameDir2, filename2);
        File file3 = new File(nameDir3, filename3);

        System.out.println(file1.createNewFile());
        System.out.println(file2.createNewFile());
        System.out.println(file3.createNewFile());

        System.out.println("------");

        System.out.println(file1.exists());
        System.out.println(file2.exists());
        System.out.println(file3.exists());

        System.out.println("------");

        System.out.println(file1.isHidden());
        System.out.println(file1.isAbsolute());
        System.out.println(file1.isDirectory());

        System.out.println("------");

        try (FileWriter fs = new FileWriter("C:\\Users\\Tango\\IdeaProjects\\hillel2020winter\\lessons\\src\\lesson17practise\\test\\example1.txt")) {
            String str = "Hello world";
            for (char c : str.toCharArray()) {
                fs.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
