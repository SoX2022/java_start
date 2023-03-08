package Homework.Homework_07;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Random random = new Random();
        int figters = 6;
        int firstPlayer;
        int secondPlayer;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < figters; i++) {
            int temp = random.nextInt(3);

            if (temp == 0) {
                players.add(new Tank("Tank-" + (i + 1)));
            } else if (temp == 1) {
                players.add(new Healer("Healer-" + (i + 1)));
            } else if (temp == 2) {
                players.add(new DamageDealer("DamageDealer-" + (i + 1)));
            }
        }

        while (players.size() > 1) {
            firstPlayer = random.nextInt(players.size());
            secondPlayer = random.nextInt(players.size());
            

            while (firstPlayer == secondPlayer) {
                secondPlayer = random.nextInt(players.size());
            }

            System.out.print(players.get(firstPlayer).name);
            System.out.print(" and ");
            System.out.print(players.get(secondPlayer).name);
            System.out.println(" start fighting.");
            System.out.println("-> Press enter to start fight.");
            scanner.nextLine();

            if (fight(players.get(firstPlayer), players.get(secondPlayer))) {
                System.out.print(players.get(firstPlayer).name);
                players.get(firstPlayer).resetHealth();
                players.remove(secondPlayer);
            } else {
                System.out.print(players.get(secondPlayer).name);
                players.get(secondPlayer).resetHealth();
                players.remove(firstPlayer);
            }
            System.out.println(" is a WINNER!");
            System.out.println();
        }
        scanner.close();
    }

    public static boolean fight(Player firstFighter, Player secondFighter) {
        while (true) {
            firstFighter.atack(secondFighter);

            if (secondFighter.isDead()) {
                return true;
            } else {
                secondFighter.atack(firstFighter);

                if (firstFighter.isDead()) {
                    return false;
                }
            }
        }
    }
}
