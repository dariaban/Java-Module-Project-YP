import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);
    Formater formater = new Formater();
    private static final String finish = "Завершить";
    private double sumOfDishes;
    private String check = "проверка";
    private String listOfNAmes = "";
    private int numberOfPeople;
    private double sumPerPerson;
    private final String mistake = "Что-то пошло не так!";

    public int peoplesCalculator() {
        do {
            System.out.println("На скольких делим счет?");
            checkPeople();
            numberOfPeople = scanner.nextInt();
            if (numberOfPeople <= 1) {
                System.out.println("Слишком мало людей! Попробуем снова.");
            } else {
                System.out.println("Делим на " + numberOfPeople + " человек.");
            }
        } while (numberOfPeople <= 1);

        return numberOfPeople;
    }

    public void checkPeople() {
        while (!scanner.hasNextInt()) {
            System.out.println(mistake + " Введите число людей");
            System.out.println("На скольких делим счет?");
            scanner.next();
        }

    }

    public String askName(String name) {
        System.out.println("Введите название блюда");
        while (!scanner.hasNext()) {
            System.out.println(mistake);
            System.out.println("Введите название блюда");
            scanner.next();
        }
        name = scanner.next();
        listOfNAmes = listOfNAmes + "\n" + name;

        return listOfNAmes;
    }

    public double calculator(double price) {
        do {
            System.out.println("Введите цену в формате рубли,копейки");
            checkPrice();
            price = scanner.nextDouble();
            if (price <= 0) {
                System.out.println("Цена не может нулевой или отрицательной");
                System.out.println("Введите цену в формате рубли,копейки");
                scanner.next();
            } else {
                sumOfDishes = sumOfDishes + price;
                System.out.println("Вы заказали: " + listOfNAmes + " " +  price + " на сумму: " + String.format("%.2f",sumOfDishes));
            }
        } while (price <= 0);
        return sumOfDishes;
    }

    public void checkPrice() {
        while (!scanner.hasNextDouble()) {
            System.out.println(mistake);
            System.out.println("Введите цену в формате рубли,копейки");
            scanner.next();
        }
    }

    public void calculator2() {
        do {
            askName(null);
            calculator(0.0);
            System.out.println("Добавить следующее или завершить?");
            check = scanner.next();
        }
        while (!check.equalsIgnoreCase(finish));
    }

    public void result() {
        double number = (int) numberOfPeople;

        sumPerPerson = sumOfDishes / number;
        StringBuilder builder = new StringBuilder("Вы заказали ");
        builder.append("\n");
        builder.append(listOfNAmes);
        builder.append("\n");
        builder.append("Общая стоимость закаказа: ");
        builder.append(String.format("%.2f", sumOfDishes));
        builder.append(" ");
        builder.append(formater.formater(sumOfDishes));
        builder.append(".");
        builder.append(" Каждый заплатит: ");
        builder.append(String.format("%.2f", sumPerPerson));
        builder.append(" ");
        builder.append(formater.formater(sumPerPerson));
        builder.append(".");
        System.out.println(builder);
          }

}
