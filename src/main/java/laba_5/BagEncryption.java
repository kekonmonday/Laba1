package laba_5;

import io.reactivex.Observable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BagEncryption extends Encryption {

    private static final String TAG = "Алгоритм на основе задачи об укладке ранца";

    private List<Integer> closedKey;

    private List<Integer> openKey;

    private int n;

    private int m;

    private BigInteger revertValue;

    BagEncryption(String text) {
        super(TAG, text);
        closedKey = EncryptionHelper.getBagClosedKey(8);
        //closedKey = Arrays.asList(2, 3,	6, 13, 27, 52, 105, 210);
        System.out.println("Закритий ключ:");
        ConsoleHelper.printCipherReplacement(closedKey);
        Integer sum = closedKey.stream().reduce(0, Integer::sum);
        m = sum + 2;
        System.out.println("M = " + m);
        n = EncryptionHelper.getOpenedKey(m);
        System.out.println("N = " + n);
        openKey = Observable.fromIterable(closedKey)
                .map(integer -> BigInteger.valueOf(integer * n).mod(BigInteger.valueOf(m)).intValue())
                .collect(ArrayList<Integer>::new, List::add)
                .blockingGet();
        System.out.println();
        System.out.println("Відкритий ключ:");
        ConsoleHelper.printCipherReplacement(openKey);
        revertValue = EncryptionHelper.getClosedKey(n, m);
    }

    @Override
    public String execute() {
        Observable.fromIterable(Arrays.asList(getText().split("")))
                .map(s -> s.charAt(0))
                .collect(ArrayList<Character>::new, List::add)
                //.doOnSuccess(ConsoleHelper::printCipherReplacement)
                .toObservable()
                .flatMapIterable(l -> l)
                .map(Integer::toBinaryString)
                .map(EncryptionHelper::convert)
                .collect(ArrayList<String>::new, List::add)
                .doOnSuccess(strings ->  System.out.println("Бінарне представлення символу:"))
                .doOnSuccess(ConsoleHelper::printBinaryCipherReplacement)
                .toObservable()
                .flatMapIterable(l -> l)
                .map(s -> EncryptionHelper.encodeBag(openKey, s))
                .collect(ArrayList<Integer>::new, List::add)
                .doOnSuccess(strings ->  System.out.println("Зашифроване повідомлення:"))
                .doOnSuccess(ConsoleHelper::printCipherReplacement)
                .toObservable()
                .flatMapIterable(l -> l)
                .map(integer -> BigInteger.valueOf(integer).multiply(revertValue).mod(BigInteger.valueOf(m)).intValue())
                .collect(ArrayList<Integer>::new, List::add)
                .doOnSuccess(strings ->  System.out.println("Розшифроване повідомлення:"))
                .doOnSuccess(ConsoleHelper::printCipherReplacement)
                .toObservable()
                .flatMapIterable(l -> l)
                .map(s -> EncryptionHelper.decodeBag(closedKey, s))
                .collect(ArrayList<String>::new, List::add)
                .doOnSuccess(strings ->  System.out.println("Бінарне представлення розшифрованих символів:"))
                .doOnSuccess(ConsoleHelper::printBinaryCipherReplacement)
                .subscribe();
        return null;
    }
}
