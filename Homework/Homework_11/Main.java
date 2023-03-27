package Homework.Homework_11;

import java.util.Arrays;
import java.util.List;
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
        String userCommand = "";

        while (notStop) {
            System.out.println("Введите команду для создания карты.");
            System.out.println("create-map {size: x, y}");
            userCommand = sc.nextLine();

            if (userCommand.startsWith("create-map")) {
                String[] split = userCommand.split(" ");
                String[] arguments = Arrays.copyOfRange(split, 1, split.length);

                try {
                    map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                    System.out.println("Карта создана. ИГРАЕМ...\n");
                    notStop = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(
                            "При создании карты возникло исключение: " + e.getMessage() + ". Попробуйте еще раз\n");
                }
            }
        }

        notStop = true;

        while (notStop) {
            System.out.println("Выберите команду из списка :");
            System.out.println("create-robot {point: x, y}");

            if (!map.mapIsEmpty()) {
                System.out.println("move-robot {id}");
                System.out.println("change-direction {id, direction: LEFT / RIGTH / TOP / BOTTOM}");

            }

            System.out.println("exit\n");

            CommandManager commandManager = new CommandManager(map, List.of(
                new CreateRobotHandler(),
                new MoveRobotHandler(),
                new ChangeDirectionHandler()
            ));
            userCommand = sc.nextLine();

            switch (userCommand) {
                case "exit":
                    notStop = false;
                    break;

                default:
                commandManager.handleCommand(userCommand);
            }
        }
        sc.close();
    }
}
