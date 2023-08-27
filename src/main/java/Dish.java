import java.util.Scanner;


class Dish {
    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);
    public String finish = "Завершить";
    public double sumOfDishes;
    public String name, check = "проверка";
    public double price;
    public String listOfNAmes = "";
    public int numberOfPeople;
    public double sumPerPerson;



    public int peoplesCalculator() {
        do {System.out.println("На скольких делим счет?");
            peoplescalculator2();
            numberOfPeople = scanner.nextInt();
            if (numberOfPeople <= 1) {
                System.out.println("Слишком мало людей! Попробуем снова.");
            } else {
                System.out.println("Делим на " + numberOfPeople + " людей.");
            }
        }while (numberOfPeople <= 2);

        return numberOfPeople;
    }
    public void peoplescalculator2(){
        while (!scanner.hasNextInt()){
            System.out.println("Что-то пошло не так! Введите число людей");
            System.out.println("На скольких делим счет?");
            scanner.next();
        }

    }

    public String askName() {
        System.out.println("Введите название блюда");
        while (!scanner.hasNext()) {
            System.out.println("Что-то пошло не так!");
            System.out.println("Введите название блюда");
            scanner.next();
        }
        name = scanner.next();
        listOfNAmes = listOfNAmes + "\n" + name;

        return listOfNAmes;
    }

    public double calculator() {
        System.out.println("Введите стоимость в формате рубли,копейки");
        while (!scanner.hasNextDouble()){
            System.out.println("Что-то пошло не так!");
            System.out.println("Введите стоимость в формате рубли,копейки");
            scanner.next();
        }
        price = scanner.nextDouble();
        sumOfDishes = sumOfDishes + price;

        System.out.println("Вы заказали: " + listOfNAmes + " " + price + " на сумму; " + sumOfDishes);
        return sumOfDishes;
    }


    public void calculator2() {
        do {
            askName();
            calculator();
            System.out.println("Добавить следующее или завершить?");
            check = scanner1.nextLine();
        }
        while (!check.equalsIgnoreCase(finish));
    }

    public void result() {
        sumPerPerson = sumOfDishes / numberOfPeople;
        System.out.println("Вы заказали " + "\n" + listOfNAmes + "\n" + ". Общая стоимость стоимость заказа " + sumOfDishes + " " + "Каждый заплатит " + String.format("%.2f", Math.floor(sumPerPerson)) +" "+ "рубля");
    }

}







