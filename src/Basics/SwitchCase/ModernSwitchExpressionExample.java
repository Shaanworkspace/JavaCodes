package Basics.SwitchCase;

public class ModernSwitchExpressionExample {
    public static void main(String[] args) {
        String day = "TUESDAY";

        int dayValue = switch (day) {
            case "MONDAY" -> 1;
            case "TUESDAY" -> 2;
            case "WEDNESDAY" -> 3;
            default -> 0;
        };

        System.out.println("Day Value: " + dayValue);
    }
}

class MultiLabelSwitch {
    public static void main(String[] args) {
        String day = "SATURDAY";

        String type = switch (day) {
            case "SATURDAY", "SUNDAY" -> "Weekend";
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
            default -> "Unknown";
        };

        System.out.println("Day Type: " + type);
    }
}

class SwitchYieldExample {
    public static void main(String[] args) {
        String grade = "B";

        String remark = switch (grade) {
            case "A" -> "Excellent";
            case "B" -> {
                System.out.println("Processing B grade");
                yield "Good";
            }
            case "C" -> "Average";
            default -> "Invalid grade";
        };

        System.out.println("Remark: " + remark);
    }
}
