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
    public static final String CREATE = "create";
    public static final String CHANGE_PACKAGE = "changePackage";
    private static AndroidCMD instance;

    private AndroidCMD() {

    }

    public static AndroidCMD getInstance() {
        if (instance == null) {
            instance = new AndroidCMD();
        }
        return instance;
    }

    public void androidCreatedNew(String projectName, String destination) {
        if (!new File(destination).exists()) {
            System.out.println("Destination: " + destination + " not exist");
        } else {
            System.out.println("------------------------------------------------------------");
            boolean downloaded = WGet.getInstance().get(GIT_CLEAN_REPO, destination);
            boolean unzip;
            if (downloaded) {
                unzip = UnzipHelper.unzip(destination, true);
                prepareProject(projectName, destination);
                System.out.println(unzip ? "created new android project with clean architecture" : "create new project failed");
            } else {
                System.out.println("create new project failed");
            }
            System.out.println("------------------------------------------------------------");
        }
    }

    private void prepareProject(String projectName, String destination) {
        destination = destination == null ? ANDROID_PROJECT_PATH : destination;
        File projectDir = new File(destination + File.separator + ANDROID_PROJECT_NAME);
        File projectNewDir = new File(destination + File.separator + projectName);
        projectDir.renameTo(projectNewDir);
    }

    public void changePackageName(String packageName, String projectName, String destination) {
        File file = new File(ANDROID_PROJECT_PATH, projectName);
        if (file.exists()) {
            System.out.println("Project with " + projectName + " not exist");
        } else {

        }
    }
}
