package Homework.Homework_10;

public class Main {

    public static void main(String[] args) {
        // Есть классы: GoldenApple -> Apple -> Fruit
        //                             Orange -> Fruit
        // Есть класс Box. Нужно:
        // 1. Организовать его так, чтобы он мог хранить только фрукты какого-то типа
        // 2. Реализовать методы добавления фрукта, пересыпания в другую коробку, получение сумарного веса
        // Ограничения:
        // В коробку с апельсинами нельзя добавить яблоки
        // В коробку с золотыми яблоками нельзя добавить апельсины и яблоки
        // Пересыпать из коробки с золотыми яблоками в коробку с яблоками можно!
        // 3.* Реализовать итерируемость по коробке

    //    Box<String> stringBox = new Box<>(); // не должно работать
       Box<Apple> appleBox = new Box<>(); // работает
       Box<Orange> orangeBox = new Box<>(); // работает
       Box<GoldenApple> goldenAppleBox = new Box<>(); // работает

       appleBox.add(new Apple(1)); // работает
       appleBox.add(new GoldenApple(4)); // работает
       //    appleBox.add(new Orange(1)); // не работает
       orangeBox.add(new Orange(7)); // работает
       System.out.println(appleBox.getWeight() + " kg in appleBox"); // 5
       System.out.println(orangeBox.getWeight() + " kg in orangeBox"); // 7
       System.out.println(goldenAppleBox.getWeight() + " kg in goldenAppleBox"); // 7
       System.out.println();

    //    goldenAppleBox.add(new Apple(2)); // не работает
       goldenAppleBox.add(new GoldenApple(2)); // работает
       System.out.println(appleBox.getWeight() + " kg in appleBox"); // 5
       System.out.println(orangeBox.getWeight() + " kg in orangeBox"); // 7
       System.out.println(goldenAppleBox.getWeight() + " kg in goldenAppleBox"); // 7
       System.out.println();

       goldenAppleBox.moveTo(appleBox); // работает
    //    goldenAppleBox.moveTo(orangeBox); // не работает
        System.out.println(appleBox.getWeight() + " kg in appleBox"); // 5
        System.out.println(orangeBox.getWeight() + " kg in orangeBox"); // 7
        System.out.println(goldenAppleBox.getWeight() + " kg in goldenAppleBox"); // 7
        System.out.println();

        // appleBox.moveTo(goldenAppleBox);
//
//        // 3.*
//        for (GoldenApple apple: goldenAppleBox) { // должно работать
//
//        }
    }

}
