package laba_12;

import java.math.BigInteger;
import java.util.Random;

public class Mnogie {

    public void execute(int s1, int s2, int s3) {
        int e1 = 5;
        int e2 = 7;
        int e3 = 17;
        int n1 = 91;
        int n2 = 91;
        int n3 = 91;
        int d1 = 29;
        int d2 = 31;
        int d3 = 17;
        int x = new Random().nextInt(15) + 1;
        int c1 = BigInteger.valueOf(s3).add(BigInteger.valueOf(x)).pow(e2).mod(BigInteger.valueOf(n3)).intValue();
        System.out.println("У прибавляет случайное секретное число х = " + x + " к сумме своей зарплаты, шифрует результат с помощью открытого ключа С и отсылает его С. ( " + c1 + " )");
        int c2 = BigInteger.valueOf(c1).pow(d2).mod(BigInteger.valueOf(n2)).intValue();
        int c3 = BigInteger.valueOf(c2).add(BigInteger.valueOf(s2)).pow(e1).mod(BigInteger.valueOf(n2)).intValue();
        System.out.println("С расшифровывает результат = " + c2 + ", добавляет к нему свою зарплату, шифрует результат с помощью открытого ключа Д и отсылает его Д. ( " + c3 + " )");
        int c4 = BigInteger.valueOf(c3).pow(d1).mod(BigInteger.valueOf(n3)).intValue();
        int c5 = BigInteger.valueOf(c4).add(BigInteger.valueOf(s1)).pow(e3).mod(BigInteger.valueOf(n2)).intValue();
        System.out.println("Д расшифровывает результат = " + c4 + ", добавляет к нему свою зарплату, шифрует результат с помощью открытого ключа У и отсылает его У. ( " + c5 + " )");
        int c6 = BigInteger.valueOf(c5).pow(e3).mod(BigInteger.valueOf(n1)).intValue();
        int c7 = (c6 - x) / 3;
        System.out.println("У расшифровывает результат, отнимает х и объявляет среднюю зарплату. = " + c7);
    }

    public static void main(String[] args) {
        new Mnogie().execute(10, 13, 16);
    }

}
