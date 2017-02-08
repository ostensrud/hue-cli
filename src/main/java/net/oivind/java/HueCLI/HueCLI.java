package net.oivind.java.HueCLI;

public class HueCLI {

    public static void main( String[] args ) {
        CLIParser cliParser = new CLIParser();
        cliParser.doParse(args);
    }
}
