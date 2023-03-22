package Homework.Homework_10;

import java.util.ArrayList;
import java.util.Iterator;

public class BoxIterator<T extends Fruit> implements Iterator<T> {
    private int cursor = 0;
    private ArrayList<T> list;

    public BoxIterator(ArrayList<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return cursor < this.list.size();
    }

    @Override
    public T next() {
        return list.get(cursor++);
    }
    
}
