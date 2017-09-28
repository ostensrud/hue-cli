package net.oivind.java.HueCLI.DataTypes;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class Group {

    public final static Type gsonType = new TypeToken<Map<String, Group>>(){}.getType();

    final String name;
    final Integer[] lights;
    final String type;
    final State action;
    final GroupState state;

    private Group(GroupBuilder builder) {
        this.name = builder.name;
        this.lights = builder.lights;
        this.type = builder.type;
        this.action = builder.action;
        this.state = builder.state;
    }

    public String getName() {
        return name;
    }

    public State getAction() {
        return action;
    }

    public GroupState getState() {
        return state;
    }

    public Integer[] getLights() {
        return lights;
    }

    public String getType() {
        return type;
    }

    public static class GroupBuilder {
        private String name;
        private Integer[] lights;
        private String type;
        private State action;
        private GroupState state;

        public GroupBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public GroupBuilder withLights(Integer[] lights) {
            this.lights = lights;
            return this;
        }

        public GroupBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public GroupBuilder withAction(State action) {
            this.action = action;
            return this;
        }

        public GroupBuilder withState(GroupState state) {
            this.state = state;
            return this;
        }

        public Group build() {
            return new Group(this);
        }
    }

}
