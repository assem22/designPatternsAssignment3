package com.iitu.kz;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger implements Subscriber{
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now;
//    System.out.println(dtf.format(now));

    @Override
    public void update(CurrencyChange currency) {
        now = LocalDateTime.now();
        System.out.println("Logger of currency changes");
        if (currency instanceof NationalBank) {
            NationalBank nationalBank = ((NationalBank) currency);
            if (nationalBank.getKztInEur() != nationalBank.getOldKztInEur()){
                System.out.println("The currency of KZT-EUR was changed!");
                System.out.println("The currency was changed from: " + nationalBank.getOldKztInEur() +
                        "\nTo: " + nationalBank.getKztInEur());
            }
            if (nationalBank.getKztInRub() != nationalBank.getOldKztInRub()){
                System.out.println("The currency of KZT-RUB was changed!");
                System.out.println("The currency was changed from: " + nationalBank.getOldKztInRub() +
                        "\nTo: " + nationalBank.getKztInRub());
            }
            if (nationalBank.getKztInUsd() != nationalBank.getOldKztInUsd()){
                System.out.println("The currency of KZT-USD was changed!");
                System.out.println("The currency was changed from: " + nationalBank.getOldKztInUsd() +
                        "\nTo: " + nationalBank.getKztInUsd());
            }
            System.out.println("Date: " + dtf.format(now));
        }
    }
}
