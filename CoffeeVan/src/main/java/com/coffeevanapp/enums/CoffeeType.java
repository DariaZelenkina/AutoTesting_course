package main.java.com.coffeevanapp.enums;

/**
 * Created by daria on 30.04.17.
 */
public enum CoffeeType {

    INSTANT_GRANULES(Packaging.JAR, Packaging.JAR.getVolume()),
    INSTANT_POWDER(Packaging.PACKETS, Packaging.PACKETS.getVolume()),
    GROUND(0.5),
    BEANS(0.7);

    private double volume;
    private Packaging packaging;

    CoffeeType(double vol) {
        this.volume = vol;
    }


    CoffeeType(Packaging packaging, double volume) {
        this.packaging = packaging;
        this.volume = volume;
    }


    public double getVolume() {return volume;}
    public void setVolume(double volume) {
        this.volume = volume;
    }
    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }
    public Packaging getPackaging() {
        return packaging;
    }


}
