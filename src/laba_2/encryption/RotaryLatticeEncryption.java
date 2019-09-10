package laba_2.encryption;

import laba_2.generator.Generator;
import laba_2.generator.GeneratorFactory;
import laba_2.helper.ConsoleHelper;
import laba_2.helper.EncryptionHelper;

public class RotaryLatticeEncryption extends Encryption {

    public static final String TAG = "Шифр поворотної решітки";

    private static final int NEED_TO_ROTATE_TIMES = 4;

    public RotaryLatticeEncryption(String text) {
        super(TAG, text, null);
    }

    @Override
    public String execute() {
        boolean[][] lattice = EncryptionHelper.getLattice();
        Generator generator = GeneratorFactory.getGenerator(getText());
        Character[][] result = new Character[lattice.length][lattice[0].length];
        for (int i = 0; i < NEED_TO_ROTATE_TIMES; i++) {
            for (int j = 0; j < lattice.length; j++) {
                for (int k = 0; k < lattice[0].length; k++) {
                    if (lattice[j][k]) {
                        result[j][k] = generator.next();
                    }
                }
            }
            ConsoleHelper.printSquare(result);
            lattice = EncryptionHelper.rotateTable(lattice);
        }
        StringBuilder builder = new StringBuilder();
        for (Character[] characters : result) {
            for (Character character : characters) {
                builder.append(character == null ? "" : character);
            }
        }
        return builder.toString();
    }

}
