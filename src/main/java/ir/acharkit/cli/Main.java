package ir.acharkit.cli;

import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) {

        Commands.init();

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(Commands.options(), args);


            if (cmd.hasOption(Commands.HELP)) {
                printHelp();
            } else if (cmd.hasOption(Commands.VERSION)) {
                printVersion();
            } else if (cmd.hasOption(Commands.ANDROID)) {

                String commaSeparatedValues = String.join("_", cmd.getOptionValues(Commands.ANDROID));
                if (commaSeparatedValues.equals(Commands.ANDROID_NEW_CLEAN)) {
                    printAndroidCreatedNew();
                }
            }
        } catch (ParseException e) {
            System.out.println("Unexpected exception:" + e.getMessage());
        }


    }


    private static void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("acharkit-cli", Commands.options());
    }

    private static void printAndroidCreatedNew() {
        System.out.println("created new android project with clean architecture");
    }

    private static void printVersion() {
        System.out.println("acharkit cli version: ==> 0.0.1");
    }

}
