package lesson7Test.Collection;

public class StringList implements StringCollection {

    public String[] args;

    public StringList() {
        this.args = new String[10];
    }

    public void listArgs() {
//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }
        for(String arg : args) {
            System.out.println(arg);
        }
    }

    @Override
    public void addString(String arg) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                args[i] = arg;
                break;
            }
        }
    }
}
