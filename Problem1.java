import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


/**
 * Created by daria on 15.04.17.
 *
 * Количество строк/размерность матрицы n вводится как аргумент командной строки
 *
 * Метод task1 получает n строк, введенных из консоли, считает их среднюю длину
 * и выводит на консоль те строки, длина которых меньше средней, и их длину.
 *
 * Метод task2 получает n слов, введенных из консоли, считает, сколько слов
 * содержат только символы латинского алфавита, а среди них - сколько слов имеют
 * равное количество гласных и согласных букв.
 *
 * Метод task3 получает число от 1 до 12, введенное из консоли, и выводит
 * название месяца, соответствующее этому числу. Если введенный символ не является
 * числом от 1-12, то выводится сообщение об ошибке.
 *
 * Метод task4 создает массив n x n, заполняет его случайными числами в диапазоне [-n,n],
 * затем сортирует строки массива в порядке возрастания значений элемента k-го столбца.
 * Номер столбца k вводится из консоли.
 * До и после сортировки массив выводится на консоль.
 *
 */
public class Problem1 {

    public static void task1(int n) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String [n];
        //int[] str_lengths = new int [n];
        int sum = 0;
        System.out.format("Введите %d строк\n", n);

        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
            //str_lengths[i] = strings[i].length();
            sum += strings[i].length();
        }
        double mean = sum/(double) n;
        for (String str : strings) {
            if (str.length() < mean)
                System.out.println(str + ", длина строки: " + str.length());
        }
    }

    public static void task2(int n) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String [n];
        String vowels = "aeiouAEIOU";
        int latinCount = 0;
        int sameVC = 0;
        System.out.format("Введите %d слов\n", n);
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
            if (strings[i].matches("[A-Za-z]+")) {
                latinCount++;
                int vowelCount = 0;
                int consCount = 0;
                for (int k = 0; k < strings[i].length(); k++) {
                    char letter = strings[i].charAt(k);
                    if (vowels.indexOf(letter) >= 0)
                        vowelCount++;
                    else
                        consCount++;
                }
                if (vowelCount == consCount)
                    sameVC++;
            }

        }
        System.out.println("Количество слов из латинских символов: " + latinCount +
                "\nИз них - с одинаковым количеством гласных и согласных: " + sameVC);
    }

    public static void task3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Введите число от 1 до 12");
        str = br.readLine();
        if (!str.isEmpty()) {
            try {
                int month = Integer.parseInt(str);

                    switch (month) {
                        case 1:
                            System.out.println("Январь");
                            break;
                        case 2:
                            System.out.println("Февраль");
                            break;
                        case 3:
                            System.out.println("Март");
                            break;
                        case 4:
                            System.out.println("Апрель");
                            break;
                        case 5:
                            System.out.println("Май");
                            break;
                        case 6:
                            System.out.println("Июнь");
                            break;
                        case 7:
                            System.out.println("Июль");
                            break;
                        case 8:
                            System.out.println("Август");
                            break;
                        case 9:
                            System.out.println("Сентябрь");
                            break;
                        case 10:
                            System.out.println("Октябрь");
                            break;
                        case 11:
                            System.out.println("Ноябрь");
                            break;
                        case 12:
                            System.out.println("Декабрь");
                            break;
                        default:
                            System.out.println("Ошибка! Введите число от 1 до 12");
                            break;
                    }
                
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите число от 1 до 12");
            }

        }

    }

    public static void task4(int n) throws IOException {
        int[][] rand_nums = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int m = 0; m < n; m++) {
                rand_nums[i][m] = rand.nextInt(2*n+1) - n;
            }
        }
        System.out.println(Arrays.deepToString(rand_nums));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.format("Введите число от 0 до %d включительно\n", n-1);
        final int k = Integer.parseInt(br.readLine());
        Arrays.sort(rand_nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[k], b[k]);
            }
        });
        System.out.println(Arrays.deepToString(rand_nums));

    }

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            //Problem1.task1(Integer.parseInt(args[0]));
            //Problem1.task2(Integer.parseInt(args[0]));
            Problem1.task4(Integer.parseInt(args[0]));
        }
        //Problem1.task3();

    }
}
