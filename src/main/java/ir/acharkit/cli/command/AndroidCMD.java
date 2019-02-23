package ir.acharkit.cli.command;

import ir.acharkit.cli.lib.UnzipHelper;
import ir.acharkit.cli.lib.WGet;

import java.io.File;

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-02-23
 * Email:   alirezat775@gmail.com
 */

public class AndroidCMD {

    public static final String ANDROID_PROJECT_NAME = "android-sample-clean-architecture-master";
    public static final String ANDROID_PROJECT_PATH = new File("").getAbsolutePath();
    public static final String GIT_CLEAN_REPO = "https://codeload.github.com/acharkit/android-sample-clean-architecture/zip/master";
    private static AndroidCMD instance;

    private AndroidCMD() {

    }

    public static AndroidCMD getInstance() {
        if (instance == null) {
            instance = new AndroidCMD();
        }
        return instance;
    }

    public void printAndroidCreatedNew(String optionValue) {
        System.out.println("------------------------------------------------------------");
        boolean downloaded = WGet.getInstance().get(GIT_CLEAN_REPO);
        boolean unzip;
        if (downloaded) {
            unzip = UnzipHelper.unzip(true);
            prepareProject(optionValue);
            System.out.println(unzip ? "created new android project with clean architecture" : "create new project failed");
        } else {
            System.out.println("create new project failed");
        }
        System.out.println("------------------------------------------------------------");
    }

    private void prepareProject(String optionValue) {
        optionValue = optionValue.equals("new") ? "new-project" : optionValue;
        File projectDir = new File(ANDROID_PROJECT_PATH + File.separator + ANDROID_PROJECT_NAME);
        File projectNewDir = new File(ANDROID_PROJECT_PATH + File.separator + optionValue);
        projectDir.renameTo(projectNewDir);
    }
}
