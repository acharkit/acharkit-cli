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
    public static final String ANDROID_NEW_CLEAN = "create_new";
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
                .numberOfArgs(2).argName("create new")
                .desc("create new with clean architecture android project").build();
        options.addOption(newAndroidClean);

    }

    public static Options options() {
        return options;
    }
}
