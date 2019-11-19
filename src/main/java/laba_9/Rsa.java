package laba_9;

import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;

public class Rsa {

    public void execute(String text) {
        System.out.println("Текст = " + text);
        BigInteger d = new BigInteger("1266711491819178437", 10);
        BigInteger n = new BigInteger("8b86e91fc7cc883b96f8948eee8fb2bb", 16);
        BigInteger e = new BigInteger("103927237252362863277916442357768249901", 10);
        byte[] hash = DigestUtils.md5(text);
        BigInteger hashIntValue = bytesToHex(hash);
        System.out.println("А генерирует hash с полученного сообщения и переводит в форму числа = " + hashIntValue.toString());
        BigInteger s = hashIntValue.modPow(d, n);
        System.out.println("А отправляет Б полученное сообщение =  " + text + " и электронную подпись s = " + s);
        System.out.println("Б генерирует hash с полученного сообщения и переводит в форму числа = " + hashIntValue.toString());
        System.out.println("Б генерирует hash1 = " + s.modPow(e, n).toString() + " и сверяет с hash = " + hashIntValue.toString().equals(s.modPow(e, n).toString()));
    }

    public static void main(String... args) {
        new Rsa().execute("Compile it");
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static BigInteger bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new BigInteger(new String(hexChars), 16);
    }

}
