package com.iitu.kz;

public class SecondTierBank implements Subscriber{

    @Override
    public void update(CurrencyChange currency) {
        System.out.println("Second-tier Banks");
        if (currency instanceof NationalBank) {
            NationalBank nationalBank = ((NationalBank) currency);
            if (nationalBank.getKztInEur() != nationalBank.getOldKztInEur()){
                System.out.println("The currency of KZT-EUR was changed!");
                System.out.println("Price for selling: " + (nationalBank.getKztInEur()+1.7) +
                        "\nPrice for buying: " + (nationalBank.getKztInEur()-1.2) + "\n");
            }
            if (nationalBank.getKztInRub() != nationalBank.getOldKztInRub()){
                System.out.println("The currency of KZT-RUB was changed!");
                System.out.println("Price for selling: " + (nationalBank.getKztInRub()+0.7) +
                        "\nPrice for buying: " + (nationalBank.getKztInRub()-0.7) + "\n");
            }
            if (nationalBank.getKztInUsd() != nationalBank.getOldKztInUsd()){
                System.out.println("The currency of KZT-USD was changed!");
                System.out.println("Price for selling: " + (nationalBank.getKztInUsd()+1.5) +
                        "\nPrice for buying: " + (nationalBank.getKztInUsd()-1.5) + "\n");
            }
        }
    }
}
