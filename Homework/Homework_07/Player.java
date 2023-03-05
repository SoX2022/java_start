package Homework.Homework_07;

import java.util.Random;

public abstract class Player {
    // #region init
    private static final double DAMAGE_REDUCE_CHANCE = 0.5;
    protected static long playerId;

    private long id;
    public String name;

    protected int maxHealth;

    protected int health;
    protected int damage;
    protected int defence;

    Random random = new Random();
    // #endregion

    static {
        playerId = 1L;
    }

    protected Player(String name, int health, int damage, int defence) {
        this.id = playerId++;
        this.name = name;

        this.maxHealth = health;

        this.health = health;
        this.damage = damage;
        this.defence = defence;
    }

    public void atack(Player player) {
        if (player.isDead()) {
            System.out.println();
            System.out.println("This fight is illegal. " + player.name + "is already dead.");
        } else {

            int damage = player.getDamage(this.damage);
            System.out.print(this.name + " made " + damage + " damage to " + player.name + ". ");

            if (player.isDead()) {
                System.out.println();
                System.out.println(player.name + " is dead.");
            } else if (this.damage - damage > 0) {
                System.out.println(this.damage - damage + " damage was blocked.");
            }

            System.out.println();
        }
    }

    protected int getDamage(int damage) {
        if (random.nextInt(1, 101) >= 100 - DAMAGE_REDUCE_CHANCE * 100) {
            if (damage - this.defence > 0) {
                damage -= this.defence;
            } else {
                return 0;
            }
        }

        if (this.health < damage) {
            damage = this.health;
        }
        this.health -= damage;
        return damage;
    }

    public boolean isDead() {
        if (this.health == 0) {
            return true;
        }
        return false;
    }

    public void getStats() {
        System.out.println();
        System.out.println(this.name + "`s stats.");
        System.out.println("Health: " + this.health + " / " + this.maxHealth);
        System.out.println("Damage: " + this.damage);
        System.out.println("Defence: " + this.defence);
    }

    public long getId() {
        return this.id;
    }

    public long getHealth() {
        return this.health;
    }

    protected abstract void getPlayerClass();

    public void resetHealth () {
        this.health = this.maxHealth;
    }
}
