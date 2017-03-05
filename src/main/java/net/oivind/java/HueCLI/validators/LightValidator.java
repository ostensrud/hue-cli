package net.oivind.java.HueCLI.validators;

import net.oivind.java.HueCLI.parser.CLIOptions;
import org.apache.commons.cli.CommandLine;

public class LightValidator {

    public static void validateLightNumber(CommandLine cmd) {
        String optionValue = cmd.getOptionValue(CLIOptions.LIGHT);
        try {
            int lightNumber = Integer.parseInt(optionValue);
            if (lightNumber < 0) {
                throw new IllegalArgumentException("Light number must be a positive integer");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Light number must be a positive integer");
        }
    }
}
