package main.java.com.coffeevanapp.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by daria on 14.05.17.
 */
@Target(ElementType.METHOD)

public @interface MethodInfo {
    String info();
}
