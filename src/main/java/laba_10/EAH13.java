package laba_10;

public class EAH13 {

    public void execute(String text) {
        System.out.println("Текст = " + text);
        int sOdd = 0;
        int sEven = 0;
        int last = 0;
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 != 0) {
                last = Integer.valueOf(text.split("")[i]);
                sOdd += Integer.valueOf(text.split("")[i]);
            } else {
                sEven += 3 * Integer.valueOf(text.split("")[i]);
            }
        }
        sOdd -= last;
        int i = 0;
        while ((sEven + sOdd + i) % 10 != 0) {
            i++;
        }
        System.out.println("cd = " + i);
        System.out.println();
    }

}
