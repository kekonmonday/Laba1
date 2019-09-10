package laba_2.encryption;

import laba_2.helper.EncryptionHelper;

public class SimpleSinglePermutationEncryption extends Encryption {

    public static final String TAG = "Проста одинична перестановка";

    public SimpleSinglePermutationEncryption(String text, String key) {
        super(TAG, text, key);
    }

    @Override
    public String execute() {
        StringBuilder builder = new StringBuilder();
        String[] keys = getKey().split(EncryptionHelper.SPLIT_BY);
        String[] newWord = new String[keys.length];
        for (int i = 0; i < getText().length(); i++) {
            String c = getText().charAt(i) + "";
            newWord[Integer.valueOf(keys[i]) - 1] = c;
        }
        for (String s : newWord) {
            builder.append(s);
        }
        return builder.toString();
    }

}
