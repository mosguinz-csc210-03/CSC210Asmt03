/*
 * Assignment 03
 * Description: [Part 3 of 3] Compound interest calculator
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * Teammate: Amber Hartigan
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        loop();
    }

    /**
     * Run the program loop.
     */
    public static void loop() {
        printHeader();

        /* Create a Scanner object. */
        Scanner scan = new Scanner(System.in);

        /* Prompt and scan the user's input for the deposit parameters. */
        System.out.print("Enter your principal deposit amount (in $): ");
        double principalSum = scan.nextDouble();
        System.out.print("Enter your compounding frequency (per annum): ");
        double compoundFreq = scan.nextDouble();
        System.out.print("Enter your compound annual interest rate (in %): ");
        double interestRate = scan.nextDouble() / 100;  // convert percent to decimal
        System.out.print("Enter your deposit term (in years): ");
        double depositTerm = scan.nextDouble();

        /* Display the report. */
        displayReport(principalSum, compoundFreq, interestRate, depositTerm);
    }

    /**
     * Print the program's header.
     */
    private static void printHeader() {
        System.out.println("COMPOUND INTEREST CALCULATOR");
        System.out.println("============================");
    }

    /**
     * Display the compound interest report from the given parameters.
     * <p>
     * Shows the interest generated per period, cumulative interests, and the new principal balance for each report
     * frequency.
     * <p>
     * The report frequency is quarterly for deposit terms of 2 years and under. Yearly for all others.
     *
     * @param principalSum The original principal sum, also the "original deposit amount"
     * @param compoundFreq The compounding frequency (in a year)
     * @param interestRate The nominal annual interest rate
     * @param depositTerm  The length of time the interest is applied, also "deposit term"
     */
    private static void displayReport(double principalSum,
                                      double compoundFreq,
                                      double interestRate,
                                      double depositTerm) {

        /* Show a quarterly report if the deposit term is 2 years or less. */
        double reportFrequency = depositTerm <= 2 ? 0.25 : 1;

        /* Re-summarize the user's parameters in words. */
        System.out.println("\n" + "=".repeat(56));
        System.out.printf("Your %s compound interest report:%n", reportFrequency == 1 ? "yearly" : "quarterly");
        System.out.printf("Principal sum of $%.2f with a %.2f-year deposit term%n", principalSum, depositTerm);
        System.out.printf("compounding %.0f time(s) per year at %.2f%% p.a.%n", compoundFreq, interestRate * 100);
        System.out.println("=".repeat(56));

        /* Print the column headers. */
        System.out.printf(" %7s │ %12s │ %12s │ %12s%n", "Deposit", "Interest", "Cumulative", "New");
        System.out.printf(" %7s │ %12s │ %12s │ %12s%n", "length", "at period", "interest", "principal");
        System.out.println("-".repeat(56));

        /* Generate the table. */
        double newSum, prevAccumInterest = 0, currentInterest, accumInterest;
        for (double length = 0; length <= depositTerm; length += reportFrequency) {
            newSum = calculateNewPrincipal(principalSum, compoundFreq, interestRate, length);
            accumInterest = newSum - principalSum;                // total generated interest
            currentInterest = accumInterest - prevAccumInterest;  // interest generated at this period

            /* Print the row for this period. */
            System.out.printf("%,5.2f yr │ $ %,10.2f │ $ %,10.2f │ $ %,10.2f%n", length, currentInterest, accumInterest, newSum);
            prevAccumInterest = accumInterest;
        }

        /* Re-calculate the final principal balance and print the summary. */
        double finalSum = calculateNewPrincipal(principalSum, compoundFreq, interestRate, depositTerm);
        System.out.println("=".repeat(56));
        System.out.printf("%23s: $ %,10.2f%n", "Original principal sum", principalSum);
        System.out.printf("%23s: $ %,10.2f%n", "Interest generated", finalSum - principalSum);
        System.out.printf("%23s: $ %,10.2f%n", "Final principal balance", finalSum);
    }

    /**
     * Calculate the new principal amount after a certain period.
     * <p>
     * Derived from: https://en.wikipedia.org/wiki/Compound_interest#Periodic_compounding
     *
     * @param principalSum     The original principal sum, also the "original deposit amount"
     * @param compoundFreq     The compounding frequency (in a year)
     * @param interestRate     The nominal annual interest rate
     * @param timeSinceDeposit The length of time since the initial deposit
     * @return The new principal balance at the given period.
     */
    private static double calculateNewPrincipal(double principalSum,
                                                double compoundFreq,
                                                double interestRate,
                                                double timeSinceDeposit) {
        return principalSum * Math.pow(1 + (interestRate / compoundFreq), compoundFreq * timeSinceDeposit);
    }
}
