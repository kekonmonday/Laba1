package laba_2.encryption;

import laba_2.helper.ConsoleHelper;
import laba_2.helper.EncryptionHelper;

import java.util.ArrayList;
import java.util.List;

public class TableRoutePermutationEncryption extends Encryption {

    public static final String TAG = "Таблична маршрутна перестановка";

    public static final int SIZE = 5;

    public TableRoutePermutationEncryption(String text) {
        super(TAG, text, null);
    }

    @Override
    public String execute() {
        StringBuilder builder = new StringBuilder();
        List<List> table = EncryptionHelper.createTable(getText(), SIZE);
        ConsoleHelper.printCipherReplacement(table);
        for (int i = 0; i < SIZE; i++) {
            for (List value : table) {
                builder.append(value.get(i));
            }
        }
        return builder.toString();
    }

}
