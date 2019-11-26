package laba_12;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Asmut {

    public void execute(int s) {
        //int s = text.charAt(0);
        int p = getPrimeNumber(s + 10, s);
        List<Integer> d = getD(p);
        System.out.println("d = " + d);
        int g = (d.get(0) * d.get(1) * d.get(2) - s) / p;
        long r = getRandomNumber(g, 1);
        long s1 = s + r * p;
        List<Long> k = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            k.add(s1 % d.get(i));
        }
        System.out.println("k = " + k);
        long d2 = d.get(1);
        long d3 = d.get(2);
        long d5 = d.get(4);
        long D = d2 * d3 * d5;
        long D1 = D / d2;
        long D2 = D / d3;
        long D3 = D / d5;
        System.out.println("D1 = " + D1);
        System.out.println("D2 = " + D2);
        System.out.println("D3 = " + D3);
        long D11 = modInverse(BigInteger.valueOf(D1), BigInteger.valueOf(d2)).intValue();
        long D21 = modInverse(BigInteger.valueOf(D2), BigInteger.valueOf(d3)).intValue();
        long D31 = modInverse(BigInteger.valueOf(D3), BigInteger.valueOf(d5)).intValue();
        long S11 = BigInteger.valueOf(k.get(1)).multiply(BigInteger.valueOf(D1)).multiply(BigInteger.valueOf(D11)).add(
                BigInteger.valueOf(k.get(2)).multiply(BigInteger.valueOf(D2)).multiply(BigInteger.valueOf(D21)).add(
                        BigInteger.valueOf(k.get(4)).multiply(BigInteger.valueOf(D3)).multiply(BigInteger.valueOf(D31))
                )
        ).mod(BigInteger.valueOf(D)).intValue();
        System.out.println("S` = " + S11);
        //long S11 = (k.get(1) * D1 * D11 + k.get(2) * D2 * D21 + k.get(4) * D3 * D31) % D;
        System.out.println("Secret = " + (S11 % p));

    }

    private static BigInteger[] gcdD(BigInteger a, BigInteger b) {
        if (b.compareTo(BigInteger.ZERO) == 0)
            return new BigInteger[]{a, BigInteger.ONE, BigInteger.ZERO};
        else {
            BigInteger n = a.divide(b);
            BigInteger c = a.mod(b);
            BigInteger[] r = gcdD(b, c);
            return new BigInteger[]{r[0], r[2], r[1].subtract(r[2].multiply(n))};
        }
    }

    private static BigInteger modInverse(BigInteger k, BigInteger prime) {
        k = k.mod(prime);
        BigInteger r = (k.compareTo(BigInteger.ZERO) == -1) ? (gcdD(prime, k.negate())[2]).negate() : gcdD(prime, k)[2];
        return prime.add(r).mod(prime);
    }

    public static void main(String[] args) {
        new Asmut().execute(32);
    }

    public static int getRandomNumber(int max, int min) {
        int num = getRandomNumber(max);
        while (num < min) {
            num = getRandomNumber(max);
        }
        return num;
    }

    public static int getRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public List<Integer> getD(int p) {
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                d.add(getPrimeNumber(p + 5, p + 1));
            } else {
                d.add(getPrimeNumber(d.get(i - 1) + 500, d.get(i - 1) + 1));
            }
        }
        if (d.get(0) * d.get(1) * d.get(2) > d.get(3) * d.get(4)) {
            return getD(p);
        }
        return d;
    }

    public static int getPrimeNumber(int max, int min) {
        int num = getPrimeNumber(max);
        while (num < min) {
            num = getPrimeNumber(max);
        }
        return num;
    }

    public static int getPrimeNumber(int max) {
        Random rand = new Random();
        int num = rand.nextInt(max);
        while (!isPrimeNumber(num)) {
            num = rand.nextInt(max);
        }
        return num;
    }

    public static boolean isPrimeNumber(int inputNum) {
        if (inputNum <= 3 || inputNum % 2 == 0)
            return inputNum == 2 || inputNum == 3;
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0))
            divisor += 2;
        return inputNum % divisor != 0;
    }

}
