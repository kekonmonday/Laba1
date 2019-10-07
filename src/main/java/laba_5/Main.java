package laba_5;

public class Main {

    private static final String WORD = "fish";

    public static void main(String[] args) {
        new RsaEncryption(WORD.toLowerCase()).execute();
        new BagEncryption(WORD.toLowerCase()).execute();
        new AlGamalEncryption(WORD.toLowerCase()).execute();

    }

}
