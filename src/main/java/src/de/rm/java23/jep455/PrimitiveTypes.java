package src.de.rm.java23.jep455;

/**
 * Demonstrating enhanced pattern matching <a href="https://openjdk.org/jeps/455">JEP: 455</a>
 */
public class PrimitiveTypes {

    static String printGrade(int grade) {
        return switch (grade) {
            case 1 -> "very good";
            case 2 -> "good";
            case 3 -> "satisfactory";
            case 4 -> "sufficient";
            case 5 -> "poor";
            case 6 -> "deficient";
            case Integer i -> "Undefined grade: " + i;
        };
    }

    static String checkByte(int value) {
        if (value instanceof byte b) {
            return "byte b = " + b;
        } else {
            return "no byte: " + value;
        }
    }

    static String guardedPatterns(int value) {
        if (value instanceof byte b && b > 0) {
            return "positive byte value: " + b;
        } else {
            return "negative or not of type byte: " + value;
        }
    }

}
