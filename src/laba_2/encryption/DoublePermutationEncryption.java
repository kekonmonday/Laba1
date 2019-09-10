package laba_2.encryption;

import laba_2.generator.Generator;
import laba_2.generator.GeneratorFactory;
import laba_2.helper.ConsoleHelper;
import laba_2.helper.EncryptionHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoublePermutationEncryption extends Encryption {

    public static final String TAG = "Двійна перестановка";

    private String verticalKey;

    private String horizontalKey;


    public DoublePermutationEncryption(String text, String verticalKey, String horizontalKey) {
        super(TAG, text, null);
        this.verticalKey = verticalKey;
        this.horizontalKey = horizontalKey;
    }

    @Override
    public String execute() {
        Generator generator = GeneratorFactory.getGenerator(getText());
        StringBuilder builder = new StringBuilder();
        String[] verticalKeys = verticalKey.split(EncryptionHelper.SPLIT_BY);
        String[] horizontalKeys = horizontalKey.split(EncryptionHelper.SPLIT_BY);
        List<List> table = new ArrayList<>();
        for (int i = 0; i < verticalKeys.length; i++) {
            List currentList = new ArrayList();
            for (int j = 0; j < horizontalKeys.length; j++) {
                currentList.add(generator.next());
            }
            table.add(currentList);
        }
        ConsoleHelper.printCipherReplacement(table);
        table = EncryptionHelper.verticalSort(table, horizontalKeys);
        ConsoleHelper.printCipherReplacement(table);
        table = EncryptionHelper.horizontalSort(table, verticalKeys);
        ConsoleHelper.printCipherReplacement(table);
        for (List characters : table) {
            for (Object character : characters) {
                if (character == null) {
                    builder.append(' ');
                } else {
                    builder.append(character);
                }
            }
        }
        return builder.toString();
    }

}
