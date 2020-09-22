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

        double newSum, prevAccumInterest = 0, currentInterest, accumInterest;
        for (double length = 0; length <= depositTerm; length += reportFrequency) {
            newSum = calculateNewPrincipal(principalSum, compoundFreq, interestRate, length);
            accumInterest = newSum - principalSum;
            currentInterest = accumInterest - prevAccumInterest;
            System.out.printf("%,.2f\t%,.2f\t%,.2f\t%,.2f%n", length, currentInterest, accumInterest, newSum);
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
