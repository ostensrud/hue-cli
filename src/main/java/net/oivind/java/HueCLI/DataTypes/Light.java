package net.oivind.java.HueCLI.DataTypes;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class Light {

    public final static Type gsonType = new TypeToken<Map<String, Light>>(){}.getType();

    private final State state;
    private final String type;
    private final String name;
    private final String modelid;
    private final String manufacturername;
    private final String uniqueid;
    private final String swversion;

    private Light(LightBuilder builder) {
        this.state = builder.state;
        this.type = builder.type;
        this.name = builder.name;
        this.modelid = builder.modelId;
        this.manufacturername = builder.manufacturername;
        this.uniqueid = builder.uniqueid;
        this.swversion = builder.swversion;
    }

    public Light(int lightNumber, State state, String type, String name, String modelid, String manufacturername, String uniqueid, String swversion) {
        this.state = state;
        this.type = type;
        this.name = name;
        this.modelid = modelid;
        this.manufacturername = manufacturername;
        this.uniqueid = uniqueid;
        this.swversion = swversion;
    }

    public State getState() {
        return state;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getModelid() {
        return modelid;
    }

    public String getManufacturername() {
        return manufacturername;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public String getSwversion() {
        return swversion;
    }

    public static class LightBuilder {
        private State state;
        private String type;
        private String name;
        private String modelId;
        private String manufacturername;
        private String uniqueid;
        private String swversion;

        public LightBuilder withState(State state) {
            this.state = state;
            return this;
        }

        public LightBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public LightBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public LightBuilder withModelId(String modelId) {
            this.modelId = modelId;
            return this;
        }

        public LightBuilder withManufacturerName(String manufacturername) {
            this.manufacturername = manufacturername;
            return this;
        }

        public LightBuilder withUniqueId(String uniqueId) {
            this.uniqueid = uniqueId;
            return this;
        }

        public LightBuilder withSWVersion(String swVersion) {
            this.swversion = swVersion;
            return this;
        }

        public Light build() {
            return new Light(this);
        }
    }
}
