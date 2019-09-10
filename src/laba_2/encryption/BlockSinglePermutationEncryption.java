package laba_2.encryption;

import laba_2.generator.Generator;
import laba_2.helper.EncryptionHelper;

import java.util.Random;

public class BlockSinglePermutationEncryption extends Encryption {

    public static final String TAG = "Блочна одинична перестановка";

    public BlockSinglePermutationEncryption(String text, String key) {
        super(TAG, text, key);
    }

    @Override
    public String execute() {
        StringBuilder builder = new StringBuilder();
        String[] keys = getKey().split(EncryptionHelper.SPLIT_BY);
        String[] textBlocks = EncryptionHelper.splitBySize(getText(), keys.length);
        Random random = new Random();
        for (String textBlock : textBlocks) {
            StringBuilder newText = new StringBuilder(textBlock);
            if (textBlock.length() < keys.length) {
                for (int i = textBlock.length(); i < keys.length; i++) {
                    newText.append(Generator.ALPHABET.charAt(random.nextInt(Generator.ALPHABET.length())));
                }
            }
            String[] newWord = new String[keys.length];
            for (int i = 0; i < newText.length(); i++) {
                String c = newText.charAt(i) + "";
                newWord[Integer.valueOf(keys[i]) - 1] = c;
            }
            for (String s : newWord) {
                builder.append(s);
            }
        }
        return builder.toString();
    }

}
