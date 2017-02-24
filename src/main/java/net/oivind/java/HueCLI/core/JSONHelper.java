package net.oivind.java.HueCLI.core;

import com.google.gson.Gson;
import net.oivind.java.HueCLI.DataTypes.Light;

import java.lang.reflect.Type;

public class JSONHelper {
    private final Gson gson = new Gson();

    public <T> T mapJsonToObject(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    public Light mapJsonToObject(String json) {
        return gson.fromJson(json, Light.class);
    }

    public <T> String mapObjectToJson(T object) {
        return gson.toJson(object);
    }
}