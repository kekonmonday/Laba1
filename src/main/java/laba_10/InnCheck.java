package laba_10;

public class InnCheck {

    String text;

    public void execute(String text) {
        System.out.println("Текст = " + text);
        this.text = text;
        if (text.length() == 10) {
            int n10 = 2 * n(1) + 4 * n(2) + 10 * n(3) + 3 * n(4) + 5 * n(5) + 9 * n(6) + 4 * n(7) + 6 * n(8) + 8 * n(9);
            n10 = n10 % 11;
            n10 = n10 % 10;
            System.out.println("n10 = " + n10);
        } else if (text.length() == 12) {
            int n11 = 7 * n(1) + 2 * n(2) + 4 * n(3) + 10 * n(4) + 3 * n(5) + 5 * n(6) + 9 * n(7) +4 * n(8) + 6 * n(9) + 8 * n(10);
            int n12 = 3 * n(1) + 7 * n(2) + 2 * n(3) + 4 * n(4) + 10 * n(5) + 3 * n(6) + 5 * n(7) + 9 * n(8) + 4 * n(9) + 6 * n(10) + 8 * n(11);
            n11 = (n11 % 11) % 10;
            n12 = (n12 % 11) % 10;
            System.out.println("n11 = " + n11);
            System.out.println("n12 = " + n12);
        }
        System.out.println();
    }

    public int n(int i) {
        return Integer.valueOf(text.split("")[i - 1]);
    }
}
