package com.pz;

public class Main {
    static final byte MONTHS_IN_YEAR = 12;
    static final byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1000d, 1000000d);
        double annualRate = Console.readNumber("Annual Interest Rate: ", 1, 30);
        double monthlyRate = annualRate / MONTHS_IN_YEAR / PERCENT;
        int period = (int) Console.readNumber("Period (Years): ", 1, 30);
        int numberOfPayments = period * 12;

        var mortgageCalculator = new MortgageCalculator(principal, monthlyRate, numberOfPayments);
        new MortgageReport(mortgageCalculator).printReport();
    }

}
