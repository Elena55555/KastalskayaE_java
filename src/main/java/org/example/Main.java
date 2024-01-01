package org.example;

import java.util.*;

import static org.example.BalancedBracketService.isBalancedBrackets;

public class Main {
    private final static int REQUIRED_VALUE = 7;
    private final static String REQUIRED_NAME = "Вячеслав";
    public final static String s1 = "[((())()(())]]";
    public final static String s2 = "[((())()(()))]";
    public final static String s3 = "[[(())()(())]]";

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    public static void task1() {
        System.out.println("Тестовое задание");
        System.out.println(" ");
        System.out.println("Задание № 1");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите любое число больше  %d: %n", REQUIRED_VALUE);
        String inputLine = "";
        if (scanner.hasNext()) {
            inputLine = scanner.next();
        }
        if (!inputLine.matches("\\d+")) {
            System.out.println("Некорректный ввод: необходимо ввести положительное число\n");
            return;
        }
        int number;
        try {
            number = Integer.parseInt(inputLine);
        } catch (NumberFormatException e) {
            System.out.println("Введенное значение слишком большое\n");
            return;
        }
        if (number > REQUIRED_VALUE) {
            System.out.println("Привет!\n");
            return;
        }
        System.out.printf(String.format("Вы ввели число меньше %d: ", REQUIRED_VALUE) + number);
        System.out.println(" ");
    }

    public static void task2() {
        System.out.println("Задание № 2");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любое имя:  ");
        String name = scanner.next();
        System.out.println("Вы ввели имя:  " + name);
        if (name.equals(REQUIRED_NAME)) {
            System.out.printf("Привет  %s ", REQUIRED_NAME);
        } else {
            System.out.println("Нет такого имени");
        }
        System.out.println(" ");
    }

    public static void task3() {
        System.out.println("Задание № 3");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Введите по одному " +
                " элементы массива (числа) " + size + "  раз(а):");
        for (int i = 0; i < array.length; i++) {
            try {
                array[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Необходимо вводить числа, а не буквы");
            } catch (NumberFormatException e) {
                System.out.println("Введенное значение слишком большое");
            }
        }
        System.out.println("Вы ввели массив  : " + Arrays.toString(array));
        System.out.println("Элементы массива кратные 3: ");
        for (int j = 0; j < array.length; j++) {
            if ((array[j] % 3 == 0) & (array[j] != 0)) {
                System.out.println(array[j]);
            }
        }
        /**
         *  Закрываем сканнер во избежание утечки памяти;
         */
        scanner.close();
        System.out.println(" ");
    }

    /**
     * Задание № 4
     * Дана скобочная последовательность: [((())()(())]]
     * - Можно ли считать эту последовательность правильной?
     * - Если ответ на предыдущий вопрос “нет”, то что необходимо в ней изменить,
     * чтоб она стала правильной?
     * <p>
     * Ответ:
     * - Нет
     * - Необходимо в ней заменить квадратную скобку справа на круглую
     * (или слева круглую - на квадратную), так как под  правильной последовательностью
     * (по смыслу данной задачи) понимается такая  последовательность, при которой каждой
     * открывающейся скобке соответствует  своя закрывающаяся скобка и не допустимо такое
     * расположение,  когда один тип скобок  закрывает другой.
     */

    public static void task4() {

        System.out.println("Задание № 4");
        /**
         *  Задание № 4
         *  Проверим работу метода isBalancedBrackets, зная о том, что пустая строка - правильная последовательность,
         *  далее для наглядности в консоли подставим строки в одинаковых вариантах друг за другом
         */

        System.out.println(isBalancedBrackets(s1));
        System.out.println(s1);
        System.out.println();
        System.out.println(isBalancedBrackets(s2));
        System.out.println(s2);
        System.out.println();
        System.out.println(isBalancedBrackets(s3));
        System.out.println(s3);
        System.out.println();
    }
}



