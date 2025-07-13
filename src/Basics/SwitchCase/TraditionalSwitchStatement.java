package Basics.SwitchCase;
public class TraditionalSwitchStatement {
    public static void main(String[] args) {
        String day = "MONDAY";
        int dayValue;

        switch (day) {
            case "MONDAY":
                dayValue = 1;
                break;
            case "TUESDAY":
                dayValue = 2;
                break;
            case "WEDNESDAY":
                dayValue = 3;
                break;
            default:
                dayValue = 0;
        }

        System.out.println("Day Value: " + dayValue);
    }
}
