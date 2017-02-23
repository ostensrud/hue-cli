package net.oivind.java.HueCLI.util;

import net.oivind.java.HueCLI.DataTypes.Light;

import java.util.Map;

public class PrettyPrinter {
    public static void printAllLights(Map<String, Light> lights) {
        StringBuilder sb = new StringBuilder();

        int counter = 1;
        for (String key : lights.keySet()) {
            sb.append(String.format("%3s", counter++))
                    .append(String.format(" %-20s", lights.get(key).getName()))
                    .append(String.format("%-2s", "["))
                    .append(String.format("%-3s", getOnOff(lights.get(key).getState().isOn())))
                    .append(String.format("%2s", "]"))
                    .append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void printOneLight(Light light) {
        StringBuilder sb = new StringBuilder();

        String format = "%-15s%s%n";
        String indent = "\t%-15s%s%n";

        sb.append(String.format(format, "Name:", light.getName()))
                .append(String.format(format, "Type:", light.getType()))
                .append(String.format(format, "Model id:", light.getModelid()))
                .append(String.format(format, "Manufacturer:", light.getManufacturername()))
                .append(String.format(format, "Unique id:", light.getUniqueid()))
                .append(String.format(format, "SW version:", light.getSwversion()))
                .append(String.format(format, "[", ""))
                .append(String.format(indent, "On:", light.getState().isOn()))
                .append(String.format(indent, "Brightness:", light.getState().getBri()))
                .append(String.format(indent, "Hue:", light.getState().getHue()))
                .append(String.format(indent, "Saturation:", light.getState().getSat()))
                .append(String.format(indent, "Effect", light.getState().getEffect()))
                .append(String.format(indent, "CT:", light.getState().getCt()))
                .append(String.format(indent, "Alert:", light.getState().getAlert()))
                .append(String.format(indent, "Colormode:", light.getState().getColormode()))
                .append(String.format(indent, "Reachable:", light.getState().isReachable()))
                .append(String.format(format, "]", ""));

        System.out.println(sb.toString());
    }

    public static String getOnOff(boolean state) {
        return state ? "on" : "off";
    }
}
