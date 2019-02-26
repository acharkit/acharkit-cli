package ir.acharkit.cli.command;

import com.beust.jcommander.Parameter;

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-02-23
 * Email:   alirezat775@gmail.com
 */

public class Commands {

    @Parameter(names = {"-h", "--help"},
            help = true,
            description = "Displays help information")
    private boolean help;
    @Parameter(names = {"-v", "--version"},
            description = "show current version {cli , android}")
    private String version = "";

    @Parameter(names = {"-and", "--android"},
            description = "commands for android {create , changePackage}")
    private String android = "";

    @Parameter(names = {"-prj", "--project"},
            description = "commands for project {projectName}")
    private String project = "";

    public boolean isHelp() {
        return help;
    }

    public String getVersion() {
        return version;
    }

    public String getAndroid() {
        return android;
    }

    public String getProject() {
        return project;
    }

    //    public static final String HELP = "help";
//    public static final String VERSION = "version";
//    public static final String ANDROID_NEW_CLEAN = "create_new_-project";
//    public static final String ANDROID = "android";
//
//    private static Options options;
//
//    public static void init() {
//        options = new Options();
//
//        Option help = Option.builder("help")
//                .hasArg(false)
//                .desc("acharkit-cli help").build();
//        options.addOption(help);
//
//        Option version = Option.builder("version")
//                .hasArg(false)
//                .desc("acharkit-cli version").build();
//        options.addOption(version);
//
//        Option newAndroidClean = Option.builder("android")
//                .hasArg(true)
//                .optionalArg(true)
//                .numberOfArgs(4).argName("create new -project {{project-name}}")
//                .desc("create new android project with clean architecture ").build();
//        options.addOption(newAndroidClean);
//
//    }
//
//    public static Options options() {
//        return options;
//    }
}
