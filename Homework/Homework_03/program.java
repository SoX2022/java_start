package Homework.Homework_03;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

public class program {
    public static void main(String[] args) {
        int listLenth = 20;
        List<Integer> list = new ArrayList<Integer>(listLenth);
        fillList(list, listLenth);
        System.out.println("Random list:");
        System.out.println(list);
        System.out.println();
        
        // 1. Пусть дан произвольный список целых чисел, удалить из него четные числа (в
        // языке уже есть что-то готовое для этого)

        // removeEven(list);
        superRemoveEven(list);
        System.out.println("List without even numbers:");
        System.out.println(list);
        System.out.println();

        // 2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и
        // среднее арифметическое из этого списка.

        System.out.print("Min value is ");
        System.out.println(minValue(list));
        System.out.print("Max value is ");
        System.out.println(maxValue(list));
        System.out.print("Average value is ");
        System.out.println(averageValue(list));
        System.out.println();


    }

    public static void fillList(List<Integer> list, int length) {
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            list.add(rand.nextInt(100));
        }
    }

    public static void removeEven(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
    }

    public static void superRemoveEven(List<Integer> list) {
        list.removeIf(element -> (element % 2 == 0));
    }

    public static int minValue(List<Integer> list) {
        int min = list.get(0);

        for (int element : list) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    public static int maxValue(List<Integer> list) {
        int max = list.get(0);

        for (int element : list) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static Double averageValue(List<Integer> list) {
        int sum = 0;
        int count = 0;

        for (int element : list) {
            sum += element;
            count++;
        }

        double average = Math.round((double)sum / (double)count * 100);
        return average / 100;
    }
}
