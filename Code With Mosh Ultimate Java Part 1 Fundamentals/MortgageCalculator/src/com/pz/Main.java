package com.pz;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final byte MONTHS_IN_YEAR = 12;
    static final byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000d, 1000000d);
        double annualRate = readNumber("Annual Interest Rate: ", 1, 30);
        double monthlyRate = annualRate / MONTHS_IN_YEAR / PERCENT;
        int period = (int) readNumber("Period (Years): ", 1, 30);
        int numberOfPayments = period * 12;

        printResult(principal, monthlyRate, numberOfPayments);
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value <= max && value >= min)
                break;
            System.out.println("Enter a value between " + min + " and " + max + ".");
        }
        return value;
    }

    public static double calculateMortgage(int principal, double monthlyRate, int numberOfPayments) {
        return principal
                * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
    }

    public static void printResult(int principal, double monthlyRate, int numberOfPayments) {
        System.out.println("Mortgage");
        System.out.println("--------------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(calculateMortgage(principal, monthlyRate, numberOfPayments)));
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("--------------");
        for (int numberOfPaymentsDone = 0; numberOfPaymentsDone < numberOfPayments; numberOfPaymentsDone++) {
            System.out.println(NumberFormat.getCurrencyInstance().format(calculateRemainingLoan(principal, monthlyRate, numberOfPayments, numberOfPaymentsDone + 1)));
        }
    }

    public static double calculateRemainingLoan(int principal, double monthlyRate, int numberOfPayments, int numberOfPaymentsDone) {
        return principal
                * (Math.pow(1 + monthlyRate, numberOfPayments) - Math.pow(1 + monthlyRate, numberOfPaymentsDone))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
    }
}
