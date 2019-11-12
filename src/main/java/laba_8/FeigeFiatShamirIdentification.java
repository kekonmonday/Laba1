package laba_8;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FeigeFiatShamirIdentification {

    public void execute() {
        int p = EncryptionHelper.getPrimeNumber(20);
        System.out.println("p = " + p);
        int q = EncryptionHelper.getPrimeNumber(20);
        System.out.println("q = " + q);
        int n = p * q;
        System.out.println("n = " + n);
        QuadraticSquare quadraticSquare = getQuadraticSquare(BigInteger.valueOf(n));
        assert quadraticSquare != null;
        System.out.println("v = " + quadraticSquare.v);
        System.out.println("v1 = " + quadraticSquare.v1);
        int s = getS(n, quadraticSquare.v1);
        System.out.println("s = " + s);
        RAndZ rAndZ;
        System.out.println("А вычисляет z = " + (rAndZ = getRandomRAndZ(n)).z + " и посылает z Б.");
        int b;
        System.out.println("Б посылает А случайный бит b = " + (b = new Random().nextInt(2)));
        if (b == 0) {
            System.out.println("А посылает Б r = " + rAndZ.r);
            System.out.println("Б проверяет, что z = r^2 mod n и результат = " + (rAndZ.z == BigInteger.valueOf(rAndZ.r).pow(2).mod(BigInteger.valueOf(n)).intValue()));
        } else {
            int y;
            System.out.println("А посылает Б y = " + (y = BigInteger.valueOf(rAndZ.r).multiply(BigInteger.valueOf(s)).mod(BigInteger.valueOf(n)).intValue()));
            System.out.println("Б проверяет, что z = (y^2 * v) mod n и результат = " + (rAndZ.z == BigInteger.valueOf(y).pow(2).multiply(BigInteger.valueOf(quadraticSquare.v)).mod(BigInteger.valueOf(n)).intValue()));
        }
    }

    private static QuadraticSquare getQuadraticSquare(BigInteger n) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 1; i <= n.intValue(); i++) {
            integers.add(BigInteger.valueOf(i).pow(2).mod(n).intValue());
        }
        for (Integer integer : integers) {
            int i = 1;
            while (i < 1000) {
                if (BigInteger.valueOf(integer).multiply(BigInteger.valueOf(i)).mod(n).intValue() == 1) {
                    return new QuadraticSquare(integer, i);
                }
                i++;
            }
        }
        return null;
    }

    private static RAndZ getRandomRAndZ(int n) {
        int r = new Random().nextInt(n - 1);
        int z = BigInteger.valueOf(r).pow(2).mod(BigInteger.valueOf(n)).intValue();
        return new RAndZ(r, z);
    }

    private static int getS(int n, int v1) {
        int i = 1;
        while (true) {
            if (BigInteger.valueOf(i).pow(2).mod(BigInteger.valueOf(n)).intValue() == v1) {
                return i;
            }
            i++;
        }
    }

    static class RAndZ {

        int r;

        int z;

        RAndZ(int r, int z) {
            this.r = r;
            this.z = z;
        }

    }

    static class QuadraticSquare {

        int v;

        int v1;

        QuadraticSquare(int v, int v1) {
            this.v = v;
            this.v1 = v1;
        }

    }

}
