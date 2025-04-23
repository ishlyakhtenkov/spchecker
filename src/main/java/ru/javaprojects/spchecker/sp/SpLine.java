package ru.javaprojects.spchecker.sp;

public record SpLine(String format, String zone, String position, String designation, String name, String quantity,
                     String note) {

    public static class Builder {
        private String format;
        private String zone;
        private String position;
        private String designation;
        private String name;
        private String quantity;
        private String note;

        public Builder format(String format) {
            this.format = format;
            return this;
        }

        public Builder zone(String zone) {
            this.zone = zone;
            return this;
        }

        public Builder position(String position) {
            this.position = position;
            return this;
        }

        public Builder designation(String designation) {
            this.designation = designation;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public SpLine build() {
            return new SpLine(format, zone, position, designation, name, quantity, note);
        }
    }
}
