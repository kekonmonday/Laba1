package laba_3;

import laba_3.encryption.GammaEncryption;
import laba_3.encryption.XORGammaEncryption;
import laba_3.helper.ConsoleHelper;
import laba_3.helper.EncryptionHelper;

public class Main {

    private static final String WORD_TO_ENCRYPT = "SAMOILENKO";

    private static final String KEY_TO_ENCRYPT = "VLAD";

    public static void main(String... args) {
        GammaEncryption gammaEncryption = new GammaEncryption(WORD_TO_ENCRYPT.toLowerCase(), KEY_TO_ENCRYPT.toLowerCase(), EncryptionHelper.ALPHABET.length());
        String result = gammaEncryption.execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        XORGammaEncryption xorGammaEncryption = new XORGammaEncryption(WORD_TO_ENCRYPT.toLowerCase(), KEY_TO_ENCRYPT.toLowerCase());
        result = xorGammaEncryption.execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
    }

}
