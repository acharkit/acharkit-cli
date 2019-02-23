package ir.acharkit.cli.command;

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-02-23
 * Email:   alirezat775@gmail.com
 */

public class VersionCMD {

    private static VersionCMD instance;

    private VersionCMD() {

    }

    public static VersionCMD getInstance() {
        if (instance == null) {
            instance = new VersionCMD();
        }
        return instance;
    }

    public void printVersion() {
        System.out.println("acharkit cli version: ==> 0.0.1");
    }

}
