package com.coffeevanapp.utils;

import com.coffeevanapp.annotations.SortedByPrice;

/**
 * Created by daria on 15.05.17.
 */
public class SortedByPriceParser {

    public void parse (Class<?> annotatedClass) {
        SortedByPrice annotation = annotatedClass.getAnnotation(SortedByPrice.class);
        System.out.println(annotation.message());

    }
}
