package laba_1.encryption;

import laba_1.generator.Generator;
import laba_1.generator.GeneratorFactory;
import laba_1.helper.ConsoleHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OmophonesEncryption extends Encryption {

    private static final String TAG = "Шифр Омофонів";

    public OmophonesEncryption(String text) {
        super(TAG, text, null);
    }

    @Override
    public String execute() {
        Generator generator = GeneratorFactory.getGeneratorWithShift(Generator.ALPHABET, 0);
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> existsRandomIntegers = new ArrayList<>();
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        Random random = new Random();
        int i = 0;
        while (i <= Generator.ALPHABET.length()) {
            Character next = generator.next();
            ArrayList<Integer> currentList = new ArrayList<>();
            int randomValue;
            do {
                randomValue = random.nextInt((Generator.ALPHABET.length() * 2) + 2);
                if (!existsRandomIntegers.contains(randomValue)) {
                    currentList.add(randomValue);
                    existsRandomIntegers.add(randomValue);
                }
            } while (currentList.size() != 2);
            map.put(next, currentList);
            i++;
        }
        ConsoleHelper.printCipherReplacement(map);
        for (Character character : getText().toCharArray()) {
            s.append(map.get(character).get(random.nextInt(2))).append(" ");
        }
        return s.toString();
    }


}
