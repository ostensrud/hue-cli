package net.oivind.java.HueCLI.validators;

import net.oivind.java.HueCLI.parser.CLIOptions;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.junit.Test;

public class LightValidatorTest {
    DefaultParser parser = new DefaultParser();
    CLIOptions options = new CLIOptions();
    private CommandLine cmd;

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_light_number_is_a_negative_number() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--light=-1"});
        LightValidator.validateLightNumber(cmd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_light_number_is_not_a_number() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--light=a"});
        LightValidator.validateLightNumber(cmd);
    }

    @Test
    public void should_not_fail_when_light_number_is_a_valid_number() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--light=1"});
        LightValidator.validateLightNumber(cmd);
    }
}