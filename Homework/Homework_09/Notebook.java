package Homework.Homework_09;

import java.util.concurrent.ThreadLocalRandom;

public class Notebook{
    private static long id;

    private String notebookId;
    private int salary;
    private int ram;
    private int[] memory = {256, 512, 1024, 2048, 4096, 8192, 16384, 32768};

    static {
        id = 1L;
    }

    public Notebook() {
        this.notebookId = "Notebook_" + id++;
        this.salary = ThreadLocalRandom.current().nextInt(1000);
        this.ram = memory[ThreadLocalRandom.current().nextInt(8)];
    }

    public int getSalary() {
        return this.salary;
    }

    public int getRam() {
        return this.ram;
    }

    public void getNotebookStats() {
        System.out.println(this.notebookId + ": RAM=" + this.ram + ", Price=" + this.salary + ".");
    }
}
