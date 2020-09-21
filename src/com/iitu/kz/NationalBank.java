package com.iitu.kz;

import java.util.ArrayList;
import java.util.List;

public class NationalBank implements CurrencyChange{
    private List<Subscriber> subscribers;
    private double kztInEur = 499.46;
    private double kztInRub = 5.57;
    private double kztInUsd = 421.25;
    private double oldKztInEur = 499.46;
    private double oldKztInRub = 5.57;
    private double oldKztInUsd = 421.25;

    public double getKztInEur() {
        return kztInEur;
    }

    public double getKztInRub() {
        return kztInRub;
    }

    public double getKztInUsd() {
        return kztInUsd;
    }

    @Override
    public void kztToEur(Double change) {
        oldKztInEur = getKztInEur();
        this.kztInEur = change;
        notifySubscribers();
    }

    @Override
    public void kztToUsd(Double change) {
        oldKztInUsd = getKztInUsd();
        this.kztInUsd = change;
        notifySubscribers();
    }

    public double getOldKztInEur() {
        return oldKztInEur;
    }

    public double getOldKztInRub() {
        return oldKztInRub;
    }

    public double getOldKztInUsd() {
        return oldKztInUsd;
    }

    @Override
    public void kztToRub(Double change) {
        oldKztInRub = getKztInRub();
        this.kztInRub = change;
        notifySubscribers();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (subscribers == null){
            subscribers = new ArrayList<>();
        }
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers){
            subscriber.update(this);
        }
    }
}
