package net.oivind.java.HueCLI.core;

import net.oivind.java.HueCLI.DataTypes.Light;
import net.oivind.java.HueCLI.Net.HttpHandler;
import net.oivind.java.HueCLI.properties.PropertiesReader;

import java.io.IOException;
import java.util.Map;
import java.util.StringJoiner;

public class CommandHandler {
    private HttpHandler httph;
    private PropertiesReader pr;
    private JSONHelper jsonHelper;
    private HueOperations hueOp  = new HueOperations();

    public CommandHandler(HttpHandler httph, PropertiesReader pr, JSONHelper jsonHelper) {
        this.httph = httph;
        this.pr = pr;
        this.jsonHelper = jsonHelper;
    }

    public void showAllLights() throws IOException {
        System.out.println();
        Map<String, Light> lights = jsonHelper.mapJsonToObject(httph.doGet(buildUrl() + "/" + hueOp.getPath("default")), Light.gsonType);
        StringBuilder sb = new StringBuilder();

        int counter = 1;
        for (String key : lights.keySet()) {
            sb.append(counter++)
                    .append(" : ")
                    .append(lights.get(key).getName())
                    .append(" [")
                    .append(lights.get(key).getState().isOn())
                    .append("]\n");
        }

        System.out.print(sb.toString());
    }

    public void showOneLight(int lightNumber) throws IOException {
        System.out.println(httph.doGet(buildUrl() + "/" + hueOp.getPath("default") + "/" + Integer.toString(lightNumber)));
    }

    public void toggleState(int lightNumber, boolean turnOn) throws IOException {
        String json = "{\"on\":" + Boolean.toString(turnOn) + "}";
        System.out.println(httph.doPut(buildUrl() + "/" + hueOp.getPath("default") + "/" + Integer.toString(lightNumber) + "/" + hueOp.getPath("change_state"), json));
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
