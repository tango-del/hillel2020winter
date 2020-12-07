package lesson9test;

public class Main {
    public static void main(String[] args) {
        Entry first;
        Entry last;
        // left <-> entry1 <-> last
        Entry entry1 = new Entry("One");
//        entry1.setLeft(entry1);
//        entry1.setRight(entry1);
        first = entry1;
        last = entry1;
        entry1.setLeft(first);
        entry1.setRight(last);

        // first <-> entry1 < - > entry2 <-> last
        Entry entry2 = new Entry("Two");
        last = entry2;
        entry1.setRight(entry2);
        entry2.setLeft(entry1);
        entry2.setRight(last);
//        entry1.setLeft(entry2);
//        entry1.setRight(entry2);
//
//        entry2.setRight(entry1);
//        entry2.setLeft(entry1);
        // first <-> entry1 <-> entry2 <-> entry3 <-> last
        Entry entry3 = new Entry("Three");
        last = entry3;
        entry1.setRight(entry2);
        entry2.setRight(entry3);
        entry3.setLeft(entry2);
        entry3.setRight(last);
//        entry1.setLeft(entry3);
//
//        entry2.setRight(entry3);
//
//        entry3.setRight(entry1);
//        entry3.setLeft(entry2);
        // header <-> entry1 <-> entry2 <-> entry3 <-> entry4 <-> header
        Entry entry4 = new Entry("Four");
        last = entry4;
        entry3.setRight(entry4);
        entry4.setLeft(entry3);
        entry4.setRight(first);
        System.out.println();
        System.out.println("-----");

//        entry1.setLeft(entry4);
//
//        entry3.setRight(entry4);
//
//        entry4.setRight(entry1);
//        entry4.setLeft(entry3);

        System.out.println(first.getValue());
        System.out.println(first.getRight().getValue());
        // first <-> entry1 <-> entry2 <-> entry3
        System.out.println(first.getRight().getRight().getValue());
        // header <-> entry1 <-> entry2 <-> entry3 <-> entry4
        System.out.println(first.getRight().getRight().getRight().getValue());

        System.out.println(first.getValue());
        System.out.println(last.getValue());
//        // one
//        System.out.println(entry1.getValue());
//        // two
//        System.out.println(entry1.getRight().getValue());
//        // three
//        System.out.println(entry1.getRight().getRight().getValue());
//        // four
//        System.out.println(entry1.getRight().getRight().getRight().getValue());
    }
}
