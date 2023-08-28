import java.util.Scanner;


class Dish {
    public String name;
    public double price;

}
    class Calculator {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        Formater formater = new Formater();
        private static final String finish = "Завершить";
        private double sumOfDishes;
        private String check = "проверка";
        private String listOfNAmes = "";
        private int numberOfPeople;
        private double sumPerPerson;

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
            } while (numberOfPeople < 1);

            return numberOfPeople;
        }

        public void checkPeople() {
            while (!scanner.hasNextInt()) {
                System.out.println("Что-то пошло не так! Введите число людей");
                System.out.println("На скольких делим счет?");
                scanner.next();
            }

        }

        public String askName(String name) {
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
                   System.out.println("Вы заказали: " + listOfNAmes + " " + price + " на сумму; " + sumOfDishes);
               }
           }while (price <=0);
            return sumOfDishes;
        }
public void checkPrice(){
    while (!scanner.hasNextDouble()) {
        System.out.println("Что-то пошло не так!");
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
            StringBuilder builder = new StringBuilder("Вы заказали " + "\n" + listOfNAmes + "\n" + "Общая стоимость стоимость заказа " + String.format("%.2f", Math.floor(sumOfDishes)) + " " + formater.formaterSum(sumOfDishes) + "." + " " + "Каждый заплатит " + String.format("%.2f", Math.floor(sumPerPerson)) + " " + formater.formaterSumPerPerson(sumPerPerson) +".");
            System.out.println(builder);
        }

    }
class Formater {
    public String format;
    public String formaterSum(double sumOfDishes) {
        int rub = (int) (sumOfDishes % 10);

        switch (rub) {
            case (1):
                format = "рубль";
                break;
            case (2):
                format = "рубля";
                break;
            case (3):
                format = "рубля";
                break;
            case (4):
                format ="рубля";
                break;
            case (5):
                format ="рублей";
                break;
            case (6):
                format ="рублей";
                break;
            case (7):
                format = "рублей";
                break;
            case (8):
                format ="рублей";
                break;
            case (9):
                format ="рублей";
                break;
        }
        return format;
    }

    public String formaterSumPerPerson(double sumPerPerson) {
        int rub = (int) (sumPerPerson % 10);

        switch (rub) {
            case (1):
                format = "рубль";
            break;
            case (2):
                format = "рубля";
            break;
            case (3):
                format = "рубля";
            break;
            case (4):
                format ="рубля";
            break;
            case (5):
                format ="рублей";
            break;
            case (6):
                format ="рублей";
            break;
            case (7):
                format = "рублей";
            break;
            case (8):
                format ="рублей";
            break;
            case (9):
                format ="рублей";
            break;
        }
        return format;
    }

}











