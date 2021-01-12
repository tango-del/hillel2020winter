import java.nio.file.FileSystems;

public class Run {
    public static void main(String[] args) {
        String appDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();

        System.out.println("app location path : " + appDirectory);
    }
}
