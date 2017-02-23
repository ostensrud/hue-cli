package net.oivind.java.HueCLI.core;

import com.google.gson.Gson;
import net.oivind.java.HueCLI.DataTypes.Light;

import java.lang.reflect.Type;

public class JSONHelper {

    public <T> T mapJsonToObject(String json, Type typeOfT) {
        Gson gson = new Gson();
        return gson.fromJson(json, typeOfT);
    }

    public Light mapJsonToObject(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Light.class);
    }
}