package Homework.Homework_09;

import java.util.Comparator;

public class BattaryCapacityComparator implements Comparator<Notebook> {

    @Override
    public int compare(Notebook o1, Notebook o2) {
        return o2.getBattaryCapacity() - o1.getBattaryCapacity();
    }
}
