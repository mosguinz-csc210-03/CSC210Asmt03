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
    }

    /**
     * Print the program's header.
     */
    private static void printHeader() {
        System.out.println("COMPOUND INTEREST CALCULATOR");
        System.out.println("============================");
    }
}