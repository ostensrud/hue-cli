package net.oivind.java.HueCLI.DataTypes;

import net.oivind.java.HueCLI.core.JSONHelper;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StateTest {

    private JSONHelper jsonHelper = new JSONHelper();

    @Test
    public void should_build_state_with_only_the_given_fields() throws Exception {
        State stateBuilder = new State.StateBuilder()
                .withOn(false)
                .build();
        String json = jsonHelper.mapObjectToJson(stateBuilder);

        assertThat(json).isEqualToIgnoringCase("{\"on\":false}");
    }

    @Test
    public void should_build_state_with_all_fields() throws Exception {
        Double[] doubles = new Double[2];
        doubles[0] = 0.3503;
        doubles[1] = 0.3537;

        State state = new State.StateBuilder()
                .withOn(true)
                .withBrightness(200)
                .withHue(34377)
                .withSaturation(109)
                .withEffect("none")
                .withXY(doubles)
                .withCT(206)
                .withAlert("none")
                .withColormode("hs")
                .withReachable(true)
                .build();

        String json = jsonHelper.mapObjectToJson(state);
        assertThat(json).isEqualTo(stateJson());
    }

    private String stateJson() {
        return "{\"on\":true,\"bri\":200,\"hue\":34377,\"sat\":109,\"effect\":\"none\",\"xy\":[0.3503,0.3537],\"ct\":206,\"alert\":\"none\",\"colormode\":\"hs\",\"reachable\":true}";
    }
}