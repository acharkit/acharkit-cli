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
            } else {
                System.out.println("Project not exist");
            }
        }

        if (commands.getUseCase() != null) {
            System.out.println("Command not exist (will enable in next version)");
        }
    }
}
