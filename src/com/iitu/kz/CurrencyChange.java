package com.iitu.kz;

public interface CurrencyChange {
    void kztToEur(Double change);
    void kztToUsd(Double change);
    void kztToRub(Double change);

    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers();
}
