package Homework.Homework_07;

import java.util.Random;

public class DamageDealer extends Player {
    private static final int DAMAGE_MULTIPLIER = 2;
    private static final double DAMAGE_CHANCE = 0.15;

    public DamageDealer(String name) {
        super(name, 150, 25, 7);
    }

    public void criticalAtack(Player player) {
        this.damage *= DAMAGE_MULTIPLIER;
        super.atack(player);
        this.damage /= DAMAGE_MULTIPLIER;
    }

    @Override
    public void atack(Player player) {
        Random random = new Random();
        if (random.nextInt(1, 101) >= 100 - DAMAGE_CHANCE * 100) {
            criticalAtack(player);
        } else {
            super.atack(player);
        }
    }

    public void getPlayerClass() {
        System.out.println("Damage Dealer");
    }
}
