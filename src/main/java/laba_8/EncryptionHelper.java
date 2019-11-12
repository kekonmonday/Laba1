package laba_8;

import java.math.BigInteger;
import java.util.*;

public class EncryptionHelper {

    public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();

    static int getOpenedKey(int euler) {
        int maybeOpenKey = getPrimeNumber(euler);
        while (euler % maybeOpenKey == 0) {
            maybeOpenKey = getPrimeNumber(euler);
        }
        return maybeOpenKey;
    }

    /*static BigInteger getClosedKey(int openKey, int euler) {
        BigInteger i = BigInteger.valueOf(2);
        do {
            i = i.add(BigInteger.ONE);
        } while (i.multiply(BigInteger.valueOf(openKey)).mod(BigInteger.valueOf(euler)).intValue() != 1 || i.intValue() == openKey || isPrimeNumber(i.intValue()));
        return i;
    }*/

    static BigInteger getQShnor(int p) {
        BigInteger i = BigInteger.valueOf(2);
        BigInteger newP = BigInteger.valueOf(p - 1);
        do {
            i = i.add(BigInteger.ONE);
        } while (!(newP.mod(i).intValue() == 0 && isPrimeNumber(i.intValue())));
        return i;
    }

    static BigInteger getGShnor(int p, int q) {
        BigInteger i = BigInteger.valueOf(2);
        BigInteger bigIntegerP = BigInteger.valueOf(p);
        do {
            i = i.add(BigInteger.ONE);
        } while (i.pow(q).mod(bigIntegerP).intValue() != 1);
        return i;
    }

    static BigInteger getYShnor(int g, int x, int p) {
        BigInteger i = BigInteger.valueOf(2);
        BigInteger bigIntegerP = BigInteger.valueOf(p);
        BigInteger bigIntegerG = BigInteger.valueOf(g).pow(x);
        do {
            i = i.add(BigInteger.ONE);
        } while (bigIntegerG.multiply(i).mod(bigIntegerP).intValue() != 1);
        return i;
    }

    public static int getEuler(int p, int q) {
        return (p - 1) * (q - 1);
    }

    public static int getPrimeNumber(int max) {
        Random rand = new Random();
        int num = rand.nextInt(max);
        while (!isPrimeNumber(num)) {
            num = rand.nextInt(max);
        }
        return num;
    }

    public static int getPrimeNumber(int max, int min) {
        int num = getPrimeNumber(max);
        while (num < min) {
            num = getPrimeNumber(max);
        }
        return num;
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

    public static boolean isPrimeNumber(int inputNum) {
        if (inputNum <= 3 || inputNum % 2 == 0)
            return inputNum == 2 || inputNum == 3;
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0))
            divisor += 2;
        return inputNum % divisor != 0;
    }

    static List<Integer> getBagClosedKey(int size) {
        List<Integer> closedKey = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                closedKey.add(getRandomNumber(10));
            } else {
                int sum = 0;
                for (int j = i - 1; j >= 0; j--) {
                    sum += closedKey.get(j);
                }
                closedKey.add(getRandomNumber(sum + 10, sum + 1));
            }
        }
        return closedKey;
    }

    static String convert(String binary) {
        StringBuilder builder = new StringBuilder(binary);
        for (; builder.length() != 8; ) {
            builder.insert(0, 0);
        }
        return builder.toString();
    }

    static Integer encodeBag(List<Integer> integers, String s) {
        Integer integer = 0;
        String[] s1 = s.split("");
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].equals("1")) {
                integer += integers.get(i);
            }
        }
        return integer;
    }

    public static String decodeBag(List<Integer> closedKey, Integer s) {
        StringBuilder s1 = new StringBuilder();
        for (int i = closedKey.size() - 1; i >= 0; i--) {
            if (s - closedKey.get(i) >= 0) {
                s1.insert(0, "1");
                s = s - closedKey.get(i);
            } else {
                s1.insert(0, "0");
            }
        }
        return s1.toString();
    }

    public static long getPRoot(long p) {
        for (long i = 0; i < p; i++)
            if (isPRoot(p, i))
                return i;
        return 0;
    }

    public static boolean isPRoot(long p, long a) {
        if (a == 0 || a == 1)
            return false;
        long last = 1;

        Set<Long> set = new HashSet<>();
        for (long i = 0; i < p - 1; i++) {
            last = (last * a) % p;
            if (set.contains(last))
                return false;
            set.add(last);
        }
        return true;
    }


}
