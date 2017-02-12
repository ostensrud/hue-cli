package net.oivind.java.HueCLI.core;

import net.oivind.java.HueCLI.Net.HttpHandler;
import net.oivind.java.HueCLI.properties.PropertiesReader;

import java.io.IOException;

public class CommandHandler {
    private HttpHandler httph = new HttpHandler();
    private PropertiesReader pr = new PropertiesReader();

    public void showAllLights() throws IOException {

        String url = pr.getProperty("huecli.url");
        String username = pr.getProperty("huecli.username");

        System.out.println(httph.doGet(url + "/" + username + "/lights"));

    }
}
