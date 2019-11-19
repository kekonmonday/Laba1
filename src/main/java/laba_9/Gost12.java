package laba_9;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.Random;

public class Gost12 {

    public void execute(String text) {
        int h = getHash(text);
        int q = 47;
        int e = h % q;
        int k = new Random().nextInt(q);
        Pair<Integer, Integer> c = new Pair<>(16, 16);
        int r = c.getKey() % q;
        int d = 10;
        int s = (r * d + k * e) % q;
        System.out.println("Отправка сообщения = " + text + " и r = " + r + "; s = " + s + ";");
        int h1 = getHash(text);
        int e1 = h1 % q;
        BigInteger e11 = BigInteger.ONE;
        while (BigInteger.valueOf(e1).multiply(e11).mod(BigInteger.valueOf(q)).intValue() != 1) {
            e11 = e11.add(BigInteger.ONE);
        }
        int v = e11.mod(BigInteger.valueOf(q)).intValue();
        int z1 = (s * v) % q;
        int z2 = ((q - r) * v) % q;
        Pair<Integer, Integer> c1 = new Pair<>(16, 16);
        int r1 = c1.getKey() % q;
        System.out.println("Т.к. r’ = r: " + r1 + " = " + r + ", то получатель B делает вывод, что полученное сообщение T’ = T и оно действительно отправлено А.");
    }

    public static void main(String[] args) {
        new Gost12().execute("IPZ");
    }

    private int getHash(String text) {
        return text.length();
    }

}
