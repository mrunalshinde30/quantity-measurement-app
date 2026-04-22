

// ENUM
enum LengthUnit {
    FEET(12.0),
    INCHES(1.0);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}

// MAIN CLASS
public class QuantityMeasurementApp {

    // INNER CLASS
    static class Length {
        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        // Convert to inches
        private double toInches() {
            return value * unit.getFactor();
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Length other = (Length) obj;

            return Double.compare(this.toInches(), other.toInches()) == 0;
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Are equal? " + l1.equals(l2));
    }
}