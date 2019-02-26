package ir.acharkit.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import ir.acharkit.cli.command.AndroidCMD;
import ir.acharkit.cli.command.Commands;
import ir.acharkit.cli.command.VersionCMD;
import ir.acharkit.cli.lib.Logger;

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-02-23
 * Email:   alirezat775@gmail.com
 */

public class Main {

    private static Commands commands = new Commands();

    public static void main(String[] args) {

        JCommander jCommander = new JCommander(commands);
        jCommander.setProgramName("Acharkit");
        try {
            jCommander.parse(args);
        } catch (ParameterException exception) {
            Logger.error(exception.getMessage());
            jCommander.usage();
        }
        if (commands.isHelp()) {
            jCommander.usage();
        } else {
            findCommand();
        }
    }

    private static void findCommand() {

        if (commands.getVersion().equals(VersionCMD.VERSION_ANDROID)) {
            VersionCMD.getInstance().printAndroidVersion();
        }
        if (commands.getVersion().equals(VersionCMD.VERSION_CLI)) {
            VersionCMD.getInstance().printCliVersion();
        }
        if (commands.getAndroid().equals(AndroidCMD.CREATE)) {
            AndroidCMD.getInstance().androidCreatedNew(commands.getProject() == null ? "new-project" : commands.getProject(), commands.getDestination());
        }

        if (commands.getAndroid().equals(AndroidCMD.CHANGE_PACKAGE)) {
            if (commands.getChangePackage() != null && commands.getProject() != null) {
                AndroidCMD.getInstance().changePackageName(commands.getChangePackage(), commands.getProject(), commands.getDestination());
            }
        }


    }
//
//    private static void findCommand(CommandLine cmd) {
//        for (Option option : cmd.getOptions()) {
//            String currentOpt = option.getOpt() == null ? option.getLongOpt() : option.getOpt();
//            switch (currentOpt) {
//                case Commands.HELP:
//                    HelpCMD.getInstance().printHelp();
//                    break;
//                case Commands.VERSION:
//                    VersionCMD.getInstance().printVersion();
//                    break;
//                case Commands.ANDROID:
//                    String[] options = cmd.getOptionValues(Commands.ANDROID);
//                    String value = String.join("_", options[0], options[1], options[2]);
//                    if (value.equals(Commands.ANDROID_NEW_CLEAN))
//                        AndroidCMD.getInstance().printAndroidCreatedNew(options[options.length - 1]);
//                    break;
//            }
//        }
//    }
}
