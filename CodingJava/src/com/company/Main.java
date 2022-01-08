package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        calculateMortgage();


    }
    public static void calculateMortgage()
    {
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;
        int principal;
        float monthInterest;
        int paymentPeriodInMonths;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Mortgage Calculator..");
        principal = getPrincipal(scanner);
        monthInterest = getmMonthInterest(scanner, MONTHS_IN_YEAR, PERCENT);
        paymentPeriodInMonths = getPaymentInMonths(scanner, MONTHS_IN_YEAR);

        double mortgage = principal * ((monthInterest*Math.pow(1+monthInterest,paymentPeriodInMonths)) / (Math.pow(1+monthInterest,paymentPeriodInMonths)-1));
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));

    }
    public static int getPrincipal(Scanner scanner)
    {
        int principal;
        while(true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal<1_000 || principal > 1_000_000) {
                System.out.println("Please enter a value between 1,000 and 1,000,000.");
                continue;
            }
            return principal;
        }

    }
    public static float getmMonthInterest(Scanner scanner, byte MONTHS_IN_YEAR ,byte PERCENT)
    {
        float annualInterest;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest =scanner.nextFloat();
            if(annualInterest<0 || annualInterest>30) {
                System.out.println("Please enter a value between 0 and 30.");
                continue;
            }
            break;
        }
        return  annualInterest/MONTHS_IN_YEAR/PERCENT;
    }
    public static int getPaymentInMonths(Scanner scanner , byte MONTHS_IN_YEAR){
        byte paymentPeriodInYears;
        while (true) {
            System.out.print("Period (Years): ");
            paymentPeriodInYears =scanner.nextByte();
            if(paymentPeriodInYears<0 || paymentPeriodInYears>30) {
                System.out.println("Please enter a value between 0 and 30.");
                continue;
            }
            break;
        }
        return paymentPeriodInYears*MONTHS_IN_YEAR;
    }
}
