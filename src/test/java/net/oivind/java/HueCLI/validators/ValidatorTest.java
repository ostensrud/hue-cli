package net.oivind.java.HueCLI.validators;

import net.oivind.java.HueCLI.parser.CLIOptions;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.junit.Test;

public class ValidatorTest {
    DefaultParser parser = new DefaultParser();
    CLIOptions options = new CLIOptions();
    private CommandLine cmd;

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_state_change_is_missing_light_number() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--brightness=200"});
        Validator.validate(cmd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_light_number_is_specified_with_show_all() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--light=1", "--show-lights"});
        Validator.validate(cmd);
    }

    @Test
    public void should_only_allow_show_all() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--show-lights"});
        Validator.validate(cmd);
    }

    @Test
    public void should_allow_light_number_without_other_params() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--light=1"});
        Validator.validate(cmd);
    }
}