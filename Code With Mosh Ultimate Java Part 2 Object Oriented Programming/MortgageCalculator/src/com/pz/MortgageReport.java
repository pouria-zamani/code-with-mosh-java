package com.pz;

import java.text.NumberFormat;

public class MortgageReport {
    private MortgageCalculator mortgageCalculator;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
    }

    public void printReport() {
        System.out.println("Mortgage");
        System.out.println("--------------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgageCalculator.calculateMortgage()));
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("--------------");
        double[] balances = mortgageCalculator.getRemainingLoans();
        for (int i = 0; i < mortgageCalculator.getNumberOfPayments(); i++) {
            System.out.println(NumberFormat.getCurrencyInstance().format(balances[i]));
        }
    }
}
