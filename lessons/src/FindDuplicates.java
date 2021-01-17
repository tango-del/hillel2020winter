import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * TODO
 *  Написать приложение которое будет сканировать жесткий диск компьютера и
 *  находить дубликаты файлов, вычислять их суммарный объем и выводить результаты в консоль и записывать в файл репорта
 *  Дубликатами считаются файлы с одинаковыми именами, расширениями, размерами и контрольной суммой
 */

public class FindDuplicates {

    static File testFile;

    static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        File f = new File("D:\\Admin\\Hillel");

        List<File> duplicateFiles = new ArrayList<>();

        Set<String> filePaths = new HashSet<>();

        Map<String, List<File>> lists = new HashMap<String, List<File>>();
        findDuplicateFiles(lists, f);


        for (List<File> ll : lists.values()) {
            if (ll.size() > 1) {
                for (int i = 0; i < ll.size(); i++) {
                    for (int j = i+1; j < ll.size(); j++) {
                        if (ll.get(i).getName().equals(ll.get(j).getName()) && ll.get(i).length() == ll.get(j).length()) {
                            filePaths.add(ll.get(i).getPath());
                            filePaths.add(ll.get(j).getPath());

                            //System.out.println(ll.get(i));
                            //System.out.println(ll.get(j));
                        }
                    }
                }

                //ll.forEach(System.out::println);
//                for (File file : ll) {
//                    System.out.println(file);
//                }
            }

        }
        filePaths.forEach(System.out::println);
    }


//        byte[] b = Files.readAllBytes(Paths.get("C:\\Users\\Tango\\Desktop\\example\\100_item.json"));
//
//        byte[] hash = MessageDigest.getInstance("MD5").digest();

//        File ff = new File("C:\\Users\\Tango\\Desktop\\example\\100_item.json");
//        byte[] fileData = new byte[(int) ff.length()];
//
//        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//        FileInputStream fileInput = new FileInputStream(ff);
//        fileInput.read(fileData);
//        fileInput.close();
//
//        String uniqueFileHash = new BigInteger(1, messageDigest.digest(fileData)).toString(16);
//
//
//        File dir = new File("C:\\Users\\Tango\\Desktop\\example");

        //fddd(dir);

    public static void findDuplicateFiles(Map<String, List<File>> filesList, File directory) {
        for (File dirChild : directory.listFiles()) {
            // Iterate all file sub directories recursively
            if (dirChild.isDirectory()) {
                findDuplicateFiles(filesList, dirChild);
            } else {
                try {
                    if (dirChild.length() < 52428800) {
                        // Read file as bytes
                        FileInputStream fileInput = new FileInputStream(dirChild);
                        byte fileData[] = new byte[(int) dirChild.length()];
                        fileInput.read(fileData);
                        fileInput.close();
                        // Create unique hash for current file
                        String uniqueFileHash = new BigInteger(1, messageDigest.digest(fileData)).toString(16);
                        List<File> identicalList = filesList.get(uniqueFileHash);
                        if (identicalList == null) {
                            identicalList = new LinkedList<>();
                        }
                        // Add path to list
                        identicalList.add(dirChild);
                        // push updated list to Hash table
                        filesList.put(uniqueFileHash, identicalList);
                    }

                } catch (IOException e) {
                    throw new RuntimeException("cannot read file " + dirChild.getAbsolutePath(), e);
                }
            }
        }
    }

    public static void fddd(File dir) {
        Map<String, String> map = new HashMap<>();

        List<String> listPath = new ArrayList<>();

        Set<String> check = new HashSet<>();

        Arrays.stream(dir.listFiles())
                //.sorted(Comparator.comparing(File::length))
                .filter(file -> file.isFile())
                .forEach(file -> {
                    if (file.isFile()) {
                        //testFile = new File(file.getPath());
                        //System.out.println("File -> " + file.getName());
                        if (!check.add(file.getName())) {
                            System.out.println(file.getPath());
                        }
                        //listPath.add(file.getName());
                        //map.put(file.getName(), file.getParent());
                    } else {
                        //System.out.println("Directory -> " + file.getName());
                        fddd(file);
                    }
                });

        System.out.println(check);
        //System.out.println(map);
//        if (dir.isFile()) {
//            System.out.println(dir.getName());
//        } else {
//            System.out.println(dir.getName());
//            for (File ssss : dir.listFiles()) {
//                fddd(ssss);
//            }
//        }
    }
}
