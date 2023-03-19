package Homework.Homework_07;

public class Render {
    public void viewBar(Object object) {
        int current;
        int max;

        if (object instanceof HaveHealthPoints haveHealthPoints) {
            max = haveHealthPoints.getMaxHealthPoints();
            current = haveHealthPoints.getCurrentHealthPoints();
            printThreeColoredBar(getBarProgress(current, max));
        }


        if (object instanceof HaveManaPoints haveManaPoints) {
            max = haveManaPoints.getMaxManaPoints();
            current = haveManaPoints.getCurrentManaPoints();
            printOneColoredBar(getBarProgress(current, max), "\u001B[34m");
        }
    }

    private void printThreeColoredBar(int bar) {
        String collor = "\u001B[32m";

        if (bar < 4) {
            collor = "\u001B[31m";
        } else if (bar < 8) {
            collor = "\u001B[33m";
        }

        printOneColoredBar(bar, collor);
    }

    private void printOneColoredBar(int bar, String collor) {
        System.out.print(collor);

        for (int i = 0; i < bar; i++) {
            System.out.print("█");
        }

        for (int i = 0; i < 10 - bar; i++) {
            System.out.print("_");
        }

        System.out.println(" " + "\u001B[0m");
    }

    private int getBarProgress(int current, int max) {
        int bar = current * 10 / max;

        if (current > 0 && bar == 0) {
            return 1;
        }
        return bar;
    }

    public void viewSelfHealthBar(int currentHealth, int maxHealth) {
        printThreeColoredBar(getBarProgress(currentHealth, maxHealth));
    }

    public void viewSelfManaBar(int currentMana, int maxMana) {
        printOneColoredBar(getBarProgress(currentMana, maxMana), "\u001B[34m");
    }
}
