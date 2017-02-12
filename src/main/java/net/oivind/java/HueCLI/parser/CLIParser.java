package net.oivind.java.HueCLI;

import org.apache.commons.cli.*;

class CLIParser {
    private Options options = new Options();
    private DefaultParser parser = new DefaultParser();
    private HelpFormatter formatter = new HelpFormatter();

    CLIParser() {
        addOptions();
    }

    private void addOptions() {
        options.addOption(Option.builder("s")
                .argName("s")
                .longOpt("show-all")
                .desc("Show all lights")
                .build());

        options.addOption(Option.builder("l")
                .longOpt("light")
                .desc("Show info about one light")
                .hasArg()
                .build());

    }

    void doParse(String[] args) {
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("s")) {
                System.out.println("Show all lights");
            } else {
                showHelp();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void showHelp() {
        formatter.printHelp("Usage", options);
    }
}
