package ir.acharkit.cli;

import ir.acharkit.cli.command.AndroidCMD;
import ir.acharkit.cli.command.Commands;
import ir.acharkit.cli.command.HelpCMD;
import ir.acharkit.cli.command.VersionCMD;
import org.apache.commons.cli.*;

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
                    String value = String.join("_", cmd.getOptionValues(Commands.ANDROID));
                    if (value.equals(Commands.ANDROID_NEW_CLEAN))
                        AndroidCMD.getInstance().printAndroidCreatedNew();
                    break;
            }
        }
    }
}
