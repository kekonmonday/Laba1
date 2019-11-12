package laba_8;

import java.math.BigInteger;

public class RSA {

    private int e = 5;

    private int n = 91;

    private int d = 29;

    private int k = 19;

    public void execute() {
        System.out.println("e = " + e);
        System.out.println("n = " + n);
        System.out.println("d = " + d);
        System.out.println("k = " + k);
        BigInteger r = BigInteger.valueOf(k).pow(e).mod(BigInteger.valueOf(n));
        System.out.println("Б посылает к А значение r = " + r.intValue());
        BigInteger k1 = r.pow(d).mod(BigInteger.valueOf(n));
        System.out.println("А генерирует значение k` = " + k1.intValue() + " и посылает к Б");
        System.out.println("Б проверяет результат А и результат " + (k1.intValue() == k));
    }

}
