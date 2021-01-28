package OperationSystems;

public class OsDetector {
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static String detectSystem() {
        if (isWindows()) {
            return "Windows";
        } else if (isMac()) {
            return "Mac";
        } else if (isUnix()) {
            return "Linux";
        } else {
            throw new RuntimeException("OS not support");
        }
    }

    private static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    private static boolean isMac () {
        return (OS.indexOf("mac") >= 0);
    }

    private static boolean isUnix () {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }
}