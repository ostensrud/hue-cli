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

    public static void validateHue(CommandLine cmd) {
        String optionValue = cmd.getOptionValue(CLIOptions.HUE);

        try {
            int hue = Integer.parseInt(optionValue);
            if (hue < 0 || hue > 65535) {
                throw new IllegalArgumentException("Hue must be a positive integer between 0 and 65535");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Hue must be a positive integer between 0 and 65535");
        }
    }

    public static void validateAlert(CommandLine cmd) {
        String optionValue = cmd.getOptionValue(CLIOptions.ALERT);

        if (!"none".equals(optionValue) && !"select".equals(optionValue) && !"lselect".equals(optionValue)) {
            throw new IllegalArgumentException("Alert must be [none|select|lselect]");
        }
    }
}
