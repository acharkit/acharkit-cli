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
            description = "Show current version {cli , android}")
    private String version = "";

    @Parameter(names = {"-and", "--android"},
            description = "Commands for android {create , changePackage}")
    private String android = "";

    @Parameter(names = {"-prj", "--project"},
            description = "Commands for project {projectName}")
    private String project = "";

    @Parameter(names = {"-cpkg", "--changePackage"},
            description = "Commands for change packageName {com.example.project}")
    private String changePackage = "";

    @Parameter(names = {"-d", "--destination"},
            description = "Destination for project {~/Desktop/projects}")
    private String destination = "";

    @Parameter(names = {"-useC", "--useCase"},
            description = "Command for action on useCase class {useCaseName}")
    private String useCase = "";

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

    public String getChangePackage() {
        return changePackage;
    }

    public String getDestination() {
        return destination;
    }

    public String getUseCase() {
        return useCase;
    }
}
