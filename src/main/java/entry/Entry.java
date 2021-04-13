package entry;

import data.Data;

import java.io.*;
import java.util.Scanner;

public class Entry {
    private static final String pathToFile = "src/main/resources/input";
    private static Scanner scanner = new Scanner(System.in);
    private static Data data = new Data();

    public Data read() {

        String inp = "";

        do {
            System.out.println("Выберите откуда вводить данные: \"file\" или \"console\" ?");
            inp = scanner.next();
        } while (!inp.equals("console") && !inp.equals("file"));

        if (inp.equals("console")) {
            readConsole();
        } else {
            readFile();
        }
        return data;
    }

    public void readConsole() {
        double a;
        for (; ; ) {
            System.out.println("Введите значение левой границы:");
            try {
                a = Double.parseDouble(scanner.next().trim().replaceAll(",", "\\."));
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Ну и зачем ты ввел некорректные данные, давай по новой...");
            }
        }
        double b;
        for (; ; ) {
            System.out.println("Введите значение правой границы:");
            try {
                b = Double.parseDouble(scanner.next().trim().replaceAll(",", "\\."));
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Ну и зачем ты ввел некорректные данные, давай по новой...");
            }
        }
        double e;
        for (; ; ) {
            System.out.println("Введите значение погрешности:");
            try {
                e = Double.parseDouble(scanner.next().trim().replaceAll(",", "\\."));
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Ну и зачем ты ввел некорректные данные, давай по новой...");
            }
        }
        int equation;
        for (; ; ) {
            System.out.println("Какой уравение ты хочешь проинтегрировать? Могу предложить:\n" +
                    "1) x^3 + 2*x^2 - 3*x - 12 (введи 1)\n" +
                    "2)        sin(x)/х        (введи 2)\n" +
                    "3)          1/х           (введи 3)\n");

            try {
                equation = Integer.parseInt(scanner.next().trim());
                if (equation == 1 || equation == 2 || equation == 3 || equation == 4) {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ну и зачем ты ввел некорректные данные, давай по новой...");
            }
        }
        int met;
        for (; ; ) {
            System.out.println("Какой метод ты хочешь использовать, могу предложить:\n" +
                    "1)Метод прямоугольников - метод левых      (введи 1)\n" +
                    "2)Метод прямоугольников - метод правых     (введи 2)\n" +
                    "3)Метод прямоугольников - метод средних    (введи 3)\n" +
                    "4)Метод трапеций                           (введи 4)\n" +
                    "5)Метод Симпсона                           (введи 5)\n");
            try {
                met = Integer.parseInt(scanner.next().trim());
                if (met == 1 || met == 2 || met == 3 || met == 4 || met == 5) {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ну и зачем ты ввел некорректные данные, давай по новой...");
            }
        }
        String consolOrFile;
        for (; ; ) {
            System.out.println("Куда сделаем вывод данных?\n Введи \'file\' для вывода в файл или введи \'console\' для вывода в консоль");
            try {
                consolOrFile = scanner.next().trim();
                if (!consolOrFile.equals("console") && !consolOrFile.equals("file")) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Ну и зачем ты ввел некорректные данные, давай по новой...");
            }
        }
        checkData(a, b, e, met, equation, consolOrFile);
    }

    public void readFile() {
        BufferedReader reader = null;
        double a = 0, b = 0, e = 0;
        int met = 0, equation = 0;
        String consolOrFile = "";
        try {
            reader = new BufferedReader(new FileReader(new File(pathToFile)));
        } catch (FileNotFoundException ex) {
            System.out.println("Кривоватый путь к file");
            System.exit(0);
        }
        try {
            a = Double.parseDouble(reader.readLine().trim().replaceAll(",", "\\."));
            b = Double.parseDouble(reader.readLine().trim().replaceAll(",", "\\."));
            e = Double.parseDouble(reader.readLine().trim().replaceAll(",", "\\."));
            equation = Integer.parseInt(reader.readLine().trim());
            if (equation != 1 && equation != 2 && equation != 3 && equation != 4) {
                throw new NumberFormatException();
            }
            met = Integer.parseInt(reader.readLine().trim());
            if (met != 1 && met != 2 && met != 3 && met != 4 && met != 5) {
                throw new NumberFormatException();
            }
            consolOrFile = reader.readLine().trim();
            if (!consolOrFile.equals("console") && !consolOrFile.equals("file")) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException | IOException ignored) {
            System.out.println("В файле кривые данные,поменяйте их и попробуйде снова");
            System.exit(0);
        }
        checkData(a, b, e, met, equation, consolOrFile);
    }

    public void checkData(double a, double b, double e, int met, int equation, String consolOrFile) {
        try {
            if (Math.abs(a - b) < e) {
                throw new NumberFormatException("Ну и зачем ты ввел такие данные, |a - b| < e!");
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        if (a > b) {
            data.setA(b);
            data.setB(a);
        } else {
            data.setA(a);
            data.setB(b);
        }
        data.setE(e);
        data.setMet(met);
        data.setEquation(equation);
        data.setOut(consolOrFile);
    }
}
