package laba_1.encryption;

import laba_1.generator.Generator;
import laba_1.generator.GeneratorFactory;
import laba_1.helper.ConsoleHelper;

import java.util.ArrayList;

public class LosungEncryption extends Encryption {

    private static final String TAG = "Лозунговий шифр";

    public LosungEncryption(String text, String key) {
        super(TAG, text, key);
    }

    @Override
    public String execute() {
        Generator generator = GeneratorFactory.getGeneratorWithShift(Generator.ALPHABET, 0);
        ArrayList<Character> cipherReplacement = new ArrayList<>();
        for (Character character : getKey().toCharArray()) {
            if (!cipherReplacement.contains(character)) {
                cipherReplacement.add(character);
            }
        }
        do {
            Character next = generator.next();
            if (!cipherReplacement.contains(next)) {
                cipherReplacement.add(next);
            }
        } while (cipherReplacement.size() != Generator.ALPHABET.length());
        ConsoleHelper.printCipherReplacement(cipherReplacement);
        StringBuilder result = new StringBuilder();
        for (char c : getText().toCharArray()) {
            result.append(cipherReplacement.get(Generator.ALPHABET.indexOf(c)));
        }
        return result.toString();
    }

}
