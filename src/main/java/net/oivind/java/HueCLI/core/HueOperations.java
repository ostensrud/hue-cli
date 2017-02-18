package net.oivind.java.HueCLI.core;

import java.util.HashMap;

public class HueOperations {

    HashMap<String, String> operations = new HashMap<>();

    HueOperations() {
        addOperations();
    }

    private void addOperations() {
        operations.put("show_all_lights", "lights");
        operations.put("show_one_light", "lights");
        operations.put("change_state", "lights");
    }

    public String getPath(String operation) {
        return operations.get(operation);
    }


}
