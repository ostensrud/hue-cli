package net.oivind.java.HueCLI.DataTypes;

public class State {
    private final Boolean on;
    private final Integer bri;
    private final Integer hue;
    private final Integer sat;
    private final String effect;
    private final Double[] xy;
    private final Integer ct;
    private final String alert;
    private final String colormode;
    private final Boolean reachable;

    State(StateBuilder builder) {
        this.on = builder.on;
        this.bri = builder.bri;
        this.hue = builder.hue;
        this.sat = builder.sat;
        this.effect = builder.effect;
        this.xy = builder.xy;
        this.ct = builder.ct;
        this.alert = builder.alert;
        this.colormode = builder.colormode;
        this.reachable = builder.reachable;
    }

    public Boolean isOn() {
        return on;
    }

    public Integer getBri() {
        return bri;
    }

    public Integer getHue() {
        return hue;
    }

    public Integer getSat() {
        return sat;
    }

    public String getEffect() {
        return effect;
    }

    public Double[] getXy() {
        return xy;
    }

    public Integer getCt() {
        return ct;
    }

    public String getAlert() {
        return alert;
    }

    public String getColormode() {
        return colormode;
    }

    public Boolean isReachable() {
        return reachable;
    }

    public static class StateBuilder {
        private Boolean on;
        private Integer bri;
        private Integer hue;
        private Integer sat;
        private String effect;
        private Double[] xy;
        private Integer ct;
        private String alert;
        private String colormode;
        private Boolean reachable;

        public StateBuilder withOn(Boolean on) {
            this.on = on;
            return this;
        }

        public StateBuilder withBrightness(Integer brightness) {
            this.bri = brightness;
            return this;
        }

        public StateBuilder withHue(Integer hue) {
            this.hue = hue;
            return this;
        }

        public StateBuilder withSaturation(Integer saturation) {
            this.sat = saturation;
            return this;
        }

        public StateBuilder withEffect(String effect) {
            this.effect = effect;
            return this;
        }

        public StateBuilder withXY(Double[] xy) {
            this.xy = xy;
            return this;
        }

        public StateBuilder withCT(Integer ct) {
            this.ct = ct;
            return this;
        }

        public StateBuilder withAlert(String alert) {
            this.alert = alert;
            return this;
        }

        public StateBuilder withColormode(String colormode) {
            this.colormode = colormode;
            return this;
        }

        public StateBuilder withReachable(Boolean reachable) {
            this.reachable = reachable;
            return this;
        }

        public State build() {
            return new State(this);
        }
    }
}
