package ir.acharkit.cli.lib;

public class Logger {

    public static void error(String error) {
        System.out.println("Unexpected exception: " + error);
    }

    public static void info(String info) {
        System.out.println("info: " + info);
    }
}
