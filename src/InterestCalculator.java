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

    public static void loop() {
        printHeader();

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your principal deposit amount (in $): ");
        double principalSum = scan.nextDouble();
        System.out.print("Enter your compounding frequency (per annum): ");
        double compoundFreq = scan.nextDouble();
        System.out.print("Enter your compound annual interest rate (in %): ");
        double interestRate = scan.nextDouble() / 100;
        System.out.print("Enter your deposit term (in years): ");
        double depositTerm = scan.nextDouble();

        displayReport(principalSum, compoundFreq, interestRate, depositTerm);
    }

    /**
     * Print the program's header.
     */
    private static void printHeader() {
        System.out.println("COMPOUND INTEREST CALCULATOR");
        System.out.println("============================");
    }

    private static void displayReport(double principalSum,
                                      double compoundFreq,
                                      double interestRate,
                                      double depositTerm) {

        /* Show a quarterly report if the deposit term is 2 years or less. */
        double reportFrequency = depositTerm <= 2 ? 0.25 : 1;
        System.out.println("\n" + "=".repeat(56));
        System.out.printf("Your %s compound interest report:%n", reportFrequency == 1 ? "yearly" : "quarterly");
        System.out.printf("Principal sum of $%.2f with a %.2f-year deposit term%n", principalSum, depositTerm);
        System.out.printf("compounding %.0f time(s) per year at %.2f%% p.a.%n", compoundFreq, interestRate * 100);
        System.out.println("=".repeat(56));
        System.out.printf(" %7s │ %12s │ %12s │ %12s%n", "Deposit", "Interest", "Cumulative", "New");
        System.out.printf(" %7s │ %12s │ %12s │ %12s%n", "length", "at period", "interest", "principal");
        System.out.println("-".repeat(56));
        double newSum, prevAccumInterest = 0, currentInterest, accumInterest;
        for (double length = 0; length <= depositTerm; length += reportFrequency) {
            newSum = calculateNewPrincipal(principalSum, compoundFreq, interestRate, length);
            accumInterest = newSum - principalSum;
            currentInterest = accumInterest - prevAccumInterest;
            System.out.printf("%,5.2f yr │ $ %,10.2f │ $ %,10.2f │ $ %,10.2f%n", length, currentInterest, accumInterest, newSum);
            prevAccumInterest = accumInterest;
        }
    }

    private static double calculateNewPrincipal(double principalSum,
                                                double compoundFreq,
                                                double interestRate,
                                                double timeSinceDeposit) {
        return principalSum * Math.pow(1 + (interestRate / compoundFreq), compoundFreq * timeSinceDeposit);
    }
}
