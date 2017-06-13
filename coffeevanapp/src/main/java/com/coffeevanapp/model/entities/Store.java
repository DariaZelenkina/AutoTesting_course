package com.coffeevanapp.model.entities;

import com.coffeevanapp.interfaces.Displayable;
import com.coffeevanapp.interfaces.Storable;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by daria on 30.04.17.
 */
public class Store implements Storable<Coffee>, Displayable {

    /** to collect and display all coffee instances */

    private Set<Coffee> coffeeSet;

    public Store(){
        coffeeSet = new TreeSet<>();
    }

    public Set<Coffee> getCoffeeSet() {
        return coffeeSet;
    }
    public void setCoffeeSet(Set<Coffee> coffeeSet) {
        this.coffeeSet = coffeeSet;
    }

    public void displayObjects(){
        int i = 0;
        for (Coffee coffee : coffeeSet) {
            System.out.println(++i + ". " + coffee.toString());
        }
    }

    public void storeObjects(Coffee coffee) {
        coffeeSet.add(coffee);
    }

}
