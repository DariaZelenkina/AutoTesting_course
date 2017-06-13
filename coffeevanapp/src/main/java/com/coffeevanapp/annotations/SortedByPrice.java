package com.coffeevanapp.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by daria on 16.05.17.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface SortedByPrice {
    String message() default "Default sorting is by price.";
}
