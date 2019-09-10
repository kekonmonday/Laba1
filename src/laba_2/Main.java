package laba_2;

import laba_2.encryption.*;
import laba_2.helper.ConsoleHelper;
import laba_2.helper.EncryptionHelper;

import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

    private static final String WORD_TO_ENCRYPT_1 = "САМОЙЛЕНКО";

    private static final String WORD_TO_ENCRYPT_2 = "САМОЙЛЕНКО ВЛАДИСЛАВ";

    private static final String WORD_TO_ENCRYPT_3 = "САМОЙЛЕНКОВЛАДИСЛАВ";

    private static final String WORD_TO_ENCRYPT_4 = "САМОЙЛЕНКО ВЛАД";

    public static void main(String[] args) {
        String result = new SimpleSinglePermutationEncryption(WORD_TO_ENCRYPT_1, "2" + EncryptionHelper.SPLIT_BY + "3" + EncryptionHelper.SPLIT_BY + "10"
                + EncryptionHelper.SPLIT_BY + "8" + EncryptionHelper.SPLIT_BY + "6" + EncryptionHelper.SPLIT_BY + "7" + EncryptionHelper.SPLIT_BY + "1"
                + EncryptionHelper.SPLIT_BY + "9" + EncryptionHelper.SPLIT_BY + "5" + EncryptionHelper.SPLIT_BY + "4").execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new BlockSinglePermutationEncryption(WORD_TO_ENCRYPT_1, "2" + EncryptionHelper.SPLIT_BY + "1").execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new TableRoutePermutationEncryption(WORD_TO_ENCRYPT_2).execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new VerticalPermutationEncryption(WORD_TO_ENCRYPT_3, "1" + EncryptionHelper.SPLIT_BY + "5" + EncryptionHelper.SPLIT_BY + "3"
                + EncryptionHelper.SPLIT_BY + "2" + EncryptionHelper.SPLIT_BY + "4").execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new RotaryLatticeEncryption(WORD_TO_ENCRYPT_4).execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new MagicSquareEncryption(WORD_TO_ENCRYPT_4).execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new DoublePermutationEncryption(WORD_TO_ENCRYPT_3, "2" + EncryptionHelper.SPLIT_BY + "3" + EncryptionHelper.SPLIT_BY + "1" + EncryptionHelper.SPLIT_BY + "4",
                "3" + EncryptionHelper.SPLIT_BY + "4" + EncryptionHelper.SPLIT_BY + "1" + EncryptionHelper.SPLIT_BY + "2" + EncryptionHelper.SPLIT_BY + "5").execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
    }

}
