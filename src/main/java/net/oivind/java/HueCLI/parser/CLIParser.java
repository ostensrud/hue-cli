package net.oivind.java.HueCLI.parser;

import net.oivind.java.HueCLI.core.CommandHandler;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

import java.io.IOException;

public class CLIParser {
    private CLIOptions cliOptions = new CLIOptions();
    private DefaultParser parser = new DefaultParser();
    private HelpFormatter formatter = new HelpFormatter();
    private CommandHandler ch;
    private CommandLine cmd;

    public CLIParser(CommandHandler ch) {
        this.ch = ch;
    }

    public void doParse(String[] args) throws ParseException, IOException {
        cmd = parser.parse(cliOptions.getOptions(), args);
        if (cmd.hasOption(cliOptions.SHOW_ALL)) {
            ch.showAllLights();
        } else if (toggleLight()) {
            ch.toggleState(getLightNumber(), lightOn());
        } else if (stateAndLight()) {
            ch.changeState(getLightNumber(), cmd);
        } else if (oneLight()) {
            ch.showOneLight(getLightNumber());
        } else {
            showHelp();
        }
    }

    private boolean lightOn() {
        return cmd.getOptionValue(cliOptions.TOGGLE).equalsIgnoreCase("on");
    }

    private boolean oneLight() {
        return cmd.hasOption(cliOptions.LIGHT);
    }

    private boolean stateAndLight() {
        return cmd.hasOption(cliOptions.LIGHT) &&
                (cmd.hasOption(cliOptions.BRIGHTNESS) ||
                        cmd.hasOption(cliOptions.HUE) ||
                        cmd.hasOption(cliOptions.ALERT) ||
                        cmd.hasOption(cliOptions.BRIGHTNESS)
                );
    }

    private boolean toggleLight() {
        return cmd.hasOption(cliOptions.TOGGLE) && cmd.hasOption(cliOptions.LIGHT);
    }

    private int getLightNumber() {
        return Integer.parseInt(cmd.getOptionValue(cliOptions.LIGHT));
    }

    protected void showHelp() {
        formatter.printHelp("Usage", cliOptions.getOptions());
    }
}
