package Homework.Homework_09;

import java.util.Comparator;

public class AllStatsComparator implements Comparator<Notebook> {
    


    @Override
    public int compare(Notebook o1, Notebook o2) {
        int r = (int) (o2.getScreenSize() - o1.getScreenSize());
        
        if (r == 0) {
            r = o2.getRam() - o1.getRam();

                if (r == 0) {
                    r = o2.getBattaryCapacity() - o1.getBattaryCapacity();

                        if (r == 0) {
                            return o1.getSalary() - o2.getSalary();
                        }
                }
        }

        return r;
    }
}
