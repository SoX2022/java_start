package Homework.Homework_09;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создать класс Notebook с полями:
        // 1. Стоимость (int)
        // 2. Оперативная память (int)
        // Нагенерить объектов этого класса, создать список и отсортировать его в трех вариантах:
        // 1. По возрастанию цены
        // 2. По убыванию цены
        // 3. По оперативке по убыванию. Если оперативки равны - по убыванию цены.
        // 4.+ придумать свои параметры и отсортировать по ним

        int notebooksQuantity = 10;
        ArrayList<Notebook> notebooks1 = new ArrayList<>(notebooksQuantity);
        ArrayList<Notebook> notebooks2 = new ArrayList<>(notebooksQuantity);
        ArrayList<Notebook> notebooks3 = new ArrayList<>(notebooksQuantity);
        ArrayList<Notebook> notebooks4 = new ArrayList<>(notebooksQuantity);
        ArrayList<Notebook> notebooks5 = new ArrayList<>(notebooksQuantity);
        ArrayList<Notebook> notebooks6 = new ArrayList<>(notebooksQuantity);
        ArrayList<Notebook> notebooks7 = new ArrayList<>(notebooksQuantity);

        fillArray(notebooks1, notebooksQuantity);
        fillArray(notebooks2, notebooksQuantity);
        fillArray(notebooks3, notebooksQuantity);
        fillArray(notebooks4, notebooksQuantity);
        fillArray(notebooks5, notebooksQuantity);
        fillArray(notebooks6, notebooksQuantity);
        fillArray(notebooks7, notebooksQuantity * 2);

        System.out.println("\u001B[31m" + "Salary UP" + "\u001B[0m");
        printStats(notebooks1);
        notebooks1.sort(new SalaryComparatorUP());
        printStats(notebooks1);
        
        System.out.println("\u001B[31m" + "Salary DOWN" + "\u001B[0m");
        printStats(notebooks2);
        notebooks2.sort(new SalaryComparatorDOWN());
        printStats(notebooks2);
        
        System.out.println("\u001B[31m" + "Ram UP" + "\u001B[0m");
        printStats(notebooks3);
        notebooks3.sort(new RamComparatorUP());
        printStats(notebooks3);
        
        System.out.println("\u001B[31m" + "Ram DOWN + Salary UP" + "\u001B[0m");
        printStats(notebooks4);
        notebooks4.sort(new RamPlusSalaryComparator());
        printStats(notebooks4);
        
        System.out.println("\u001B[31m" + "Screen Size UP" + "\u001B[0m");
        printStats(notebooks4);
        notebooks4.sort(new ScreenSizeComparatior());
        printStats(notebooks4);
        
        System.out.println("\u001B[31m" + "Battary Capasity DOWN" + "\u001B[0m");
        printStats(notebooks4);
        notebooks4.sort(new BattaryCapacityComparator());
        printStats(notebooks4);
        
        System.out.println("\u001B[31m" + "Screen DOWN + Ram DOWN + Battary DOWN + Salary UP" + "\u001B[0m");
        printStats(notebooks4);
        notebooks4.sort(new AllStatsComparator());
        printStats(notebooks4);

    }

    public static void printStats(ArrayList<Notebook> notebooks) {
        for (Notebook notebook : notebooks) {
            notebook.getNotebookStats();
        };
        System.out.println();
    }

    public static void fillArray(ArrayList<Notebook> notebooks, int maxNotebooks) {
        for (int i = 0; i < maxNotebooks; i++) {
            notebooks.add(new Notebook());
        }
    }
}
