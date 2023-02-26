package Homework_05;

import java.util.HashMap;
import java.util.Map;

public class program {
    public static void main(String[] args) {
        System.out.println("()[]{}<> -> " + isCorrectParentheses("()[]{}<>")); // true
        System.out.println("() -> " + isCorrectParentheses("()")); // true
        System.out.println("[]{}((<>)) -> " + isCorrectParentheses("[]{}((<>))")); // true
        System.out.println(") -> " + isCorrectParentheses(")")); // false
        System.out.println("[) -> " + isCorrectParentheses("[)")); // false
        System.out.println("[]{}(<)> -> " + isCorrectParentheses("[]{}(<)>")); // false
        System.out.println("([ -> " + isCorrectParentheses("([")); // false
    }

    /*
    * Написать метод, определяющую правильность расстановки скобок в выражении.
    * Могут содержаться следующие скобки: ()[]{}<>
    * () -> true
    * []{}((<>)) -> true
    * ) -> false
    * [) -> false
    * []{}(<)> -> false
    */
    private static boolean isCorrectParentheses(String parentheses) {
        Map<Integer, Character> map = new HashMap<>();
        String openParentheses = "([{<";
        String closeParentheses = ")]}>";
        int key = -1;

        for (int i = 0; i < parentheses.length(); i++) {
            if (openParentheses.indexOf(parentheses.charAt(i)) != -1) {
                map.put(++key, parentheses.charAt(i));
            } else if (closeParentheses.indexOf(parentheses.charAt(i)) != -1) {
                if (map.size() == 0) {
                    return false;
                }else if (map.get(key).equals(openParentheses.charAt(closeParentheses.indexOf(parentheses.charAt(i))))) {
                    map.remove(key--);
                } else {
                    return false;
                }
            }
        }
        if (map.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
