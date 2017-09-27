package net.oivind.java.HueCLI.parser;

import net.oivind.java.HueCLI.core.CommandHandler;
import net.oivind.java.HueCLI.validators.Validator;
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

        Validator.validate(cmd);

        if (cmd.hasOption(CLIOptions.SHOW_ALL_LIGHTS)) {
            ch.showAllLights();
        } else if (cmd.hasOption(CLIOptions.SHOW_ALL_GROUPS)) {
            ch.showAllGroups();
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
        return cmd.getOptionValue(CLIOptions.TOGGLE).equalsIgnoreCase("on");
    }

    private boolean oneLight() {
        return cmd.hasOption(CLIOptions.LIGHT);
    }

    private boolean stateAndLight() {
        return cmd.hasOption(CLIOptions.LIGHT) &&
                (cmd.hasOption(CLIOptions.BRIGHTNESS) ||
                        cmd.hasOption(CLIOptions.HUE) ||
                        cmd.hasOption(CLIOptions.ALERT) ||
                        cmd.hasOption(CLIOptions.BRIGHTNESS)
                );
    }

    private boolean toggleLight() {
        return cmd.hasOption(CLIOptions.TOGGLE) && cmd.hasOption(CLIOptions.LIGHT);
    }

    private int getLightNumber() {
        return Integer.parseInt(cmd.getOptionValue(CLIOptions.LIGHT));
    }

    protected void showHelp() {
        formatter.printHelp("Usage", cliOptions.getOptions());
    }
}
