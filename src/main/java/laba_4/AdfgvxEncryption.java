package laba_4;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class AdfgvxEncryption extends Encryption {

    public static final String TAG = "ADFGVX шифрування";

    public static final String ADFGVX = "ADFGVX";

    AdfgvxEncryption(String text, String key) {
        super(TAG, text, key);
    }

    @Override
    public String execute() {
        return getChipherReplacement()
                .doOnNext(ConsoleHelper::printCipherReplacement)
                .map(this::getTextCharacterIndexes)
                .flatMapIterable(l -> l)
                .collect(StringBuilder::new, (stringBuilder, indexes) -> stringBuilder
                        .append(ADFGVX.charAt(indexes.getRow()))
                        .append(ADFGVX.charAt(indexes.getColumn())))
                .map(StringBuilder::toString)
                .toObservable()
                .map(s -> EncryptionHelper.splitBySize(s, getKey().length()))
                .doOnNext(System.out::println)
                .doOnNext(strings -> System.out.println())
                .flatMapIterable(l -> l)
                .collect((Callable<List<List<String>>>) ArrayList::new, this::collect)
                .doOnSuccess(ConsoleHelper::printSquare)
                .map(lists -> EncryptionHelper.verticalSort(lists, getKey().split("")))
                .doOnSuccess(ConsoleHelper::printSquare)
                .map(EncryptionHelper::transpose)
                .toObservable()
                .flatMapIterable(l -> l)
                .flatMapIterable(l -> l)
                .collect(StringBuilder::new, StringBuilder::append)
                .toObservable()
                .blockingSingle()
                .toString();
    }



    private Observable<Character[][]> getChipherReplacement() {
        return Observable.create(s -> {
            RandomCharacterGenerator randomCharacterGenerator = new RandomCharacterGenerator(RandomCharacterGenerator.ALPHABET,
                    new ArrayList<>());
            Character[][] cipherReplacement = new Character[6][6];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    cipherReplacement[i][j] = randomCharacterGenerator.next();
                }
            }
            s.onNext(cipherReplacement);
            s.onComplete();
        });
    }

    private List<Indexes> getTextCharacterIndexes(Character[][] characters) {
        List<Indexes> indexes = new ArrayList<>();
        for (Character character : getText().toUpperCase().toCharArray()) {
            indexes.add(EncryptionHelper.getIndexes(characters, character));
        }
        return indexes;
    }

    private void collect(List<List<String>> lists, String s) {
        List<String> strings = EncryptionHelper.splitBySize(s, 1);
        for ( ; strings.size() < getKey().length() ; ) {
            strings.add(" ");
        }
        lists.add(strings);
    }

}
