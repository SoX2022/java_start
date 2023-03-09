package Homework.Homework_08;

import java.util.Comparator;

public class SalaryComparatorUP implements Comparator<Notebook>{

    @Override
    public int compare(Notebook o1, Notebook o2) {
        return o1.getSalary() - o2.getSalary();
    }
}
