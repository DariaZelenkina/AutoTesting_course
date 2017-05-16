import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by daria on 10.04.17.
 *
 * Программа, выводящая в консоль надпись
 * Hello, world!
 * And hi again!
 * !!!!!!
 * Число восклиц.знаков - случайное число в диапазоне 5-50
 */
public class HelloWorld {

    public static void main(String[] args) {
        int excl_number = ThreadLocalRandom.current().nextInt(5, 51);
        String s = "Hello, world!\nAnd hi again!\n";
        System.out.println(s);
        for (int i=0; i < excl_number; i++) {
            System.out.print("!");
        }

    }
}
