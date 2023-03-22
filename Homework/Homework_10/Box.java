package Homework.Homework_10;

import java.util.ArrayList;
import java.util.Iterator;

public class Box<T extends Fruit> implements Iterable<T> {
    private int netto = 0;
    private ArrayList<T> box;

    public Box () {
        this.box = new ArrayList<>();
    }

    public void add(T fruit) {
        box.add(fruit);
        netto += fruit.getWeight();
    }

    public int getWeight() {
        return this.netto;
    }

    public void moveTo(Box<? super T> target) {
        int i = 0;
        while (i < this.box.size()) {
            target.add(this.box.get(i));
            this.netto -= this.box.get(i).getWeight();
            this.box.remove(i);

            if (i > 0) {
                i--;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        // return new BoxIterator<>(box);
        return box.iterator();
    }
}
