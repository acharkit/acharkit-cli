package ir.acharkit.cli.command;

import ir.acharkit.cli.lib.UnzipUtility;
import ir.acharkit.cli.lib.WGet;

public class AndroidCMD {

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

    //    public void printAndroidCreatedNew() {
//        System.out.println("*** *** ***");
//        File fileDownloadDir = new File(new File("").getAbsolutePath() + "/" + "new-project");
//        try {
//            Git.cloneRepository()
//                    .setURI(GIT_CLEAN_REPO)
//                    .setDirectory(fileDownloadDir)
//                    .call();
//            System.out.println("created new android project with clean architecture");
//        } catch (GitAPIException e) {
//            System.out.println("create new project failed");
//            System.out.println("Unexpected exception:" + e.getMessage());
//        }
//
//    }
//
    public void printAndroidCreatedNew() {
        System.out.println("*** *** ***");
        boolean downloaded = WGet.getInstance().get(GIT_CLEAN_REPO);
        System.out.println("*** *** ***");
        boolean unzip;
        if (downloaded) {
            unzip = UnzipUtility.unzip();
            System.out.println(unzip ? "created new android project with clean architecture" : "create new project failed");
        } else {
            System.out.println("create new project failed");
        }

    }
}
