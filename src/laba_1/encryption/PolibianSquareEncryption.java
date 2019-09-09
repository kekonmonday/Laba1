package laba_1.encryption;

import laba_1.helper.EncryptionHelper;

import java.util.List;

public class PolibianSquareEncryption extends Encryption {

    private static final String TAG = "Шифр полібіанського квадрату";

    public PolibianSquareEncryption(String text) {
        super(TAG, text, null);
    }

    @Override
    public String execute() {
        StringBuilder result = new StringBuilder();
        List<List<Character>> square = EncryptionHelper.getSquare();
        for (Character character : getText().toCharArray()) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    Character squareCharacter = square.get(i).get(j);
                    if (character.equals(squareCharacter)) {
                        if (i == 5 || square.get(i + 1).get(j) == null) {
                            result.append(square.get(0).get(j));
                        } else {
                            result.append(square.get(i + 1).get(j));
                        }
                    }
                }
            }
        }
        return result.toString();
    }

}
