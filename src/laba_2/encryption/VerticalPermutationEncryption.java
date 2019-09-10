package laba_2.encryption;

import laba_2.helper.ConsoleHelper;
import laba_2.helper.EncryptionHelper;

import java.util.*;

public class VerticalPermutationEncryption extends Encryption {

    public static final String TAG = "Вертикальна перестановка";

    public static final int SIZE = 5;

    public VerticalPermutationEncryption(String text, String key) {
        super(TAG, text, key);
    }

    @Override
    public String execute() {
        String[] keys = getKey().split(EncryptionHelper.SPLIT_BY);
        List<List> table = EncryptionHelper.createTable(getText(), SIZE);
        ConsoleHelper.printCipherReplacement(table);
        table = EncryptionHelper.verticalSort(table, keys);
        ConsoleHelper.printCipherReplacement(table);
        StringBuilder builder = new StringBuilder();
        for (List list : table) {
            for (Object o : list) {
                builder.append(o == null ? " " : o);
            }
        }
        return builder.toString();
    }

}
