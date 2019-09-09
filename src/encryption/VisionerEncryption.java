package encryption;

import generator.Generator;
import generator.GeneratorFactory;
import helper.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;

public class VisionerEncryption extends Encryption {

    private static final String TAG = "Шифр Віжіонера";

    private String key;

    public VisionerEncryption(String text, String key) {
        super(TAG, text, key);
        StringBuilder newKey = new StringBuilder(key);
        if (text.length() > key.length()) {
            for (int i = 0; i < (text.length() / key.length()) + 1; i++) {
                newKey.append(key);
            }
        } else {
            newKey = new StringBuilder(key);
        }
        this.key = newKey.substring(0, text.length());
    }


    public String execute() {
        Generator generator = GeneratorFactory.getGeneratorWithShift(Generator.ALPHABET, 0);
        StringBuilder builder = new StringBuilder();
        List<List> table = new ArrayList<>();
        for (int i = 0; i < Generator.ALPHABET.length(); i++) {
            generator.next();
            ArrayList currentList = new ArrayList();
            for (int j = 0; j < Generator.ALPHABET.length(); j++) {
                currentList.add(generator.next());
            }
            table.add(currentList);
        }
        System.out.println("Таблица: ");
        ConsoleHelper.printCipherReplacement(table);
        for (int i = 0; i < getText().length(); i++) {
            int index1 = Generator.ALPHABET.indexOf(getText().charAt(i));
            int index2 = Generator.ALPHABET.indexOf(key.charAt(i));
            builder.append(table.get(index1).get(index2));
        }
        return builder.toString();
    }

}
