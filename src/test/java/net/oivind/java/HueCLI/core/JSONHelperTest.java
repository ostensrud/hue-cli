package net.oivind.java.HueCLI.core;

import net.oivind.java.HueCLI.DataTypes.Light;
import org.junit.Test;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class JSONHelperTest {
    private JSONHelper jsonHelper = new JSONHelper();

    @Test
    public void should_map_json_of_all_lights_to_information_object() throws Exception {
        Map<String, Light> lights = jsonHelper.mapJsonToObject(getJson(), Light.gsonType);

        assertThat(lights).isNotNull();
        assertThat(lights.size()).isEqualTo(9);
    }

    @Test
    public void should_map_json_to_objects_correctly() {
        Map<String, Light> lights = jsonHelper.mapJsonToObject(getJson(), Light.gsonType);

        assertThat(lights.get("1").getName()).isEqualToIgnoringCase("bordlampe");
        assertThat(lights.get("2").getState().isOn()).isEqualTo(true);
    }

    private String getJson() {
        return "{\n" +
                "    \"1\": {\n" +
                "        \"state\": {\n" +
                "            \"on\": true,\n" +
                "            \"bri\": 200,\n" +
                "            \"hue\": 34377,\n" +
                "            \"sat\": 109,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"xy\": [\n" +
                "                0.3503,\n" +
                "                0.3537\n" +
                "            ],\n" +
                "            \"ct\": 206,\n" +
                "            \"alert\": \"none\",\n" +
                "            \"colormode\": \"hs\",\n" +
                "            \"reachable\": true\n" +
                "        },\n" +
                "        \"type\": \"Extended color light\",\n" +
                "        \"name\": \"Bordlampe\",\n" +
                "        \"modelid\": \"LCT007\",\n" +
                "        \"manufacturername\": \"Philips\",\n" +
                "        \"uniqueid\": \"00:17:88:01:10:4e:50:7a-0b\",\n" +
                "        \"swversion\": \"5.50.1.19085\"\n" +
                "    },\n" +
                "    \"2\": {\n" +
                "        \"state\": {\n" +
                "            \"on\": true,\n" +
                "            \"bri\": 200,\n" +
                "            \"hue\": 34377,\n" +
                "            \"sat\": 109,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"xy\": [\n" +
                "                0.3503,\n" +
                "                0.3537\n" +
                "            ],\n" +
                "            \"ct\": 206,\n" +
                "            \"alert\": \"none\",\n" +
                "            \"colormode\": \"hs\",\n" +
                "            \"reachable\": true\n" +
                "        },\n" +
                "        \"type\": \"Extended color light\",\n" +
                "        \"name\": \"Spisebord\",\n" +
                "        \"modelid\": \"LCT007\",\n" +
                "        \"manufacturername\": \"Philips\",\n" +
                "        \"uniqueid\": \"00:17:88:01:10:37:88:b9-0b\",\n" +
                "        \"swversion\": \"5.50.1.19085\"\n" +
                "    },\n" +
                "    \"3\": {\n" +
                "        \"state\": {\n" +
                "            \"on\": true,\n" +
                "            \"bri\": 200,\n" +
                "            \"hue\": 34377,\n" +
                "            \"sat\": 109,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"xy\": [\n" +
                "                0.3503,\n" +
                "                0.3537\n" +
                "            ],\n" +
                "            \"ct\": 206,\n" +
                "            \"alert\": \"none\",\n" +
                "            \"colormode\": \"hs\",\n" +
                "            \"reachable\": true\n" +
                "        },\n" +
                "        \"type\": \"Extended color light\",\n" +
                "        \"name\": \"Gulvlampe\",\n" +
                "        \"modelid\": \"LCT007\",\n" +
                "        \"manufacturername\": \"Philips\",\n" +
                "        \"uniqueid\": \"00:17:88:01:10:37:7e:9d-0b\",\n" +
                "        \"swversion\": \"5.50.1.19085\"\n" +
                "    },\n" +
                "    \"4\": {\n" +
                "        \"state\": {\n" +
                "            \"on\": false,\n" +
                "            \"bri\": 254,\n" +
                "            \"hue\": 0,\n" +
                "            \"sat\": 0,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"xy\": [\n" +
                "                0.3804,\n" +
                "                0.3768\n" +
                "            ],\n" +
                "            \"ct\": 247,\n" +
                "            \"alert\": \"none\",\n" +
                "            \"colormode\": \"hs\",\n" +
                "            \"reachable\": true\n" +
                "        },\n" +
                "        \"type\": \"Extended color light\",\n" +
                "        \"name\": \"Soverom tak 1\",\n" +
                "        \"modelid\": \"LCT007\",\n" +
                "        \"manufacturername\": \"Philips\",\n" +
                "        \"uniqueid\": \"00:17:88:01:10:25:75:9e-0b\",\n" +
                "        \"swversion\": \"5.50.1.19085\"\n" +
                "    },\n" +
                "    \"5\": {\n" +
                "        \"state\": {\n" +
                "            \"on\": false,\n" +
                "            \"bri\": 254,\n" +
                "            \"hue\": 0,\n" +
                "            \"sat\": 0,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"xy\": [\n" +
                "                0.3804,\n" +
                "                0.3768\n" +
                "            ],\n" +
                "            \"ct\": 247,\n" +
                "            \"alert\": \"none\",\n" +
                "            \"colormode\": \"hs\",\n" +
                "            \"reachable\": true\n" +
                "        },\n" +
                "        \"type\": \"Extended color light\",\n" +
                "        \"name\": \"Soverom tak 2\",\n" +
                "        \"modelid\": \"LCT007\",\n" +
                "        \"manufacturername\": \"Philips\",\n" +
                "        \"uniqueid\": \"00:17:88:01:10:55:62:0f-0b\",\n" +
                "        \"swversion\": \"5.50.1.19085\"\n" +
                "    },\n" +
                "    \"6\": {\n" +
                "        \"state\": {\n" +
                "            \"on\": false,\n" +
                "            \"bri\": 254,\n" +
                "            \"hue\": 16767,\n" +
                "            \"sat\": 252,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"xy\": [\n" +
                "                0.4998,\n" +
                "                0.4498\n" +
                "            ],\n" +
                "            \"ct\": 439,\n" +
                "            \"alert\": \"none\",\n" +
                "            \"colormode\": \"xy\",\n" +
                "            \"reachable\": true\n" +
                "        },\n" +
                "        \"type\": \"Extended color light\",\n" +
                "        \"name\": \"Soverom tak 3\",\n" +
                "        \"modelid\": \"LCT007\",\n" +
                "        \"manufacturername\": \"Philips\",\n" +
                "        \"uniqueid\": \"00:17:88:01:10:25:77:62-0b\",\n" +
                "        \"swversion\": \"5.50.1.19085\"\n" +
                "    },\n" +
                "    \"7\": {\n" +
                "        \"state\": {\n" +
                "            \"on\": false,\n" +
                "            \"bri\": 163,\n" +
                "            \"hue\": 5695,\n" +
                "            \"sat\": 252,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"xy\": [\n" +
                "                0.6424,\n" +
                "                0.3509\n" +
                "            ],\n" +
                "            \"alert\": \"none\",\n" +
                "            \"colormode\": \"xy\",\n" +
                "            \"reachable\": true\n" +
                "        },\n" +
                "        \"type\": \"Color light\",\n" +
                "        \"name\": \"Under senga\",\n" +
                "        \"modelid\": \"LST001\",\n" +
                "        \"manufacturername\": \"Philips\",\n" +
                "        \"uniqueid\": \"00:17:88:01:00:cb:ef:0e-0b\",\n" +
                "        \"swversion\": \"5.23.1.13452\"\n" +
                "    },\n" +
                "    \"8\": {\n" +
                "        \"state\": {\n" +
                "            \"on\": false,\n" +
                "            \"bri\": 200,\n" +
                "            \"hue\": 34377,\n" +
                "            \"sat\": 109,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"xy\": [\n" +
                "                0.3503,\n" +
                "                0.3537\n" +
                "            ],\n" +
                "            \"ct\": 206,\n" +
                "            \"alert\": \"none\",\n" +
                "            \"colormode\": \"hs\",\n" +
                "            \"reachable\": true\n" +
                "        },\n" +
                "        \"type\": \"Extended color light\",\n" +
                "        \"name\": \"Ballong\",\n" +
                "        \"modelid\": \"LCT007\",\n" +
                "        \"manufacturername\": \"Philips\",\n" +
                "        \"uniqueid\": \"00:17:88:01:10:4d:19:66-0b\",\n" +
                "        \"swversion\": \"5.50.1.19085\"\n" +
                "    },\n" +
                "    \"9\": {\n" +
                "        \"state\": {\n" +
                "            \"on\": true,\n" +
                "            \"bri\": 23,\n" +
                "            \"hue\": 785,\n" +
                "            \"sat\": 253,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"xy\": [\n" +
                "                0.6743,\n" +
                "                0.3205\n" +
                "            ],\n" +
                "            \"ct\": 153,\n" +
                "            \"alert\": \"none\",\n" +
                "            \"colormode\": \"xy\",\n" +
                "            \"reachable\": true\n" +
                "        },\n" +
                "        \"type\": \"Extended color light\",\n" +
                "        \"name\": \"Alfreds nattlys\",\n" +
                "        \"modelid\": \"LST002\",\n" +
                "        \"manufacturername\": \"Philips\",\n" +
                "        \"uniqueid\": \"00:17:88:01:01:1d:bb:a6-0b\",\n" +
                "        \"swversion\": \"5.50.2.19072\"\n" +
                "    }\n" +
                "}";
    }
}