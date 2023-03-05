package Homework.Homework_07;

public class Healer extends Player {
    private static final int MAX_HEAL = 45;
    private static final int HEAL_COST = 40;
    private static final int MANA_REGENERATION = 7;

    protected int maxMana;
    protected int mana;

    public Healer(String name) {
        this(name, 100, 20, 5, 200);
    }

    public Healer(String name, int health, int damage, int defence, int mana) {
        super(name, health, damage, defence);
        this.mana = mana;
        this.maxMana = mana;
    }

    public void getStats() {
        super.getStats();
        System.out.println("Mana: " + this.mana + " / " + this.maxMana);
    }

    public void healing() {
        int heal = MAX_HEAL;
        if (this.health + heal > maxHealth) {
            heal = this.maxHealth - this.health;
        }
        this.health += heal;
        this.mana -= HEAL_COST;
        System.out.println(this.name + " heal " + heal + " health.");
        System.out.println();
    }

    @Override
    public void atack(Player player) {
        if (this.maxHealth - this.health >= MAX_HEAL - 10 && this.mana >= HEAL_COST) {
            healing();
        } else {
            this.mana += MANA_REGENERATION;
            super.atack(player);
        }
    }

    public void getPlayerClass() {
        System.out.println("Healer");
    }

    public void resetHealth () {
        super.resetHealth();
        this.mana = this.maxMana;
    }
}
