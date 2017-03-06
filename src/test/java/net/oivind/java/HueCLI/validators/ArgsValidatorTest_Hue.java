package net.oivind.java.HueCLI.validators;

import net.oivind.java.HueCLI.parser.CLIOptions;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.junit.Test;

public class ArgsValidatorTest_Hue {
    DefaultParser parser = new DefaultParser();
    CLIOptions options = new CLIOptions();
    private CommandLine cmd;

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_hue_is_not_a_number() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--hue","banana"});
        ArgsValidator.validateHue(cmd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_hue_is_a_negative_number() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--hue=-1"});
        ArgsValidator.validateHue(cmd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_hue_is_larger_than_65536() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--hue=65536"});
        ArgsValidator.validateHue(cmd);
    }

    @Test
    public void should_allow_0_as_hue() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--hue","0"});
        ArgsValidator.validateHue(cmd);
    }

    @Test
    public void should_allow_65535_as_hue() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--hue","65535"});
        ArgsValidator.validateHue(cmd);
    }
}
