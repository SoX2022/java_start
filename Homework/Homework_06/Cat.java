package Homework.Homework_06;

public class Cat {

    private String name;
    private int appetite;
    private volatile boolean satiety = false;
    // private int number;


    // public Cat() {
    //     this("Cat" + ++number);
    // }

    public Cat(String name) {
        this(name, 10);
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

        Thread backgroundSatietyManagement = new Thread(() -> {
            while (true) {
                this.satiety = false;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundSatietyManagement.setDaemon(true);
        backgroundSatietyManagement.start();
    }

    public void eat(Plate plate) {
        if (!this.satiety) {
            this.satiety = plate.decreaseFood(this.appetite);
            if (!this.satiety) {
                System.out.println(toString() + " didn`t ate anything, there is not ennought food left.");
            } else {
                System.out.println(toString() + " ate " + this.appetite + " food from the plate.");
            }
        } else {
            System.out.println(toString() + " isn`t hungry yet.");
        }

    }

    public void makeHungry() {
        this.satiety = false;
    }

    @Override
    public String toString() {
        return this.name + "{appetite=" + this.appetite + ", satiety=" + this.satiety + "}";
    }

    public int getCatAppetite() {
        return this.appetite;
    }

    public boolean getCatSatiety() {
        return this.satiety;
    }
}
