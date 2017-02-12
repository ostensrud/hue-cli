package net.oivind.java.HueCLI.parser;

import net.oivind.java.HueCLI.core.CommandHandler;
import org.apache.commons.cli.*;

import java.io.IOException;

public class CLIParser {
    private Options options = new Options();
    private DefaultParser parser = new DefaultParser();
    private HelpFormatter formatter = new HelpFormatter();
    private CommandHandler ch = new CommandHandler();

    public CLIParser() {
        addOptions();
    }

    private void addOptions() {
        options.addOption(Option.builder("s")
                .argName("s")
                .longOpt("show-all")
                .desc("Show all lights")
                .build());

        options.addOption(Option.builder("l")
                .longOpt("light")
                .desc("Show info about one light")
                .hasArg()
                .build());

    }

    public void doParse(String[] args) {
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("s")) {
                System.out.println("Show all lights");
                ch.showAllLights();
            } else {
                showHelp();
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showHelp() {
        formatter.printHelp("Usage", options);
    }
}
