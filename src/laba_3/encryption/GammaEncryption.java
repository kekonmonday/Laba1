package laba_3.encryption;

import laba_3.helper.ConsoleHelper;
import laba_3.helper.EncryptionHelper;

public class GammaEncryption extends Encryption {

    public static final String TAG = "Гамма шифрування";

    private int module;

    public GammaEncryption(String text, String key, int module) {
        super(TAG, text, key);
        this.module = module;
        ConsoleHelper.printModule(module);
    }

    @Override
    public String execute() {
        StringBuilder key = new StringBuilder(getKey());
        for (; key.length() < getText().length();) {
            key.append(getKey());
        }
        setKey(key.toString().substring(0, getText().length()));
        Integer[] textReplacement = new Integer[getText().length()];
        for (int i = 0; i < getText().length(); i++) {
            textReplacement[i] = EncryptionHelper.ALPHABET.indexOf(getText().charAt(i));
        }
        ConsoleHelper.printCipherReplacement(textReplacement);
        Integer[] keyReplacement = new Integer[getKey().length()];
        for (int i = 0; i < getText().length(); i++) {
            keyReplacement[i] = EncryptionHelper.ALPHABET.indexOf(getKey().charAt(i));
        }
        ConsoleHelper.printCipherReplacement(keyReplacement);
        Integer[] cipherReplacement = new Integer[getText().length()];
        for (int i = 0; i < getText().length(); i++) {
            cipherReplacement[i] = (textReplacement[i] + keyReplacement[i]) % module;
        }
        ConsoleHelper.printCipherReplacement(cipherReplacement);
        StringBuilder result = new StringBuilder();
        for (Integer i : cipherReplacement) {
            result.append(EncryptionHelper.ALPHABET.charAt(i)).append(" ");
        }
        return result.toString();
    }
}
