import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        long principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1K-$1M):");
            principal = scanner.nextLong();
            if(principal>=1000 && principal<=1000000)
                break;
            System.out.println("Enter a number between 1000 and 1_000_000");
        }

        while (true) {
            System.out.print("Annual Interest Rate:");
            float annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }

        while(true) {
            System.out.print("Period (Years):");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage:" + mortgageFormatted);


    }

}

