package Homework.Homework_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        // text~num (например, word~4)
        // print~num (распечатать текст)

        // word~1
        // foo~5
        // qwerty~10
        // bar~5
        // print~10 -> qwerty
        // print~1 -> word
        // print~2 -> пустая строка или исключение NoSuchElementException
        // print~5 -> bar

        ArrayList<String> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Boolean notStop = true;

        while (notStop) {
            System.out.println();
            String[] userInput = getUserInput(scan).split("~");

            if (userInput[0].equals("print")) {
                System.out.println(getData(list, userInput[1]));
            } else if (userInput[0].equals("q")) {
                notStop = false;
            } else {
                saveData(list, userInput);
            }
        }
    }

    public static String getUserInput(Scanner scan) {
        System.out.println("Enter 'q' to exit.");
        System.out.print("Enter your text~value: ");
        return scan.nextLine();
    }

    public static void saveData(ArrayList<String> list, String[] array) {
        int temp = valueCheck(list, array[1]);

        if (temp == -1) {
            list.add(array[1]);
            list.add(array[0]);
        } else {
            list.remove(temp);
            list.add(temp, array[0]);
        }
    }

    public static String getData(ArrayList<String> list, String key) {
        int index = valueCheck(list, key);
        if (index == -1) {
            return "No such element found.";
        }
        return list.get(index);
    }

    public static int valueCheck(ArrayList<String> list, String key) {
        for (int i = 0; i < list.size(); i += 2) {
            if (list.get(i).equals(key)) {
                return i + 1;
            }
        }
        return -1;
    }
}
