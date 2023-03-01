package Homework.Homework_06;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Кот (имя, аппетит, сытность)
        // Тарелка (содержит какое-то количество еды)
        // Кот ест из тарлеки. Если в тарелке недостаточно еды - кот ее не трогает

        // ДЗ:
        // while (true) -> while (!plate.isEmpty())
        // 1. Создать массив котов. Пусть все коты из массива по очереди едят из одной
        // тарелки.
        // В конце каждого цикла мы досыпаем в тарелку еду.
        // Для досыпания еды сделать метод increaseFood в классе Plate.
        // 2. Поменять поле satiety у кота с boolean на int.
        // Допустим у кота апптит 10, сытность 3. Значит кот захочет поесть 7 единиц.
        // 3. * Доработать поток thread в классе Cat, чтобы он каждую секунду уменьшал
        // сытость кота на 1.

        int catsNumber = 10;
        int maxCatAppetite = 10;
        int minCatAppetite = maxCatAppetite;
        int plateCapacity = 100;
        int maxFoodToPutInPlate = 30;

        Plate plate = new Plate(plateCapacity);
        Cat[] cats = new Cat[catsNumber];
        Random random = new Random();

        System.out.println("Program start");
        System.out.println("________________________");

        for (int i = 0; i < catsNumber; i++) {
            int catAppetite = random.nextInt(maxCatAppetite) + 1;
            cats[i] = new Cat("Cat" + (i + 1), catAppetite);
            if (minCatAppetite > catAppetite) {
                minCatAppetite = catAppetite;
            }
        }

        while (plate.getFoodStat() >= minCatAppetite) {
            for (Cat cat : cats) {
                cat.eat(plate);
                System.out.println(plate);
            }
            System.out.println();

            if (random.nextInt(6) > 3) {
                System.out.println(
                        plate.increaseFood(random.nextInt(maxFoodToPutInPlate) + 1) + " food put on the plate.");
                System.out.println(plate);
            } else {
                System.out.println("Nothing was put on the plate.");
            }

            System.out.println();
            Thread.sleep(1000);
        }
    }
}