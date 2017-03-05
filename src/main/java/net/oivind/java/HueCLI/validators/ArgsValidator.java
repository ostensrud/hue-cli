package net.oivind.java.HueCLI.validators;

import net.oivind.java.HueCLI.parser.CLIOptions;
import org.apache.commons.cli.CommandLine;

public class ArgsValidator {

    public static void validateBrightness(CommandLine cmd) {
        String optionValue = cmd.getOptionValue(CLIOptions.BRIGHTNESS);

        try {
            int lightNumber = Integer.parseInt(optionValue);
            if (lightNumber < 0 || lightNumber > 254) {
                throw new IllegalArgumentException("Brightness must be a positive integer between 1 and 254");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Brightness must be a positive integer between 1 and 254");
        }
    }

    public static void validateToggle(CommandLine cmd) {
        String optionValue = cmd.getOptionValue(CLIOptions.TOGGLE);

        if (!"on".equalsIgnoreCase(optionValue) && !"off".equalsIgnoreCase(optionValue)) {
            throw new IllegalArgumentException("Toggle must be [on|off]");
        }
    }
}
