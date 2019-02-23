package ir.acharkit.cli.command;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-02-23
 * Email:   alirezat775@gmail.com
 */

public class Commands {

    public static final String HELP = "help";
    public static final String VERSION = "version";
    public static final String ANDROID_NEW_CLEAN = "create_new_-project";
    public static final String ANDROID = "android";

    private static Options options;

    public static void init() {
        options = new Options();

        Option help = Option.builder("help")
                .hasArg(false)
                .desc("acharkit-cli help").build();
        options.addOption(help);

        Option version = Option.builder("version")
                .hasArg(false)
                .desc("acharkit-cli version").build();
        options.addOption(version);

        Option newAndroidClean = Option.builder("android")
                .hasArg(true)
                .optionalArg(true)
                .numberOfArgs(4).argName("create new -project {{project-name}}")
                .desc("create new android project with clean architecture ").build();
        options.addOption(newAndroidClean);

    }

    public static Options options() {
        return options;
    }
}
