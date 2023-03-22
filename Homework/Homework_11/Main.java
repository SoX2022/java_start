package Homework.Homework_11;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1.
        // Карта с каким-то размером nxm.
        // На ней можно создать роботов, указывая начальное положение.
        // Если начальное положение некорректное ИЛИ эта позиция занята другим роботом,
        // то кидаем исключение.
        // Робот имеет направление (вверх, вправо, вниз, влево). У роботов можно менять
        // направление и передвигать их на 1 шаг вперед.
        // 2.
        // Написать контроллер к этому коду, который будет выступать посредником между
        // консолью (пользователем) и этой игрой.
        // (0,0) ------------------ (0, m)
        // ...
        // (n, 0) ----------------------- (n, m)

        // Robot, Map, Point

        // Домашнее задание:
        // Реализовать чтение команд с консоли и выполнить их в main методе
        // Список команд:
        // create-map 3 5 -- РЕАЛИЗОВАНО!
        // create-robot 2 7
        // move-robot id
        // change-direction id LEFT

        Scanner sc = new Scanner(System.in);
        RobotMap map = null;
        boolean notStop = true;

        while (notStop) {
            System.out.println("Выберите команду из списка :");

            if (map == null) {
                System.out.println("create-map {size: x, y}");
            } else {
                System.out.println("create-robot {point: x, y}");

                if (!map.mapIsEmpty()) {
                    System.out.println("move-robot {id}");
                    System.out.println("change-direction {id, direction: LEFT / RIGTH / TOP / DOWN}");

                }
            }
            System.out.println("exit\n");

            String userCommand = sc.nextLine();
            String[] split = userCommand.split(" ");
            String command = split[0];
            String[] arguments = Arrays.copyOfRange(split, 1, split.length); // [3 5]

            switch (command) {
                case "create-map":
                    try {
                        map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                        System.out.println("ИГРАЕМ...\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println(
                                "При создании карты возникло исключение: " + e.getMessage() + ". Попробуйте еще раз\n");
                    }
                    break;

                case "create-robot":
                    try {
                        System.out.println("Robot`s id is " + map.createRobot(new Point(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]))));
                    } catch (PositionException e) {
                        System.out.println("При создании робота возникло исключение: " + e.getMessage() + "\n");
                    }
                    break;

                case "move-robot":
                    try {
                        map.moveRobot(Long.parseLong(arguments[0]));
                        System.out.println("Robot " + arguments[0] + " moved forward.");
                    } catch (PositionException e) {
                        System.out.println("При перемещении робота возникло исключение: " + e.getMessage() + "\n");
                    }
                    break;

                case "change-direction":
                try {
                    map.changeRobotDirection(Long.parseLong(arguments[0]),
                            arguments[1].toUpperCase());
                    System.out.println("Robot " + arguments[0] + " looking " + arguments[1].toUpperCase() + " now.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Такого направления не существует.");
                }
                     break;

                case "exit":
                    notStop = false;
                    break;

                default:
                    System.out.println("Команда не найдена. Попробуйте еще раз\n");
            }
        }
        sc.close();
    }
}
