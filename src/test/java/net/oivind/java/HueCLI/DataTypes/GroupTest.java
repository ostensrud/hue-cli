package net.oivind.java.HueCLI.DataTypes;

import net.oivind.java.HueCLI.core.JSONHelper;
import org.junit.Test;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class GroupTest {

    private JSONHelper jsonHelper = new JSONHelper();

    @Test
    public void should_generate_group_json() throws Exception {
        Group groupBuilder = new Group.GroupBuilder()
                .withName("Kitchen")
                .withAction(
                        new State.StateBuilder()
                        .withOn(false)
                        .build()
                )
                .build();

        String json = jsonHelper.mapObjectToJson(groupBuilder);

        assertThat(json).isEqualToIgnoringCase("{\"name\":\"Kitchen\",\"action\":{\"on\":false}}");
        System.out.println(json);
    }

    @Test
    public void should_map_json_to_group_object() throws Exception {
        Map<String, Group> groups = jsonHelper.mapJsonToObject(getGroupJSON(), Group.gsonType);

        assertThat(groups.size()).isEqualTo(2);

        Group group1 = groups.get("1");
        Group group2 = groups.get("2");

        assertThat(group1.name).isEqualTo("Group 1");
        assertThat(group1.lights.length).isEqualTo(2);
        assertThat(group1.action.isOn()).isTrue();

        assertThat(group2.name).isEqualTo("Group 2");
        assertThat(group2.lights.length).isEqualTo(3);
        assertThat(group2.action.isOn()).isFalse();
    }

    private String getGroupJSON() {
        return "{\n" +
                "    \"1\": {\n" +
                "        \"name\": \"Group 1\",\n" +
                "        \"lights\": [\n" +
                "            \"1\",\n" +
                "            \"2\"\n" +
                "        ],\n" +
                "        \"type\": \"LightGroup\",\n" +
                "        \"action\": {\n" +
                "            \"on\": true,\n" +
                "            \"bri\": 254,\n" +
                "            \"hue\": 10000,\n" +
                "            \"sat\": 254,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"xy\": [\n" +
                "                0.5,\n" +
                "                0.5\n" +
                "            ],\n" +
                "            \"ct\": 250,\n" +
                "            \"alert\": \"select\",\n" +
                "            \"colormode\": \"ct\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"2\": {\n" +
                "        \"name\": \"Group 2\",\n" +
                "        \"lights\": [\n" +
                "            \"3\",\n" +
                "            \"4\",\n" +
                "            \"5\"\n" +
                "        ],\n" +
                "        \"type\": \"LightGroup\",\n" +
                "        \"state\":{\"any_on\":true, \"all_on\":true},\n" +
                "        \"action\": {\n" +
                "            \"on\": false,\n" +
                "            \"bri\": 153,\n" +
                "            \"hue\": 4345,\n" +
                "            \"sat\": 254,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"xy\": [\n" +
                "                0.5,\n" +
                "                0.5\n" +
                "            ],\n" +
                "            \"ct\": 250,\n" +
                "            \"alert\": \"select\",\n" +
                "            \"colormode\": \"ct\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }
}