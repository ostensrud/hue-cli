package net.oivind.java.HueCLI.DataTypes;

public class GroupState {
    final boolean any_on;
    final boolean all_on;

    private GroupState(GroupStateBuilder builder) {
        this.any_on = builder.any_on;
        this.all_on = builder.all_on;
    }

    public boolean isAll_on() {
        return all_on;
    }

    public boolean isAny_on() {
        return any_on;
    }

    public static class GroupStateBuilder {
        private boolean any_on;
        private boolean all_on;

        public GroupStateBuilder withAnyOn(boolean any_on) {
            this.any_on = any_on;
            return this;
        }

        public GroupStateBuilder withAllOn(boolean all_on) {
            this.all_on = all_on;
            return this;
        }
    }
}
