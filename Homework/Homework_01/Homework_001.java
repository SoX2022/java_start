package Homework.Homework_01;

import java.util.Arrays;
import java.util.Random;

public class Homework_001 {
    public static void main(String[] args) {
        System.out.println("Проверить, что сумма числа a и b лежит между 10 и 20.");
        System.out.println("7 + 15 in [10; 20] -> " + isSumBetween10And20(7, 15));
        System.out.println("5 + 15 in [10; 20] -> " + isSumBetween10And20(5, 15));
        System.out.println("");

        System.out.println("Проверить, что число x положительное.");
        System.out.println("-5 >= 0 -> " + isPositive(-5));
        System.out.println("0 >= 0 -> " + isPositive(0));
        System.out.println("5 >= 0 -> " + isPositive(5));
        System.out.println("");

        System.out.println("Напечатать строку source repeat раз.");
        printString("abcd", 5);
        System.out.println("");

        System.out.println("Проверить, является ли год високосным. Если да - return true.");
        System.out.println("2000 year is leap -> " + isLeapYear(2000));
        System.out.println("2001 year is leap -> " + isLeapYear(2001));
        System.out.println("2002 year is leap -> " + isLeapYear(2002));
        System.out.println("2003 year is leap -> " + isLeapYear(2003));
        System.out.println("2004 year is leap -> " + isLeapYear(2004));
        System.out.println("");

        System.out.println("Вернуть массив длины len, каждое значение которого равно initialValue.");
        int[] firstArray = createArray(5, 2);
        System.out.println(Arrays.toString(firstArray));
        System.out.println("");

        System.out.println("Найти общий префикс среди слов из одного массива.");
        System.out.println("Ответ: ['aaa', 'aab', 'aa'] -> 'aa', ['abc', 'bca', 'cda'] -> ''");
        String[] stringArray = { "aaa", "aab", "aa" };
        System.out.println("Common prefix for " + Arrays.toString(stringArray) + " -> " + findCommonPrefix(stringArray)); // aa
        String[] stringArray2 = { "abc", "bca", "cda" };
        System.out.println("Common prefix for " + Arrays.toString(stringArray2) + " -> " + findCommonPrefix(stringArray2)); // ""
        System.out.println("");

        System.out.println("Задать целочисленный массив, состоящий из элементов 0 и 1.");
        System.out.println("С помощью цикла и условия заменить 0 на 1, 1 на 0");
        int[] secondArray = createRandomArray(10, 0, 1);
        System.out.print(Arrays.toString(secondArray) + " -> ");
        invertArray(secondArray);
        System.out.println(Arrays.toString(secondArray));
        System.out.println("");

        System.out.println("Задать массив. Пройти по нему циклом, и числа меньшие 6 умножить на 2.");
        int[] thirdArray = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print(Arrays.toString(thirdArray) + " -> ");
        editArray(thirdArray);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println("");

        System.out.println("Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), с помощью цикла(-ов) заполнить его диагональные элементы единицами.");
        int[][] forthArray = new int[4][4];
        print2xArray(forthArray);
        System.out.println(" -> ");
        arrayDiagonal(forthArray);
        print2xArray(forthArray);
        System.out.println("");

        System.out.println("Задать одномерный массив и найти в нем минимальный и максимальный элементы.");
        int[] fifthArray = createRandomArray(10, -10, 10);
        int min = Arrays.stream(fifthArray).min().getAsInt();
        int max = Arrays.stream(fifthArray).max().getAsInt();
        System.out.println(Arrays.toString(fifthArray) + " ->  min = " + min + ", max = " + max);
        System.out.println("");
    }


    public static boolean isSumBetween10And20(int a, int b) {
        // проверить, что сумма a и b лежит между 10 и 20
        if (a + b <= 20 && a + b >= 10)
            return true;
        return false;
    }

    public static boolean isPositive(int x) {
        // проверить, что х положительное
        if (x < 0)
            return false;
        return true;
    }

    public static void printString(String source, int repeat) {
        // напечатать строку source repeat раз
        String result = "";
        while (repeat > 0) {
            result += source;
            repeat--;
        }
        System.out.println(result);
    }

    public static boolean isLeapYear(int year) {
        // проверить, является ли год високосным. если да - return true
        if (year % 4 == 0)
            return true;
        return false;
    }

    public static int[] createArray(int len, int initalValue) {
        // должен вернуть массив длины len, каждое значение которого равно initialValue
        int[] array = new int[len];
        while (len > 0) {
            array[len - 1] = initalValue;
            len--;
        }
        return array;
    }

    public static int[] createRandomArray(int len,int minElement, int maxElement) {
        int[] array = new int[len];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(minElement, maxElement + 1);
        }

        return array;
    }

    public static String findCommonPrefix(String[] source) {
        /*
         * Найти общий префикс среди слов из одного массива.
         * ["aaa", "aab", "aa"] -> "aa", ["abc", "bca", "cda"] -> ""
         */
        String result = "";
        int minLen = 999;
        char symbol;

        for (String element : source) {
            if (element.length() < minLen)
                minLen = element.length();
        }

        for (int i = 0; i < minLen; i++) {
            symbol = source[0].charAt(i);

            for (int j = 0; j < source.length; j++) {
                if (source[j].charAt(i) != symbol)
                    return result;
            }

            result += symbol;
        }
        return result;
    }

    public static void invertArray(int[] array) {
        /**
         * Задать целочисленный массив, состоящий из элементов 0 и 1.
         * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия
         * заменить 0 на 1, 1 на 0;
         */
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                array[i] = 1;
            else
                array[i] = 0;
        }
    }

    public static void editArray(int[] array) {
        /**
         * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }
    }

    public static void arrayDiagonal(int[][] array) {
        /*
         * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
         */
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[array.length - i - 1][i] = 1;
        }
    }

    public static void print2xArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

}
