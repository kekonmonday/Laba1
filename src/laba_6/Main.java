package laba_6;


public class Main {

    public static void main(String... args) {
        System.out.println(BinaryEncryption.decimalToBinary(0.390625, 20));
        System.out.println("Прямой код");
        String result = BinaryEncryption.toBinary(110);
        System.out.println(result);
        System.out.println(System.lineSeparator());
        System.out.println("Обратный код");
        result = BinaryEncryption.toOnesComplememt(-111);
        System.out.println(result);
        System.out.println(System.lineSeparator());
        System.out.println("Дополнительный код");
        result = BinaryEncryption.toTwosComplememt(-112);
        System.out.println(result);
        System.out.println(System.lineSeparator());
        System.out.println("24 бітний код");
        result = BinaryEncryption.toFloatBits4(-110);
        System.out.println(result);
        System.out.println(System.lineSeparator());
        System.out.println("IEEE 754");
        result = BinaryEncryption.toFloatBits(-113);
        System.out.println(result);
        System.out.println(System.lineSeparator());

    }

}
