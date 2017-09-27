package net.oivind.java.HueCLI.validators;

import net.oivind.java.HueCLI.parser.CLIOptions;
import org.apache.commons.cli.CommandLine;

public class Validator {

    public static void validate(CommandLine cmd) {
        boolean lightNumberIsValid = false;

        if (cmd.hasOption(CLIOptions.LIGHT)) {
            LightValidator.validateLightNumber(cmd);
            lightNumberIsValid = true;
        }

        if (showAllIsSpecified(cmd) && cmd.getOptions().length != 1) {
            throw new IllegalArgumentException("--show-all cannot be combined with other arguments");
        }

        if (lightNumberIsValid && cmd.getOptions().length >= 2) {
            if (cmd.hasOption(CLIOptions.BRIGHTNESS)) {
                ArgsValidator.validateBrightness(cmd);
            }

            if (cmd.hasOption(CLIOptions.TOGGLE)) {
                ArgsValidator.validateToggle(cmd);
            }

            if (cmd.hasOption(CLIOptions.HUE)) {
                ArgsValidator.validateHue(cmd);
            }

            if (cmd.hasOption(CLIOptions.ALERT)) {
                ArgsValidator.validateAlert(cmd);
            }
        } else if (!lightNumberIsValid && !showAllIsSpecified(cmd) && cmd.getOptions().length >= 1){
            throw new IllegalArgumentException("Light number must be specified to change state");
        }
    }

    private static boolean showAllIsSpecified(CommandLine cmd) {
        return cmd.hasOption(CLIOptions.SHOW_ALL_LIGHTS) || cmd.hasOption(CLIOptions.SHOW_ALL_GROUPS);
    }
}
