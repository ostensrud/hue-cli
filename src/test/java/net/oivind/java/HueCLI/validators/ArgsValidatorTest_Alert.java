package net.oivind.java.HueCLI.validators;

import net.oivind.java.HueCLI.parser.CLIOptions;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.junit.Test;

public class ArgsValidatorTest_Alert {
    DefaultParser parser = new DefaultParser();
    CLIOptions options = new CLIOptions();
    private CommandLine cmd;

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_argument_is_not_none_select_or_lselect() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--alert=critical"});
        ArgsValidator.validateAlert(this.cmd);
    }

    @Test
    public void should_allow_none_select_or_lselect() throws Exception {
        cmd = parser.parse(options.getOptions(), new String[]{"--alert=none"});
        ArgsValidator.validateAlert(this.cmd);

        cmd = parser.parse(options.getOptions(), new String[]{"--alert=select"});
        ArgsValidator.validateAlert(this.cmd);

        cmd = parser.parse(options.getOptions(), new String[]{"--alert=lselect"});
        ArgsValidator.validateAlert(this.cmd);
    }
}
