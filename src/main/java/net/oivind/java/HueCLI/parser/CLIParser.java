package net.oivind.java.HueCLI.parser;

import net.oivind.java.HueCLI.core.CommandHandler;
import org.apache.commons.cli.*;

import java.io.IOException;

public class CLIParser {
    protected Options options = new Options();
    private DefaultParser parser = new DefaultParser();
    private HelpFormatter formatter = new HelpFormatter();
    private CommandHandler ch;

    private final String SHOW_ALL = "show-all";
    private final String INFORMATION = "information";
    private final String TOGGLE = "toggle";
    private final String LIGHT = "light";
    private final String BRIGHTNESS = "brightness";
    private final String HUE = "hue";

    public CLIParser(CommandHandler ch) {
        this.ch = ch;
        addOptions();
    }

    protected void addOptions() {

        options.addOption(Option.builder("l")
                .longOpt(LIGHT)
                .hasArg()
                .numberOfArgs(1)
                .argName("light number")
                .desc("Light number. Used without any other options it will show information about one light.")
                .build());

        options.addOption(Option.builder("s")
                .argName("s")
                .longOpt(SHOW_ALL)
                .desc("Show all lights")
                .build());

        options.addOption(Option.builder("t")
                .longOpt(TOGGLE)
                .desc("Turn light on or off")
                .hasArg()
                .numberOfArgs(1)
                .valueSeparator()
                .build());

        options.addOption(Option.builder("b")
                .longOpt(BRIGHTNESS)
                .desc("Change the brightness of a light")
                .hasArg()
                .numberOfArgs(1)
                .build());

        options.addOption(Option.builder("h")
                .longOpt(HUE)
                .desc("Change the color of a light")
                .hasArg()
                .numberOfArgs(1)
                .build());
    }

    public void doParse(String[] args) {
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption(SHOW_ALL)) {
                ch.showAllLights();
            } else if (cmd.hasOption(TOGGLE) && cmd.hasOption(LIGHT)) {
                String toggleVal = cmd.getOptionValue(TOGGLE);
                if (!"on".equalsIgnoreCase(toggleVal) && !"off".equalsIgnoreCase(toggleVal)) {
                    throw new ParseException("Invalid option. Valid is [on|off]");
                }
                ch.toggleState(Integer.parseInt(cmd.getOptionValue(LIGHT)), cmd.getOptionValue(TOGGLE).equalsIgnoreCase("on"));
            } else if ((cmd.hasOption(BRIGHTNESS) || cmd.hasOption(HUE)) && cmd.hasOption(LIGHT)) {
                ch.changeState(Integer.parseInt(cmd.getOptionValue(LIGHT)), cmd);
            } else if (cmd.hasOption(LIGHT)) {
                ch.showOneLight(Integer.parseInt(cmd.getOptionValue(LIGHT)));
            } else {
                showHelp();
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void showHelp() {
        formatter.printHelp("Usage", options);
    }
}
