package ir.acharkit.cli;

import org.apache.commons.cli.HelpFormatter;
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
    public static final String ANDROID_NEW_CLEAN = "new_clean";
    public static final String ANDROID = "android";

    private static Options options;

    public static void init() {
        options = new Options();

        Option help = Option.builder()
                .longOpt("help")
                .hasArg(false)
                .desc("acharkit-cli help").build();
        options.addOption(help);


        Option version = Option.builder()
                .longOpt("version")
                .hasArg(false)
                .desc("acharkit-cli version").build();
        options.addOption(version);

        Option newAndroidClean = Option.builder()
                .longOpt("android")
                .hasArg(true)
                .numberOfArgs(2).argName("new clean")
                .desc("create new clean android sample").build();
        options.addOption(newAndroidClean);


    }

    public static Options options() {
        return options;
    }
}
