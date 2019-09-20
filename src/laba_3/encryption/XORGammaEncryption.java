package laba_3.encryption;

import laba_3.helper.ConsoleHelper;

public class XORGammaEncryption extends Encryption {

    public static final String TAG = "Гамма шифрування по модулю 2";

    public XORGammaEncryption(String text, String key) {
        super(TAG, text, key);
    }

    @Override
    public String execute() {
        StringBuilder key = new StringBuilder(getKey());
        for (; key.length() < getText().length(); ) {
            key.append(getKey());
        }
        setKey(key.toString().substring(0, getText().length()));
        Integer[] textReplacement = new Integer[getText().length()];
        for (int i = 0; i < getText().length(); i++) {
            textReplacement[i] = (int) getText().charAt(i);
        }
        ConsoleHelper.printBinaryCipherReplacement(textReplacement);
        Integer[] keyReplacement = new Integer[getKey().length()];
        for (int i = 0; i < getText().length(); i++) {
            keyReplacement[i] = (int) getKey().charAt(i);
        }
        ConsoleHelper.printBinaryCipherReplacement(keyReplacement);
        Integer[] cipherReplacement = new Integer[getText().length()];
        for (int i = 0; i < getText().length(); i++) {
            cipherReplacement[i] = (textReplacement[i] ^ keyReplacement[i]);
        }
        StringBuilder result = new StringBuilder();
        for (Integer i : cipherReplacement) {
            StringBuilder builder = new StringBuilder(Integer.toBinaryString(i));
            while (builder.length() < 8) {
                builder.insert(0, 0);
            }
            result.append(builder.toString()).append("\t");
        }
        return result.toString();
    }

}
