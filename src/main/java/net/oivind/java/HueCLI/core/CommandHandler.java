package net.oivind.java.HueCLI.core;

import net.oivind.java.HueCLI.Net.HttpHandler;
import net.oivind.java.HueCLI.properties.PropertiesReader;

import java.io.IOException;
import java.util.StringJoiner;

public class CommandHandler {
    private HttpHandler httph = new HttpHandler();
    private PropertiesReader pr = new PropertiesReader();
    private HueOperations hueOp = new HueOperations();

    public void showAllLights() throws IOException {
        System.out.println(httph.doGet(buildUrl() + "/" + hueOp.getPath("default")));
    }

    public void showOneLight(int lightNumber) throws IOException {
        System.out.println(httph.doGet(buildUrl() + "/" + hueOp.getPath("default") + "/" + Integer.toString(lightNumber)));
    }

    public void toggleState(int lightNumber, boolean turnOn) throws IOException {
        String json = "{\"on\":"+Boolean.toString(turnOn)+"}";
        System.out.println(httph.doPut(buildUrl() + "/" + hueOp.getPath("default") + "/" + Integer.toString(lightNumber)+"/"+hueOp.getPath("change_state"),json));
    }

    private String buildUrl() {
        StringJoiner sj = new StringJoiner("/");

        try {
            sj.add(pr.getProperty("huecli.url"));
            sj.add(pr.getProperty("huecli.username"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sj.toString();
    }
}
