package ir.acharkit.cli;

import ir.acharkit.cli.command.AndroidCMD;
import ir.acharkit.cli.command.Commands;
import ir.acharkit.cli.command.HelpCMD;
import ir.acharkit.cli.command.VersionCMD;
import org.apache.commons.cli.*;

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-02-23
 * Email:   alirezat775@gmail.com
 */

public class Main {

    public static void main(String[] args) {

        Commands.init();

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(Commands.options(), args);
            findCommand(cmd);
        } catch (ParseException e) {
            System.out.println("Unexpected exception:" + e.getMessage());
        }
    }

    private static void findCommand(CommandLine cmd) {
        for (Option option : cmd.getOptions()) {
            String currentOpt = option.getOpt() == null ? option.getLongOpt() : option.getOpt();
            switch (currentOpt) {
                case Commands.HELP:
                    HelpCMD.getInstance().printHelp();
                    break;
                case Commands.VERSION:
                    VersionCMD.getInstance().printVersion();
                    break;
                case Commands.ANDROID:
                    String[] options = cmd.getOptionValues(Commands.ANDROID);
                    String value = String.join("_", options[0], options[1], options[2]);
                    if (value.equals(Commands.ANDROID_NEW_CLEAN))
                        AndroidCMD.getInstance().printAndroidCreatedNew(options[options.length - 1]);
                    break;
            }
        }
    }
}
