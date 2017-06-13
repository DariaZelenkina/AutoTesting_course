package com.coffeevanapp.model.entities;

import com.coffeevanapp.annotations.MethodInfo;
import com.coffeevanapp.annotations.SortedByPrice;
import com.coffeevanapp.enums.CoffeeType;
import com.coffeevanapp.exceptions.NoSuchObjectFoundException;
import com.coffeevanapp.interfaces.Displayable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

/**
 * Created by daria on 08.05.17.
 */
@SortedByPrice
public class CoffeeVan implements Displayable {

    private Coffee[] availableCoffee;
    private int availableSpace;
    private boolean sortedByPriceFlag;

    public CoffeeVan(Set<Coffee> coffeeSet, int chosenVanCapacity) {
        this.availableCoffee = coffeeSet.toArray(new Coffee[coffeeSet.size()]);
        this.availableSpace = chosenVanCapacity;
        this.sortedByPriceFlag = true;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }
    public void setAvailableSpace(int availableSpace) {
        this.availableSpace = availableSpace;
    }
    public boolean isSortedByPriceFlag() {
        return sortedByPriceFlag;
    }
    public void setSortedByPriceFlag(boolean sortedByPriceFlag) {
        this.sortedByPriceFlag = sortedByPriceFlag;
    }
    public Coffee[] getAvailableCoffee() {
        return availableCoffee;
    }
    public void setAvailableCoffee(Coffee[] availableCoffee) {
        this.availableCoffee = availableCoffee;
    }

    @Override
    public void displayObjects() {
        int i = 0;
        for (Coffee coffee : availableCoffee) {
            System.out.println(++i + ". " + coffee.toString());
        }
    }

    /** Sort by Coffee Type */
    public void filterByCoffeeType(){
        Arrays.sort(availableCoffee, new Comparator<Coffee>() {
            @Override
            public int compare(Coffee coffee1, Coffee coffee2) {
                return coffee1.getCoffeeType().name().compareTo(coffee2.getCoffeeType().name());
            }
        });
        sortedByPriceFlag = false;
    }

    /** @param availableSum
     * add all types of coffee to the chosen van
     * given available sum of money and initial capacity of the van*/
    public void fillVan(int availableSum){

        int currentSum = 0;

        mainloop:
        while (true) {
            for (Coffee coffee : availableCoffee) {
                if (coffee.getQuantityInStore() == 0) {
                    continue;
                }

                if ((currentSum + coffee.getPrice()) > availableSum ||
                        (coffee.getCoffeeType().getVolume()) > availableSpace) {
                    break mainloop;
                }
                currentSum += coffee.getPrice();
                availableSpace -= coffee.getCoffeeType().getVolume();
                coffee.setQuantityInStore(coffee.getQuantityInStore() - 1);
                coffee.setQuantityInVan(coffee.getQuantityInVan() + 1);

            }
        }
    }

    /**@param minPrice
     * @param maxPrice
     * @throws NoSuchObjectFoundException
     */
    @MethodInfo(info = "Searches for coffee product within given price range by binary search")
    public void searchByPrice(int minPrice, int maxPrice) throws NoSuchObjectFoundException {

        boolean coffeeWasFound = false;
        if(!sortedByPriceFlag) {
            Arrays.sort(availableCoffee);
        }
        int start = 0;
        int end = availableCoffee.length;
        int i = 0;
        while (start < end) {
            int currentIndex = (start + end)/2;
            if (availableCoffee[currentIndex].getPrice() > maxPrice) {
                end = currentIndex;
            }
            else if (availableCoffee[currentIndex].getPrice() < minPrice) {
                start = currentIndex + 1;
            }
            else {
                coffeeWasFound = true;
                System.out.println(++i + ". " + availableCoffee[currentIndex].toString());
                start++;
            }
            if (!coffeeWasFound) {
                throw new NoSuchObjectFoundException("There is no coffee within this price range.");
            }
        }
    }

    /** Find coffee of given type
     * @param coffeeType
     * @throws NoSuchObjectFoundException
     */
    public void searchByCoffeeType(CoffeeType coffeeType) throws NoSuchObjectFoundException{

        boolean coffeeWasFound = false;
        int i = 0;
        for (Coffee coffee : availableCoffee) {
            if(coffee.getCoffeeType().equals(coffeeType)) {
                coffeeWasFound = true;
                System.out.println(++i + ". " + coffee.toString());
            }
        }
        if (!coffeeWasFound) {
            throw new NoSuchObjectFoundException("There is no coffee of type = ");
        }
    }

}
