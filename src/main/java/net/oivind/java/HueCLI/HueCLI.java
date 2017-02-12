package net.oivind.java.HueCLI;

import net.oivind.java.HueCLI.parser.CLIParser;

public class HueCLI {

    public static void main( String[] args ) {
        CLIParser cliParser = new CLIParser();
        cliParser.doParse(args);
    }
}
