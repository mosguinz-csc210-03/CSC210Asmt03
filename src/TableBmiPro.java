/*
 * Assignment 03
 * Description: BMI Code Reuse
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * Teammate: Amber Hartigan
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

import java.util.Scanner;

public class TableBmiPro {
    public static void main(String[] args) {
        System.out.print("Please enter 1 for the Standard version or 2 for the Pro version: ");
        int option = new Scanner(System.in).nextInt();
        if (option == 1) _BMI.loop();
        else if (option == 2) _TableBmi.loop();

    }
}

/**
 * From part 1 of 3 of assignment 03.
 * https://github.com/mosguinz-csc210-03/CSC210Asmt03/blob/master/src/TableBmi.java
 */
class _TableBmi {

    /* 63-column wide separator in compliance with (3)(a). */
    private static final String LINE_SEP = "^".repeat(63);

    public static void main(String[] args) {
        loop();
    }

    /**
     * Display the BMI table from the given parameters.
     *
     * @param height The height in inches.
     * @param weightMax The maximum weight in pounds.
     * @param weightMin THe minimum weight in pounds.
     */
    private static void displayTable(double height, double weightMax, double weightMin) {
        /* Print table header. */
        System.out.println("\nWEIGHT\t BMI\t\t CONDITION");

        /* Generate and print BMI table in increments of 5 lbs.*/
        double bmi;
        String cond;
        for (; weightMin <= weightMax; weightMin += 5) {
            /* Calculate the BMI. */
            bmi = calculateBMI(weightMin, height);
            /* Determine if the BMI is considered "overweight". */
            cond = bmi > 25 ? "overweight" : "not overweight";
            /* Print the table row. */
            System.out.printf("%.0f\t\t %3.4f\t %s%n", weightMin, bmi, cond);
        }
    }

    /**
     * Calculate the BMI from the given weight and height.
     *
     * @param weight Weight in pounds.
     * @param height Height in inches.
     * @return The BMI value (lbs/in^2).
     */
    private static double calculateBMI(double weight, double height) {
        return 703 * weight / (height * height);
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
    public static void loop() {
        printHeader();

        /* Create a Scanner object. */
        Scanner scan = new Scanner(System.in);

        /* Input prompts for height (in feet and inches, split on first whitespace) */
        System.out.print("Enter height in feet and inches: ");
        int height = scan.nextInt() * 12 + scan.nextInt();

        /* Input prompts for min and max weights. */
        System.out.print("Enter the low weight in pounds: ");
        double weightMin = scan.nextDouble();
        System.out.print("Enter the high weight in pounds: ");
        double weightMax = scan.nextDouble();

        /* Display the table and print termination message. */
        displayTable(height, weightMax, weightMin);
        System.out.println('\n' + LINE_SEP);
        System.out.println("^    Thank you for using my program.");
        System.out.println(LINE_SEP);
    }
}


/**
 * From part 1 of 3 of assessment 01.
 * https://github.com/mosguinz-csc210-03/CSC210Asmt01/blob/master/src/BMI.java
 */
class _BMI {
    public static void main(String[] args) {
        loop();
    }

    /**
     * Calculate the BMI from the given weight and height.
     *
     * @param weight Weight in pounds.
     * @param height Height in inches.
     * @return The BMI value (lbs/in^2).
     */
    private static double calculateBMI(double weight, double height) {
        return 703 * weight / (height * height);
    }

    /**
     * Print the program welcome header, as required by (3)(a).
     */
    private static void printHeader() {
        System.out.println("============================");
        System.out.println("Welcome to my BMI calculator");
        System.out.println("============================");
    }

    /**
     * Run the program loop.
     */
    public static void loop() {
        printHeader();

        // Create a Scanner object.
        Scanner scan = new Scanner(System.in);

        // Input prompts for height (in feet and inches, separately).
        System.out.println("Please enter your height in feet and inches (press Enter after each number)");
        System.out.print("Feet: ");
        int heightFt = scan.nextInt();
        System.out.print("Inches: ");
        int heightIn = scan.nextInt();
        System.out.printf("Your height: %d'%d\"", heightFt, heightIn);

        // Input prompt for weight.
        System.out.printf("\n\nPlease enter your weight in pounds: ");
        double weight = scan.nextDouble();

        // Format and print output to 2 decimal places.
        System.out.printf("Your weight: %.2f lbs", weight);
        System.out.printf("\n\n>>> Your BMI is: %.2f", calculateBMI(weight, heightFt * 12 + heightIn));
    }
}