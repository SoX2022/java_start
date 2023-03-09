package Homework.Homework_08;

import java.util.Comparator;

public class RamPlusSalaryComparator implements Comparator<Notebook> {

    @Override
    public int compare(Notebook o1, Notebook o2) {
        int r = o2.getRam() - o1.getRam();

        if (r == 0) {
            return o1.getSalary() - o2.getSalary();
        }

        return r;
    }
    
}
