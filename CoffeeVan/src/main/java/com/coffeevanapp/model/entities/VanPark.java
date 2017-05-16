package main.java.com.coffeevanapp.model.entities;

import main.java.com.coffeevanapp.exceptions.ZeroQuantityException;
import main.java.com.coffeevanapp.interfaces.Displayable;
import main.java.com.coffeevanapp.interfaces.Storable;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by daria on 30.04.17.
 */
public class VanPark implements Storable<Van>, Displayable {

    /** collect and display all vans instances */

    private Set <Van> vanSet;

    public VanPark() {
        vanSet = new TreeSet<>();
    }

    public Set<Van> getVanSet() {
        return vanSet;
    }
    public void setVanSet(Set<Van> vanSet) {
        this.vanSet = vanSet;
    }

    public void displayObjects() {

        int i = 0;
        for (Van van : vanSet) {

            System.out.println(++i + ". " + van.toString());

        }
    }


    public void storeObjects(Van van) {
        vanSet.add(van);
    }


    public int chooseVan(int vanId) throws ZeroQuantityException {

        /** Find the van by chosen id and decrement its quantity
         * If quantity = 0, throw exception */

        Iterator<Van> iterator = vanSet.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            Van van = iterator.next();
            if (i == vanId) {

                if (van.getQuantity() == 0) {
                    throw new ZeroQuantityException("The chosen type of van is out of stock.");
                }
                van.setQuantity(van.getQuantity()-1);
                return van.getCapacity();
            }
        }
        return 0;
    }
}
