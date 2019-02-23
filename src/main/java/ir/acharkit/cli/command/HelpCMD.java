package ir.acharkit.cli.command;

import org.apache.commons.cli.HelpFormatter;

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-02-23
 * Email:   alirezat775@gmail.com
 */

public class HelpCMD {

    private static HelpCMD instance;

    private HelpCMD() {

    }

    public static HelpCMD getInstance() {
        if (instance == null) {
            instance = new HelpCMD();
        }
        return instance;
    }

    public void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("acharkit-cli", Commands.options());
    }

}
