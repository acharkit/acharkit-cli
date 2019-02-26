package ir.acharkit.cli.command;

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-02-23
 * Email:   alirezat775@gmail.com
 */

public class VersionCMD {

    public static final String VERSION_CLI = "cli";
    public static final String VERSION_ANDROID = "android";
    private static VersionCMD instance;

    private VersionCMD() {

    }

    public static VersionCMD getInstance() {
        if (instance == null) {
            instance = new VersionCMD();
        }
        return instance;
    }

    public void printAndroidVersion() {
        System.out.println("Acharkit android version: ==> 0.1.1");
    }

    public void printCliVersion() {
        System.out.println("Acharkit cli version: ==> 0.0.1");
    }

}
