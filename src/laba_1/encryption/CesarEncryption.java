package laba_1.encryption;

import laba_1.generator.Generator;
import laba_1.generator.GeneratorFactory;
import laba_1.helper.ConsoleHelper;

public class CesarEncryption extends Encryption {

    private static final String TAG = "Шифр Цезаря";

    public CesarEncryption(String text, String key) {
        super(TAG, text, key);
    }

    @Override
    public String execute() {
        Generator generator = GeneratorFactory.getGeneratorWithShift(Generator.ALPHABET, Integer.valueOf(getKey()));
        Character[] cipherReplacement = new Character[Generator.ALPHABET.length()];
        for (int i = 0; i < cipherReplacement.length; i++) {
            cipherReplacement[i] = generator.next();
        }
        ConsoleHelper.printCipherReplacement(cipherReplacement);
        StringBuilder result = new StringBuilder();
        for (char c : getText().toCharArray()) {
            result.append(cipherReplacement[Generator.ALPHABET.indexOf(c)]);
        }
        return result.toString();
    }


}
