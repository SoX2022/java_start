package Homework.Homework_09;

import java.util.Comparator;

public class ScreenSizeComparatior implements Comparator<Notebook> {

    @Override
    public int compare(Notebook o1, Notebook o2) {
        return (int) (o1.getScreenSize() - o2.getScreenSize());
    }
}
