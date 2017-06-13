package com.coffeevanapp.model.entities;

/**
 * Created by daria on 01.05.17.
 */
public class Van implements Comparable<Van> {
    private int capacity;
    private int quantity;

    public Van(int capacity, int quantity){
        this.capacity = capacity;
        this.quantity = quantity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Van otherVan) {
        return Integer.compare(this.capacity, otherVan.capacity);
    }

    @Override
    public String toString() {
        return "Van{" +
                "capacity=" + capacity +
                ", quantity=" + quantity +
                '}';
    }
}
