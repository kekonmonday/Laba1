package laba_5;

import io.reactivex.Observable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class AlGamalEncryption extends Encryption {

    private static final String TAG = "Алгоритм шифрования Эль-Гамаля";

    private int p;

    private int g;

    private int x;

    private int y;

    private int k;

    private int a;

    AlGamalEncryption(String text) {
        super(TAG, text);
        p = EncryptionHelper.getPrimeNumber(50, 40);
        System.out.println("P = " + p);
        g = (int) EncryptionHelper.getPRoot(p);
        System.out.println("G = " + g);
        x = EncryptionHelper.getRandomNumber(p - 1, 1);
        System.out.println("X = " + x);
        y = BigInteger.valueOf(g).pow(x).mod(BigInteger.valueOf(p)).intValue();
        System.out.println("Y = " + y);
        k = EncryptionHelper.getRandomNumber(p - 1, 1);
        System.out.println("K = " + k);
        a = BigInteger.valueOf(g).pow(k).mod(BigInteger.valueOf(p)).intValue();
        System.out.println("A = " + a);
    }

    @Override
    public String execute() {
        System.out.println();
        System.out.println("Символи:");
        ConsoleHelper.printBinaryCipherReplacement(Arrays.asList(getText().split("")));
        Observable.fromIterable(/*Arrays.asList(1, 2, 18, 1, 14, 16, 3))*/Arrays.asList(getText().split("")))
                .map(s -> EncryptionHelper.ALPHABET.indexOf(s))
                .collect(ArrayList<Integer>::new, ArrayList::add)
                .doOnSuccess(integers -> System.out.println("Індекси:"))
                .doOnSuccess(ConsoleHelper::printCipherReplacement)
                .toObservable()
                .flatMapIterable(l -> l)
                .map(integer -> (BigInteger.valueOf(y).pow(k)).multiply(BigInteger.valueOf(integer)).mod(BigInteger.valueOf(p)).intValue())
                .collect(ArrayList<Integer>::new, ArrayList::add)
                .doOnSuccess(integers -> System.out.println("Зашифровані індеси:"))
                .doOnSuccess(ConsoleHelper::printCipherReplacement)
                .toObservable()
                .flatMapIterable(l -> l)
                .map(integer -> BigInteger.valueOf(integer).multiply(BigInteger.valueOf(a).pow(p - 1 - x)).mod(BigInteger.valueOf(p)).intValue())
                .collect(ArrayList<Integer>::new, ArrayList::add)
                .doOnSuccess(integers -> System.out.println("Дешифровані індеси:"))
                .doOnSuccess(ConsoleHelper::printCipherReplacement)
                .subscribe();

        return null;
    }
}
