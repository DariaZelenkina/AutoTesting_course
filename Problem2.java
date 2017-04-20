/**
 * Created by daria on 15.04.17.
 *
 * Перечисление содержит валюты (доллар США, евро, юань, британский фунт)
 * и их коэффициенты по отношению к рублю
 * Имеет два метода по возвращению значений полей констант (имя и коэффициент)
 * А так же метод convertRUBto по конвертированию определенной суммы рублей в одну из валют
 * И метод convertToRUB по конвертированию суммы в определенной валюте в рубли.
 *
 * Метод main использует данное перечисление для перевода 100 рублей в каждую из валют
 * И перевода 100 единиц каждой валюты в рубли
 */
public class Problem2 {
    public enum Currency {
        USD("US Dollar", 0.018), EUR("Euro", 0.017), CNY("Chinese Yuan", 0.12), GBP("British Pound", 0.014);

        private final String name;
        private final double coef;
        Currency(String n, double cf) {
            this.name = n;
            this.coef = cf;
        }

        public String currencyName() {return name;}
        public double currencyCoef() {return coef;}

        public double convertRUBto(double sum) {
            return sum*coef;
        }
        public double convertToRUB(double sum) {
            return sum/coef;
        }

    }

    public static void main(String[] args) {
        for (Currency crr : Currency.values()) {
            System.out.println("100 RUB = " + crr.convertRUBto(100) + " " + crr);
            System.out.println("100 " + crr + " = " + crr.convertToRUB(100) + " RUB");
        }

    }
}
