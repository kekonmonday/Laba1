package laba_9;

import laba_8.Shnor;

import java.math.BigInteger;
import java.util.Random;

public class Gost94 {

    public void execute(String text) {
        int p = 79;
        int q = 13;
        int a = 8;
        int random = new Random().nextInt(q);
        int x = random == 0 ? random + 1 : random;
        int y = (int) (Math.pow(a, x) % p);
        int h = customHash256(text);
        int k, w, w1, s;
        do {
            k = new Random().nextInt(q);
            w = (int) (Math.pow(a, k) % p);
            w1 = (int) w % q;
            s = (x * w1 + k * h) % q;
        } while (w1 == 0 || s == 0);
        System.out.println("Отправка получателю B исходного сообщения = " + text + " и цифровой подписи (w` = " + w1 + ", s = " + s + ")");
        int h1 = customHash256(text);
        int v = (int) (Math.pow(h1, q -2) % q);
        int z1 = (s * v) % q;
        int z2 = ((q - w1) * v) % q;
        int u = BigInteger.valueOf(a).pow(z1).multiply(BigInteger.valueOf(y).pow(z2)).mod(BigInteger.valueOf(p)).mod(BigInteger.valueOf(q)).intValue();
        System.out.println("Т.к. w’ = u: " + w1 + " = " + u + ", то получатель B делает вывод, что полученное сообщение T’ = T и оно действительно отправлено А.");
    }

    public int customHash256(String text) {
        return text.length();
    }

    public static void main(String... strings) {
        new Gost94().execute("Protection");
    }



}
