package net.oivind.java.HueCLI.core;

import net.oivind.java.HueCLI.DataTypes.Light;
import net.oivind.java.HueCLI.DataTypes.State;
import net.oivind.java.HueCLI.Net.HttpHandler;
import net.oivind.java.HueCLI.parser.CLIOptions;
import net.oivind.java.HueCLI.properties.PropertiesReader;
import org.apache.commons.cli.CommandLine;

import java.io.IOException;
import java.util.Map;
import java.util.StringJoiner;

import static net.oivind.java.HueCLI.util.PrettyPrinter.printAllLights;
import static net.oivind.java.HueCLI.util.PrettyPrinter.printOneLight;

public class CommandHandler {
    private HttpHandler httph;
    private PropertiesReader pr;
    private JSONHelper jsonHelper;
    private HueOperations hueOp = new HueOperations();

    public CommandHandler(HttpHandler httph, PropertiesReader pr, JSONHelper jsonHelper) {
        this.httph = httph;
        this.pr = pr;
        this.jsonHelper = jsonHelper;
    }

    // TODO: Better solutions for state/toggle and url-building

    public void showAllLights() throws IOException {
        Map<String, Light> lights = jsonHelper.mapJsonToObject(httph.doGet(buildUrl() + "/" + hueOp.getPath("default")), Light.gsonType);
        printAllLights(lights);
    }

    public void showOneLight(int lightNumber) throws IOException {
        String lightInfo = httph.doGet(buildUrl() + "/" + hueOp.getPath("default") + "/" + Integer.toString(lightNumber));
        Light light = jsonHelper.mapJsonToObject(lightInfo);
        printOneLight(light);
    }

    public void toggleState(int lightNumber, boolean turnOn) throws IOException {
        String json = "{\"on\":" + Boolean.toString(turnOn) + "}";
        System.out.println(httph.doPut(
                buildUrl() + "/" +
                        hueOp.getPath("default") + "/" +
                        Integer.toString(lightNumber) + "/" +
                        hueOp.getPath("change_state"),
                json)
        );
    }

    public void changeState(int lightNumber, CommandLine cmd) throws IOException {
        State.StateBuilder stateBuilder = new State.StateBuilder();

        if (cmd.hasOption(CLIOptions.BRIGHTNESS)) {
            stateBuilder.withBrightness(Integer.parseInt(cmd.getOptionValue(CLIOptions.BRIGHTNESS)));
        }
        if (cmd.hasOption(CLIOptions.HUE)) {
            stateBuilder.withHue(Integer.parseInt(cmd.getOptionValue(CLIOptions.HUE)));
        }
        if (cmd.hasOption(CLIOptions.ALERT)) {
            stateBuilder.withAlert(cmd.getOptionValue(CLIOptions.ALERT));
        }

        System.out.println(httph.doPut(
                buildUrl() + "/" +
                        hueOp.getPath("default") + "/" +
                        Integer.toString(lightNumber) + "/" +
                        hueOp.getPath("change_state"),
                jsonHelper.mapObjectToJson(stateBuilder.build())));
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
