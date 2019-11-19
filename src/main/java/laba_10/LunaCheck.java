package laba_10;

public class LunaCheck {

    public void execute(String text) {
        System.out.println("Текст = " + text);
        if (text.length() % 2 == 0) {
            String oddText = "";
            String evenText = "";
            String[] splitText = text.split("");
            for (int i = 0; i < splitText.length; i++) {
                if (i % 2 != 0) {
                    oddText += splitText[i];
                }
                if (i % 2 == 0) {
                    evenText += splitText[i];
                }
            }
            int sEven = 0;
            int sOdd = 0;
            String[] splitOddText = oddText.split("");
            String[] splitEvenText = evenText.split("");
            for (String s : splitOddText) {
                sOdd += ((Integer.valueOf(s) * 2) % 9);
            }
            for (int i = 0; i < splitEvenText.length; i++) {
                if (i != splitEvenText.length - 1) {
                    sEven += Integer.valueOf(splitEvenText[i]);
                }
            }
            int i = 0;
            while ((sEven + sOdd + i) % 10 != 0) {
                i++;
            }
            System.out.println("cd = " + i);
        } else {
            String oddText = "";
            String evenText = "";
            String[] splitText = text.split("");
            for (int i = 0; i < splitText.length; i++) {
                if (i % 2 == 0) {
                    oddText += splitText[i];
                }
                if (i % 2 != 0) {
                    evenText += splitText[i];
                }
            }
            int sEven = 0;
            int sOdd = 0;
            String[] splitOddText = oddText.split("");
            String[] splitEvenText = evenText.split("");
            for (String s : splitOddText) {
                sOdd += ((Integer.valueOf(s) * 2) % 9);
            }
            for (int i = 0; i < splitEvenText.length; i++) {
                if (i != splitEvenText.length - 1) {
                    sEven += Integer.valueOf(splitEvenText[i]);
                }
            }
            int i = 0;
            while ((sEven + sOdd + i) % 10 != 0) {
                i++;
            }
            System.out.println("cd = " + i);
        }
        System.out.println();
    }
}
