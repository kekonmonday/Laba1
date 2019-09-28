package laba_4;

import java.util.List;
import java.util.Random;

public class RandomCharacterGenerator {

    public static String ALPHABET = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";

    private String text;

    private List<Integer> existsIndexes;

    private static Random random;

    static {
        random = new Random();
    }

    public RandomCharacterGenerator(String text, List<Integer> existsIndexes) {
        this.text = text;
        this.existsIndexes = existsIndexes;
    }

    public Character next() {
        if (existsIndexes.size() == text.length()) {
            return ' ';
        }
        int randomIndex = random.nextInt(text.length());
        if (existsIndexes.contains(randomIndex)) {
            return next();
        }
        existsIndexes.add(randomIndex);
        return text.charAt(randomIndex);
    }

}