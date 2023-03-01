package Homework.Homework_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Homework_02 {
    public static void main(String[] args) {
        // 1. Создать метод, который проверяет, является ли строка палиндромом.
        // Палиндром - шалаш
        System.out.println(isPalindrome("strts"));
        System.out.println(isPalindrome("strtsa"));
        System.out.println("");

        // 2. С помощью Java создать файл temp.txt, и записать в него слово TEST 100
        // раз.
        // Если уже файл создан, то перезаписываем его.
        Path path = Path.of("Homework", "Homework_02", "temp.txt");
        Path directoryPath = Path.of("Homework", "Homework_02");
        String text = "TEST";
        int repeat = 100;
        
        String fileString = getString(text, repeat);

        if (!Files.exists(path)) {
            try {
                Files.createDirectories(directoryPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            createFile(path);
        }
        fillFile(path, fileString);
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void createFile(Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fillFile(Path path, String text) {
        try {
            Files.writeString(path, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String text, int repeat) {
        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < repeat / 10; i++) {
            for (int j = 0; j < 9; j++) {
                newString.append(text + " ");
            }
            newString.append(text + "\n");
        }
        return newString.toString();
    }
}
