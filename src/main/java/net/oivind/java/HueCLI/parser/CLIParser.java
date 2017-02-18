package net.oivind.java.HueCLI.parser;

import net.oivind.java.HueCLI.core.CommandHandler;
import org.apache.commons.cli.*;

import java.io.IOException;

public class CLIParser {
    protected Options options = new Options();
    private DefaultParser parser = new DefaultParser();
    private HelpFormatter formatter = new HelpFormatter();
    private CommandHandler ch = new CommandHandler();

    private final String SHOW_ALL = "show-all";
    private final String INFORMATION = "information";
    private final String TOGGLE = "toggle";

    public CLIParser() {
        addOptions();
    }

    private void addOptions() {

        options.addOption(Option.builder("s")
                .argName("s")
                .longOpt(SHOW_ALL)
                .desc("Show all lights")
                .build());

        options.addOption(Option.builder("i")
                .longOpt(INFORMATION)
                .desc("Show information about one light or one group")
                .hasArg()
                .build());


        options.addOption(Option.builder("t")
                .longOpt(TOGGLE)
                .desc("Turn light on or off")
                .hasArg()
                .numberOfArgs(2)
                .build());

    }

    public void doParse(String[] args) {
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption(SHOW_ALL)) {
                System.out.println("Show all lights");
                ch.showAllLights();
            } else if (cmd.hasOption(INFORMATION)) {
                System.out.println("Show one light");
                ch.showOneLight(1);
            } else if (cmd.hasOption(TOGGLE)) {
                System.out.println("Toggle light");
                final String[] optionValues = cmd.getOptionValues(TOGGLE);
                ch.toggleState(Integer.parseInt(optionValues[0]), Boolean.valueOf(optionValues[1]));
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
