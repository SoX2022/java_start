package Homework.Homework_09;

import java.util.concurrent.ThreadLocalRandom;

public class Notebook{
    private static long id;

    private String notebookId;
    private int salary;
    private int ram;
    private int[] memory = {256, 512, 1024, 2048, 4096, 8192, 16384, 32768};
    private double screenSize;
    private int battaryCapacity;

    static {
        id = 1L;
    }

    public Notebook() {
        this.notebookId = "Notebook_" + id++;
        this.salary = ThreadLocalRandom.current().nextInt(1000);
        this.ram = memory[ThreadLocalRandom.current().nextInt(8)];
        this.screenSize = Math.ceil(ThreadLocalRandom.current().nextDouble() * 100 + 200)/10;
        this.battaryCapacity = ThreadLocalRandom.current().nextInt(100) * 100;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getRam() {
        return this.ram;
    }

    public double getScreenSize() {
        return this.screenSize;
    }

    public int getBattaryCapacity() {
        return this.battaryCapacity;
    }

    public void getNotebookStats() {
        System.out.println(this.notebookId + ": RAM=" + this.ram + "Mb, Price=" + this.salary + "$, Screen=" + this.screenSize + "', Battary=" + this.battaryCapacity + "mAh.");
    }
}
