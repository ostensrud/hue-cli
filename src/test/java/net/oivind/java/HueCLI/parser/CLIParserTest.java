package net.oivind.java.HueCLI.parser;

import net.oivind.java.HueCLI.core.CommandHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class CLIParserTest {
    private CommandHandler commandHandler = mock(CommandHandler.class);
    private CLIParser cliParser = new CLIParser(commandHandler);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void should_show_usage_when_no_parameters_were_recognized() throws Exception {
        cliParser.doParse(new String[]{"banana"});
        assertThat(outContent.toString()).contains("Usage");
    }

    @Test
    public void should_throw_exception_when_not_all_required_parameters_are_given() throws Exception {
        cliParser.doParse(new String[]{"--light"});
        assertThat(errContent.toString()).contains("MissingArgumentException");
    }

    @Test
    public void should_parse_correctly_when_all_parameters_are_given() throws Exception {
        doNothing().when(commandHandler).showOneLight(eq(1));
        cliParser.doParse(new String[]{"--light","1"});
        assertThat(outContent.toString()).isEmpty();
        assertThat(errContent.toString()).isEmpty();
    }

    @Test
    public void should_fail_when_light_number_is_not_specified() throws Exception {
        cliParser.doParse(new String[]{"--light"});
        assertThat(errContent.toString()).contains("MissingArgumentException");
    }

    @Test
    public void should_not_fail_when_light_number_is_given_as_two_args() throws Exception {
        cliParser.doParse(new String[]{"--light", "1"});
        assertThat(errContent.toString()).isEmpty();
        assertThat(outContent.toString()).doesNotContain("Usage");
    }

    @Test
    public void should_not_fail_when_light_number_is_given_with_equals() throws Exception {
        cliParser.doParse(new String[]{"--light=1"});
        assertThat(errContent.toString()).isEmpty();
        assertThat(outContent.toString()).doesNotContain("Usage");
    }

    @Test
    public void should_show_usage_if_toggle_is_specified_without_light() throws Exception {
        cliParser.doParse(new String[]{"--toggle=off"});
        assertThat(outContent.toString()).contains("Usage");
    }

    @Test
    public void should_toggle_light_if_toggle_and_light_is_specified() throws Exception {
        doNothing().when(commandHandler).toggleState(any(int.class), any(boolean.class));
        cliParser.doParse(new String[]{"--toggle=off", "--light=1"});
        assertThat(errContent.toString()).isEmpty();
        assertThat(outContent.toString()).isEmpty();
    }

    @Test
    public void should_only_accept_on_or_off_as_argument_to_toggle() throws Exception {
        doNothing().when(commandHandler).toggleState(any(int.class), any(boolean.class));
        cliParser.doParse(new String[]{"--toggle=false", "--light=1"});
        assertThat(errContent.toString()).contains("ParseException");
    }
}