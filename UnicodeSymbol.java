/**
 * Created by daria on 10.04.17.
 *
 * Метод, возвращающий букву, стоящую в таблице  Unicode после символа "\"
 * на расстоянии а.
 */
public class UnicodeSymbol {

    public String symbol(int a) {
        char symbol = '\\';
        int symbCode = (int) symbol;
        String newSymbol = Character.toString((char) (symbCode+a));
        return newSymbol;
    }

    public static void main(String[] args) {
        UnicodeSymbol s = new UnicodeSymbol();
        System.out.println(s.symbol(5));
    }
}
