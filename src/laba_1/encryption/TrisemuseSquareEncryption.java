package laba_1.encryption;

import laba_1.generator.Generator;
import laba_1.generator.GeneratorFactory;
import laba_1.helper.ConsoleHelper;
import laba_1.helper.EncryptionHelper;

import java.util.ArrayList;
import java.util.List;

public class TrisemuseSquareEncryption extends Encryption {

    private static final String TAG = "Шифр квадрату Трисемуса";

    private static final int SIZE;

    static {
        SIZE = (int) Math.sqrt(Generator.ALPHABET.length()) + 1;
    }

    public TrisemuseSquareEncryption(String text, String key) {
        super(TAG, text, key);
    }

    @Override
    public String execute() {
        Generator generator = GeneratorFactory.getGeneratorWithShift(Generator.ALPHABET, 0);
        List<List> cipherReplacement = new ArrayList<>();
        int index = 0;
        List<Character> currentList = null;
        for (Character character : getKey().toCharArray()) {
            if (index == 0) {
                currentList = new ArrayList<>();
            }
            if (!currentList.contains(character) && !EncryptionHelper.squareContains(cipherReplacement, character)) {
                if (index == 0) {
                    currentList = new ArrayList<>();
                }
                currentList.add(character);
                index++;
                if (index == SIZE) {
                    cipherReplacement.add(currentList);
                    index = 0;
                }
            }
        }
        assert currentList != null;
        if (currentList.size() != SIZE) {
            int g = currentList.size();
            do {
                Character next = generator.next();
                if (!EncryptionHelper.squareContains(cipherReplacement, next) && !currentList.contains(next)) {
                    currentList.add(next);
                    g++;
                }
            } while (g != SIZE);
            cipherReplacement.add(currentList);
        }
        for (int i = cipherReplacement.size(); i < SIZE; i++) {
            List<Character> otherList = new ArrayList<>();
            int j = 0;
            do {
                boolean isLastCharacters = j > (Math.pow(SIZE, 2) - Generator.ALPHABET.length()) - 1 && i == SIZE - 1;
                if (isLastCharacters) {
                    otherList.add(null);
                    j++;
                } else {
                    Character next = generator.next();
                    if (!EncryptionHelper.squareContains(cipherReplacement, next)) {
                        otherList.add(next);
                        j++;
                    }
                }
            } while (j != SIZE);
            cipherReplacement.add(otherList);
        }
        ConsoleHelper.printCipherReplacement(cipherReplacement);
        StringBuilder result = new StringBuilder();
        for (Character character : getText().toCharArray()) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    Character squareCharacter = (Character) cipherReplacement.get(i).get(j);
                    if (character.equals(squareCharacter)) {
                        if (i == SIZE - 1 || cipherReplacement.get(i + 1).get(j) == null) {
                            result.append(cipherReplacement.get(0).get(j));
                        } else {
                            result.append(cipherReplacement.get(i + 1).get(j));
                        }
                    }
                }
            }
        }
        return result.toString();
    }

}
