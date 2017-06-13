package com.coffeevanapp.enums;

/**
 * Created by daria on 30.04.17.
 */
public enum Packaging {
    JAR(0.4), PACKETS(0.3);

    private double volume;

    Packaging(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
}
