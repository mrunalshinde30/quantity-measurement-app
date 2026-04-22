
// Length class (Generic from UC3, reused)
class Length {
    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert everything to base unit (inches)
    private double toBase() {
        return value * unit.getConversionFactor();
    }

    // Compare two lengths
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Length)) return false;

        Length other = (Length) obj;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}

// ENUM (ONLY PLACE CHANGED IN UC4)
enum LengthUnit {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),          // 1 yard = 36 inches
    CENTIMETERS(0.393701); // 1 cm = 0.393701 inches

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}

// MAIN CLASS
public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // Feet vs Inches
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Feet vs Inches: " + l1.equals(l2)); // true

        // Yard vs Feet
        Length l3 = new Length(1.0, LengthUnit.YARDS);
        Length l4 = new Length(3.0, LengthUnit.FEET);
        System.out.println("Yard vs Feet: " + l3.equals(l4)); // true

        // Yard vs Inches
        Length l5 = new Length(1.0, LengthUnit.YARDS);
        Length l6 = new Length(36.0, LengthUnit.INCHES);
        System.out.println("Yard vs Inches: " + l5.equals(l6)); // true

        // CM vs Inches
        Length l7 = new Length(1.0, LengthUnit.CENTIMETERS);
        Length l8 = new Length(0.393701, LengthUnit.INCHES);
        System.out.println("CM vs Inches: " + l7.equals(l8)); // true

        // Different values
        Length l9 = new Length(2.0, LengthUnit.YARDS);
        Length l10 = new Length(5.0, LengthUnit.FEET);
        System.out.println("Different values: " + l9.equals(l10)); // false
    }
}