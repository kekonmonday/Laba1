package laba_10;

public class TrainCheck {

    public void execute(String text) {
        System.out.println("Текст = " + text);
        this.text = text;
        if (text.length() == 6) {
            int n6 = (n(1) + 2 * n(2) + 3 * n(3) + 4 * n(4) + 5 * n(5)) % 11;
            if (n6 == 10) {
                n6 = (3 * n(1) + 4 * n(2) + 5 * n(3) + 6 * n(4) + 7 * n(5)) % 11;
                if (n6 == 10) {
                    n6 = 0;
                }
            }
            System.out.println("n6 = " + n6);
        } else if (text.length() == 5) {
            int n6 = (n(1) + 2 * (2) + 3 * n(3) + 4 * n(4)) % 11;
            if (n6 == 10) {
                n6 = (3 * n(1) + 4 * (2) + 5 * n(3) + 6 * n(4)) % 11;
                if (n6 == 10) {
                    n6 = 0;
                }
            }
            System.out.println("n6 = " + n6);
        }
        System.out.println();
    }

    String text;

    public int n(int i) {
        return Integer.valueOf(text.split("")[i - 1]);
    }

}

