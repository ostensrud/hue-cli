package net.oivind.java.HueCLI.parser;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CLIOptions {

    private Options options = new Options();

    public static final String SHOW_ALL_LIGHTS = "show-lights";
    public static final String TOGGLE = "toggle";
    public static final String LIGHT = "light";
    public static final String BRIGHTNESS = "brightness";
    public static final String HUE = "hue";
    public static final String ALERT = "alert";
    public static final String SHOW_ALL_GROUPS = "show-groups";

    public CLIOptions() {
        addOptions();
    }

    protected void addOptions() {

        options.addOption(Option.builder("l")
                .longOpt(LIGHT)
                .hasArg()
                .numberOfArgs(1)
                .argName("light number")
                .desc("n - Light number. Used without any other options it will show information about one light.")
                .build());

        options.addOption(Option.builder("s")
                .argName("s")
                .longOpt(SHOW_ALL_LIGHTS)
                .hasArg(false)
                .desc("Show all lights")
                .build());

        options.addOption(Option.builder("t")
                .longOpt(TOGGLE)
                .desc("[on|off] - Turn light on or off")
                .hasArg()
                .numberOfArgs(1)
                .valueSeparator()
                .build());

        options.addOption(Option.builder("b")
                .longOpt(BRIGHTNESS)
                .desc("[1-254] - Change the brightness of a light")
                .hasArg()
                .numberOfArgs(1)
                .build());

        options.addOption(Option.builder("h")
                .longOpt(HUE)
                .desc("[0 - 65535] Change the color of a light")
                .hasArg()
                .numberOfArgs(1)
                .build());

        options.addOption(Option.builder("a")
                .longOpt(ALERT)
                .desc("[none|select|lselect]")
                .hasArg()
                .numberOfArgs(1)
                .build());

        options.addOption(Option.builder("g")
                .longOpt(SHOW_ALL_GROUPS)
                .desc("Show all groups")
                .build());
    }

    public Options getOptions() {
        return options;
    }
}
