package net.oivind.java.HueCLI.validators;

import net.oivind.java.HueCLI.parser.CLIOptions;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.junit.Test;

public class ArgsValidatorTest_Brightness {
    DefaultParser parser = new DefaultParser();
    CLIOptions options = new CLIOptions();
    private CommandLine cmd;

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_brightness_is_not_a_number() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--brightness=dimmer"});
        ArgsValidator.validateBrightness(cmd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_allow_brightness_lower_than_1() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--brightness=-1"});
        ArgsValidator.validateBrightness(cmd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_allow_brightness_higher_than_254() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--brightness=255"});
        ArgsValidator.validateBrightness(cmd);
    }

    @Test
    public void should_allow_values_between_1_and_254() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--brightness=254"});
        ArgsValidator.validateBrightness(cmd);

        cmd = parser.parse(options.getOptions(), new String[]{"--brightness=1"});
        ArgsValidator.validateBrightness(cmd);

    }
}
