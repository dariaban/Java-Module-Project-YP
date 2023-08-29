public class Formater {
    public String format;

    public String formater(double test) {
        int rub = (int) (test % 100);
        if (test >= 11 && test <= 19) {
            return "рублей";
        } else {
             rub = (int) (test % 10);
            if (rub == 1) {
                format = "рубль";
            } else if (rub > 1 && rub <= 4) {
                format = "рубля";
            } else if (rub >= 5 && rub <= 9) {
                format = "рублей";
            } else if (rub == 0) {
                format = "рублей";
            }

        }
        return format;
    }
}


