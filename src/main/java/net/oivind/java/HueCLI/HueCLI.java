package net.oivind.java.HueCLI;

import net.oivind.java.HueCLI.Net.HttpHandler;
import net.oivind.java.HueCLI.core.CommandHandler;
import net.oivind.java.HueCLI.core.JSONHelper;
import net.oivind.java.HueCLI.parser.CLIParser;
import net.oivind.java.HueCLI.properties.PropertiesReader;
import org.apache.commons.cli.ParseException;

import java.io.IOException;

public class HueCLI {

    public static void main( String[] args ) {
        CommandHandler commandHandler = new CommandHandler(new HttpHandler(), new PropertiesReader(), new JSONHelper());
        CLIParser cliParser = new CLIParser(commandHandler);
        try {
            cliParser.doParse(args);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
