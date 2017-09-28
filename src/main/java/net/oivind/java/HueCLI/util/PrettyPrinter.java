package net.oivind.java.HueCLI.util;

import net.oivind.java.HueCLI.DataTypes.Group;
import net.oivind.java.HueCLI.DataTypes.Light;

import java.util.Map;

public class PrettyPrinter {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BOLD = "\u001B[1m";


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

    public static void printAllGroups(Map<String, Group> groups) {
        StringBuilder sb = new StringBuilder();

        int counter = 1;
        for (String key : groups.keySet()) {
            sb.append(String.format("%3s", counter++))
                    .append(String.format(" %-20s", groups.get(key).getName()))
                    .append(String.format("%-1s", "["))
                    .append(String.format(" %-20s", showGroupState(groups.get(key), groups.get(key).getLights().length)))
                    .append(String.format("%2s", "]"))
                    .append("\n");
        }

        System.out.println(sb.toString());
    }

    private static String showGroupState(Group group, Integer numberOfLights) {
        if (group.getState() == null) {
            return null;
        }

        if (group.getState().isAny_on() && group.getState().isAll_on()) {
            return ANSI_GREEN+"all lights("+ numberOfLights +") are on"+ANSI_RESET;
        }

        if (group.getState().isAny_on() && !group.getState().isAll_on()) {
            return ANSI_YELLOW+"some lights("+ numberOfLights +") are on"+ANSI_RESET;
        }

        return ANSI_RED+"all lights are off"+ANSI_RESET;
    }

    public static void printOneLight(Light light) {
        String format = "%-15s%s%n";
        String indent = "\t%-15s%s%n";

        System.out.println(String.format(format, "Name:", light.getName()) +
                String.format(format, "Type:", light.getType()) +
                String.format(format, "Model id:", light.getModelid()) +
                String.format(format, "Manufacturer:", light.getManufacturername()) +
                String.format(format, "Unique id:", light.getUniqueid()) +
                String.format(format, "SW version:", light.getSwversion()) +
                String.format(format, "[", "") +
                String.format(indent, "On:", light.getState().isOn()) +
                String.format(indent, "Brightness:", light.getState().getBri()) +
                String.format(indent, "Hue:", light.getState().getHue()) +
                String.format(indent, "Saturation:", light.getState().getSat()) +
                String.format(indent, "Effect", light.getState().getEffect()) +
                String.format(indent, "CT:", light.getState().getCt()) +
                String.format(indent, "Alert:", light.getState().getAlert()) +
                String.format(indent, "Colormode:", light.getState().getColormode()) +
                String.format(indent, "Reachable:", light.getState().isReachable()) +
                String.format(format, "]", ""));
    }

    public static String getOnOff(boolean state) {
        return state ? ANSI_GREEN+"on"+ANSI_RESET : ANSI_RED+"off"+ANSI_RESET;
    }
}
