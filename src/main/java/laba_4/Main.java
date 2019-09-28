package laba_4;

public class Main {

    public static void main(String... strings) {
        AdfgvxEncryption adfgvxEncryption = new AdfgvxEncryption("Самойленко", "bca");
        String result = adfgvxEncryption.execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
    }
}
