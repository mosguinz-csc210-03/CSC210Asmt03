import java.util.Scanner;

public class TableBmiPro {

    private static final String LINE_SEP = "^".repeat(63);


    public static void main(String[] args) {
        loop();
    }

    /**
     * Calculate the BMI from the given weight and height.
     *
     * @param heightFt Floor height in feet.
     * @param heightIn Floor height in inches.
     * @param weight Weight in pounds.
     * @return The BMI value (lbs/in^2)
     */
    private static double calculateBMI(double heightFt, double heightIn, double weight) {
        return 703 * weight / Math.pow(heightFt * 12 + heightIn, 2);
    }

    /**
     * Print the program header.
     * Made to be identical to the example, as required by part (1)(5).
     */
    private static void printHeader() {
        System.out.println(LINE_SEP);
        System.out.println("^ Welcome to:");
        System.out.println("^    BODY MASS INDEX (BMI) Computation PRO");
        System.out.println("^               by Mos");
        System.out.println("^");
        System.out.println(LINE_SEP);
    }

    /**
     * Run the program loop.
     */
    private static void loop() {
        printHeader();

        /* Create a Scanner object. */
        Scanner scan = new Scanner(System.in);

        /* Input prompts for height (in feet and inches, split on first whitespace) */
        System.out.print("Enter height in feet and inches: ");
        int heightFt = scan.nextInt();
        int heightIn = scan.nextInt();

        /* Input prompts for min and max weights. */
        System.out.print("Enter the low weight in pounds: ");
        double weightMin = scan.nextDouble();
        System.out.print("Enter the high weight in pounds: ");
        double weightMax = scan.nextDouble();
    }
}
