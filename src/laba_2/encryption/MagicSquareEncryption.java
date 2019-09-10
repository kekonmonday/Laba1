package laba_2.encryption;

import laba_2.helper.ConsoleHelper;
import laba_2.helper.EncryptionHelper;

public class MagicSquareEncryption extends Encryption {

    public static final String TAG = "Магічний квадрат";

    private static final int SIZE = 4;

    public MagicSquareEncryption(String text) {
        super(TAG, text, null);
    }

    @Override
    public String execute() {
        Integer[][] magicSquare = EncryptionHelper.createMagicSquare(SIZE);
        Character[][] result = new Character[magicSquare.length][magicSquare.length];
        ConsoleHelper.printSquare(magicSquare);
        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare[0].length; j++) {
                int element = magicSquare[i][j];
                if (element > getText().length()) {
                    result[i][j] = ' ';
                } else {
                    result[i][j] = getText().charAt(element - 1);
                }
            }
        }
        ConsoleHelper.printSquare(result);
        StringBuilder builder = new StringBuilder();
        for (Character[] characters : result) {
            for (Character character : characters) {
                builder.append(character);
            }
        }
        return builder.toString();
    }

}
