package Homework.Homework_07;

public class Render {
    public void viewBar(Object object) {
        int current = 5;
        int max = 10;

        if (object instanceof HaveHealthPoints haveHealthPoints) {
            max = haveHealthPoints.getMaxHealthPoints();
            current = haveHealthPoints.getCurrentHealthPoints();
            printThreeColoredBar(getBarProgress(current, max), max);
        }


        if (object instanceof HaveManaPoints haveManaPoints) {
            max = haveManaPoints.getMaxManaPoints();
            current = haveManaPoints.getCurrentManaPoints();
            printOneColoredBar(getBarProgress(current, max), max, "\u001B[34m");
        }
    }

    private void printThreeColoredBar(int bar, int maxPoints) {
        String collor = "\u001B[32m";

        if (bar < 4) {
            collor = "\u001B[31m";
        } else if (bar < 8) {
            collor = "\u001B[33m";
        }

        printOneColoredBar(bar, maxPoints, collor);
    }

    private void printOneColoredBar(int bar, int maxPoints, String collor) {
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
        printThreeColoredBar(getBarProgress(currentHealth, maxHealth), maxHealth);
    }

    public void viewSelfManaBar(int currentMana, int maxMana) {
        printOneColoredBar(getBarProgress(currentMana, maxMana), maxMana, "\u001B[34m");
    }
}
