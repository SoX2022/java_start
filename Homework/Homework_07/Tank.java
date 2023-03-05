package Homework.Homework_07;

import java.util.Random;

public class Tank extends Player {
    private static final double BLOCK_CHANSE = 0.2;

    public Tank(String name) {
        super(name, 330, 12, 30);
    }

    @Override
    public int getDamage(int damage) {
        Random random = new Random();

        if (random.nextInt(1, 101) >= 100 - BLOCK_CHANSE * 100) {
            return 0;
        }
        return super.getDamage(damage);
    }

    public void getPlayerClass() {
        System.out.println("Tank");
    }
}
