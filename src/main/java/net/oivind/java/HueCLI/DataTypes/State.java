package net.oivind.java.HueCLI.DataTypes;

public class State {
    private final boolean on;
    private final int bri;
    private final int hue;
    private final int sat;
    private final String effect;
    private final Float[] xy;
    private final int ct;
    private final String alert;
    private final String colormode;
    private final boolean reachable;

    private State(StateBuilder builder) {
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

    public State(boolean on, int bri, int hue, int sat, String effect, Float[] xy, int ct, String alert, String colormode, boolean reachable) {
        this.on = on;
        this.bri = bri;
        this.hue = hue;
        this.sat = sat;
        this.effect = effect;
        this.xy = xy;
        this.ct = ct;
        this.alert = alert;
        this.colormode = colormode;
        this.reachable = reachable;
    }

    public boolean isOn() {
        return on;
    }

    public int getBri() {
        return bri;
    }

    public int getHue() {
        return hue;
    }

    public int getSat() {
        return sat;
    }

    public String getEffect() {
        return effect;
    }

    public Float[] getXy() {
        return xy;
    }

    public int getCt() {
        return ct;
    }

    public String getAlert() {
        return alert;
    }

    public String getColormode() {
        return colormode;
    }

    public boolean isReachable() {
        return reachable;
    }

    public static class StateBuilder {
        private boolean on;
        private int bri;
        private int hue;
        private int sat;
        private String effect;
        private Float[] xy;
        private int ct;
        private String alert;
        private String colormode;
        private boolean reachable;

        public StateBuilder withOn(boolean on) {
            this.on = on;
            return this;
        }

        public StateBuilder withBrightness(int brightness) {
            this.bri = brightness;
            return this;
        }

        public StateBuilder withHue(int hue) {
            this.hue = hue;
            return this;
        }

        public StateBuilder withSaturation(int saturation) {
            this.sat = saturation;
            return this;
        }

        public StateBuilder withEffect(String effect) {
            this.effect = effect;
            return this;
        }

        public StateBuilder withXY(Float[] xy) {
            this.xy = xy;
            return this;
        }

        public StateBuilder withCT(int ct) {
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

        public StateBuilder withReachable(boolean reachable) {
            this.reachable = reachable;
            return this;
        }

        public State build() {
            return new State(this);
        }
    }
}
