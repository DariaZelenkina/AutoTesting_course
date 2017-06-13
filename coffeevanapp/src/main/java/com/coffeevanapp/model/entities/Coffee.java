package com.coffeevanapp.model.entities;

import com.coffeevanapp.enums.CoffeeType;

/**
 * Created by daria on 30.04.17.
 */
public class Coffee implements Comparable<Coffee>{

    private CoffeeType coffeeType;
    private String coffeeVariety;
    private double price;
    private int quantityInStore;
    private int quantityInVan;

    public Coffee(CoffeeType coffeeType, String coffeeVariety, double price, int quantityInStore){
        this.coffeeType = coffeeType;
        this.coffeeVariety = coffeeVariety;
        this.price = price;
        this.quantityInStore = quantityInStore;
        this.quantityInVan = 0;
    }

    public int getQuantityInStore() {
        return quantityInStore;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public String getCoffeeVariety() {
        return coffeeVariety;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInVan() {
        return quantityInVan;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public void setQuantityInStore(int quantityInStore) {
        this.quantityInStore = quantityInStore;
    }

    public void setCoffeeVariety(String coffeeVariety) {
        this.coffeeVariety = coffeeVariety;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantityInVan(int quantityInVan) {
        this.quantityInVan = quantityInVan;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeType=" + coffeeType +
                ", coffeeVariety='" + coffeeVariety + '\'' +
                ", price=" + price +
                ", quantityInStore=" + quantityInStore +
                ", quantityInVan=" + quantityInVan +
                '}';
    }

    @Override
    public int compareTo(Coffee coffee) {
        return Double.compare(this.price, coffee.price);
    }
}
