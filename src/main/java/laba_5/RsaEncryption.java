package laba_5;

import io.reactivex.Observable;

import java.math.BigInteger;
import java.util.ArrayList;

public class RsaEncryption extends Encryption {

    private int p;

    private int q;

    private int openedKey;

    private long closedKey;

    private static final String TAG = "RSA Шифрування";

    RsaEncryption(String text) {
        super(TAG, text);
        StringBuilder builder = new StringBuilder();
      // p = EncryptionHelper.getPrimeNumber(10, 2);
        p = 5;
        builder.append("P = ").append(p).append(System.lineSeparator());
        //q = EncryptionHelper.getPrimeNumber(10, (EncryptionHelper.ALPHABET.length() / p) + 1);
        q = 7;
        builder.append("Q = ").append(q).append(System.lineSeparator());
        int phi = EncryptionHelper.getEuler(p, q);
        builder.append("Function Euler = ").append(phi).append(System.lineSeparator());
        openedKey = EncryptionHelper.getOpenedKey(phi);
        builder.append("Opened Key = ").append(openedKey).append(System.lineSeparator());
        closedKey = EncryptionHelper.getClosedKey(openedKey, phi).intValue();
        builder.append("Closed Key = ").append(closedKey).append(System.lineSeparator()).append(System.lineSeparator());
        System.out.println(builder.toString());
    }

    @Override
    public String execute() {
        Observable.fromArray(getText().split(""))
                .doOnSubscribe(disposable -> System.out.print("Індекси:" + System.lineSeparator()))
                .map(character -> EncryptionHelper.ALPHABET.indexOf(character))
                .doOnNext(integer -> System.out.print(integer + "\t"))
                .collect(ArrayList<Integer>::new, ArrayList::add)
                .doOnSuccess(list -> System.out.print(System.lineSeparator() + System.lineSeparator() + "Шифр:" + System.lineSeparator()))
                .toObservable()
                .flatMapIterable(item -> item)
                .map(integer -> BigInteger.valueOf(integer).pow(openedKey).mod(BigInteger.valueOf(p * q)).intValue())
                .doOnNext(integer -> System.out.print(integer + "\t"))
                .collect(ArrayList<Integer>::new, ArrayList::add)
                .doOnSuccess(list -> System.out.print(System.lineSeparator() + System.lineSeparator() + "Дешифрування:" + System.lineSeparator()))
                .toObservable()
                .flatMapIterable(item -> item)
                .map(integer -> BigInteger.valueOf(integer).pow((int) closedKey).mod(BigInteger.valueOf(p * q)).intValue())
                .doOnNext(integer -> System.out.print(integer + "\t"))
                .subscribe();
        return null;
    }


}
