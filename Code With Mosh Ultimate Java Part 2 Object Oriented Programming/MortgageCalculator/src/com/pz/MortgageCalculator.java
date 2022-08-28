package com.pz;

import java.text.NumberFormat;

public class MortgageCalculator {
    private int principal;
    private double monthlyRate;
    private int numberOfPayments;

    public MortgageCalculator(int principal, double monthlyRate, int numberOfPayments) {
        this.principal = principal;
        this.monthlyRate = monthlyRate;
        this.numberOfPayments = numberOfPayments;
    }

    public double calculateMortgage() {
        return principal
                * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
    }

    public double calculateRemainingLoan(int numberOfPaymentsDone) {
        return principal
                * (Math.pow(1 + monthlyRate, numberOfPayments) - Math.pow(1 + monthlyRate, numberOfPaymentsDone))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
    }

    public double[] getRemainingLoans() {
        double[] balances = new double[numberOfPayments];
        for (int numberOfPaymentsDone = 0; numberOfPaymentsDone < numberOfPayments; numberOfPaymentsDone++) {
            balances[numberOfPaymentsDone] = calculateRemainingLoan(numberOfPaymentsDone + 1);
        }
        return balances;
    }

    public int getNumberOfPayments() {
        return numberOfPayments;
    }
}
