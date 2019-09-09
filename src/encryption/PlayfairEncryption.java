package encryption;

import generator.Generator;
import generator.GeneratorFactory;
import helper.ConsoleHelper;
import helper.EncryptionHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayfairEncryption extends Encryption {

    private static final String TAG = "Шифр Playfair";

    private static final int SIZE_HORIZONTAL = 8;

    private static final int SIZE_VERTICAL = 4;

    public PlayfairEncryption(String text, String key) {
        super(TAG, text, key);
    }

    @Override
    public String execute() {
        Generator generator = GeneratorFactory.getGeneratorWithShift(Generator.ALPHABET, 0);
        StringBuilder result = new StringBuilder();
        List<List> cipherReplacement = new ArrayList<>();
        int index = 0;
        List<Character> currentList = null;
        char[] keyCharArray = getKey().toCharArray();
        for (int i = 0; i < keyCharArray.length; i++) {
            if (index == 0) {
                currentList = new ArrayList<>();
            }
            if (!currentList.contains(keyCharArray[i]) && !EncryptionHelper.squareContains(cipherReplacement, keyCharArray[i])) {
                currentList.add(keyCharArray[i]);
                index++;
                if (index == SIZE_HORIZONTAL) {
                    cipherReplacement.add(currentList);
                    index = 0;
                }
            }
            if (i == keyCharArray.length - 1 && currentList.size() != SIZE_HORIZONTAL) {
                index = currentList.size();
                do {
                    Character next = generator.next();
                    if (!EncryptionHelper.squareContains(cipherReplacement, next) && !currentList.contains(next) && !next.equals('Ї')) {
                        currentList.add(next);
                        index++;
                    }
                } while (index != SIZE_HORIZONTAL);
                cipherReplacement.add(currentList);
            }
        }
        for (int i = cipherReplacement.size(); i < SIZE_VERTICAL; i++) {
            List<Character> otherList = new ArrayList<>();
            index = 0;
            do {
                Character next = generator.next();
                if (!EncryptionHelper.squareContains(cipherReplacement, next) && !next.equals('Ї')) {
                    otherList.add(next);
                    index++;
                }
            } while (index != SIZE_HORIZONTAL);
            cipherReplacement.add(otherList);
        }
        ConsoleHelper.printCipherReplacement(cipherReplacement);
        List<String> binoms = Arrays.asList(getText().replaceAll("..(?!$)", "$0 ").split(" "));
        if (binoms.get(binoms.size() - 1).length() == 1) {
            ArrayList<String> newBinoms = new ArrayList<>();
            for (String binom : binoms) {
                if (binom.equals(binoms.get(binoms.size() - 1))) {
                    newBinoms.add(binoms.get(binoms.size() - 1) + "Ї");
                } else {
                    newBinoms.add(binom);
                }
            }
            binoms = newBinoms;
        }
        ConsoleHelper.printBinoms(binoms);
        for (String s : binoms) {
            int[] newFirstIndex = null;
            int[] newSecondIndex = null;
            int[] firstIndex = EncryptionHelper.getIndex(cipherReplacement, s.replace("Ї", "І").charAt(0));
            int[] secondIndex = EncryptionHelper.getIndex(cipherReplacement, s.replace("Ї", "І").charAt(1));
            assert firstIndex != null;
            assert secondIndex != null;
            if (firstIndex[0] == secondIndex[0]) {
                if (firstIndex[1] != 0 && secondIndex[1] != 0) {
                    newFirstIndex = new int[] {firstIndex[0],  firstIndex[1] - 1};
                    newSecondIndex = new int[] {secondIndex[0],  secondIndex[1] - 1};
                } else if (firstIndex[1] != 7 && secondIndex[1] != 7) {
                    newFirstIndex = new int[] {firstIndex[0],  firstIndex[1] + 1};
                    newSecondIndex = new int[] {secondIndex[0],  secondIndex[1] + 1};
                }
            } else if (firstIndex[1] == secondIndex[1]) {
                if (firstIndex[0] != 0 && secondIndex[0] != 0) {
                    newFirstIndex = new int[] {firstIndex[0] - 1,  firstIndex[1]};
                    newSecondIndex = new int[] {secondIndex[0] - 1,  secondIndex[1]};
                } else if (firstIndex[0] != 3 && secondIndex[0] != 3) {
                    newFirstIndex = new int[] {firstIndex[0] + 1,  firstIndex[1]};
                    newSecondIndex = new int[] {secondIndex[0] + 1,  secondIndex[1]};
                }
            } else {
                newFirstIndex = new int[] {firstIndex[0], secondIndex[1]};
                newSecondIndex = new int[] {secondIndex[0], firstIndex[1]};
            }
            assert newFirstIndex != null;
            result.append(cipherReplacement.get(newFirstIndex[0]).get(newFirstIndex[1])).append(cipherReplacement.get(newSecondIndex[0]).get(newSecondIndex[1])).append(" ");
        }
        return result.toString();
    }


}
