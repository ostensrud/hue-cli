package net.oivind.java.HueCLI.core;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JSONHelper {
    private final Gson gson = new Gson();

    public <T> T mapJsonToObject(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    public <T> String mapObjectToJson(T object) {
        return gson.toJson(object);
    }
}