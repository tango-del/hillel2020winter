package ObjectSize;

import org.openjdk.jol.info.ClassLayout;

public class SizeStringCalculator {
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(String.class).toPrintable());
        System.out.println("------>");
        String str = new String("test");
        System.out.println(ClassLayout.parseInstance(str).toPrintable());

        System.out.println("------>");
        String strPoll1 = "test test ";
        System.out.println(ClassLayout.parseInstance(strPoll1).toPrintable());
        String strPoll2 = "test";
        System.out.println(ClassLayout.parseInstance(strPoll2).toPrintable());
    }
}
