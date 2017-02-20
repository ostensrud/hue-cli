package net.oivind.java.HueCLI.core;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JSONHelper {

    public <T> T mapJsonToObject(String json, Type typeOfT) {
        Gson gson = new Gson();
        return gson.fromJson(json, typeOfT);
    }
}
