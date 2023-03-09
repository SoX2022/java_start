package Homework.Homework_09;

import java.util.Comparator;

public class RamComparatorUP implements Comparator<Notebook> {

    @Override
    public int compare(Notebook o1, Notebook o2) {
        return o1.getRam() - o2.getRam();
    }
    
}
