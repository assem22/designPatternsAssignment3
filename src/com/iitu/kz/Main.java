package com.iitu.kz;

import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static CurrencyChange publisher = new NationalBank();


    public static void main(String[] args) {
        Subscriber exchangeOffice = new ExchangeOffice();
        Subscriber secondTierBank = new SecondTierBank();
        Subscriber logger = new Logger();

        publisher.addSubscriber(exchangeOffice);
        publisher.addSubscriber(secondTierBank);
        publisher.addSubscriber(logger);

//        publisher.kztToRub(6.4);

        while (true){
            menu();
        }
    }

    private static void menu() {
        System.out.println("Changing the currency:\n" +
                "[1] KZT-EUR\n" +
                "[2] KZT-USD\n" +
                "[3] KZT-RUB\n" +
                "[4] Exit");
        int choice = in.nextInt();
        System.out.println("Enter the value:");
        double change = in.nextDouble();
        switch (choice){
            case 1:
                publisher.kztToEur(change);
                break;
            case 2:
                publisher.kztToUsd(change);
                break;
            case 3:
                publisher.kztToRub(change);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}
