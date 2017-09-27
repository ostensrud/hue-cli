package net.oivind.java.HueCLI.core;

import java.util.HashMap;

public class HueOperations {

    HashMap<String, String> operations = new HashMap<>();

    HueOperations() {
        addOperations();
    }

    private void addOperations() {
        operations.put("default", "lights");
        operations.put("change_state", "state");
        operations.put("groups", "groups");
    }

    public String getPath(String operation) {
        return operations.get(operation);
    }


}
