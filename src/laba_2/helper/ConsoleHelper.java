package laba_2.helper;

import laba_2.encryption.Encryption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ConsoleHelper {

    public static void printEncryption(Encryption encryption) {
        StringBuilder builder = new StringBuilder();
        builder.append(encryption.getName())
                .append(System.lineSeparator())
                .append("Текст: ")
                .append(encryption.getText())
                .append(System.lineSeparator())
                .append("Ключ: ")
                .append(encryption.getKey())
                .append(System.lineSeparator());
        System.out.println(builder.toString());
    }

    public static void printResultString() {
        System.out.println("Результат:");
    }

    public static void printCipherReplacement(Object[] cipherReplacement) {
        StringBuilder builder = new StringBuilder();
        builder.append("Шифрозамена:")
                .append(System.lineSeparator())
                .append(Arrays.toString(cipherReplacement))
                .append(System.lineSeparator());
        System.out.println(builder.toString());
    }

    public static void printCipherReplacement(Object[][] cipherReplacement) {
        StringBuilder builder = new StringBuilder();
        builder.append("Шифрозамена:")
                .append(System.lineSeparator())
                .append(Arrays.toString(cipherReplacement))
                .append(System.lineSeparator());
        System.out.println(builder.toString());
    }

    public static void printCipherReplacement(ArrayList cipherReplacement) {
        printCipherReplacement(cipherReplacement.toArray());
    }

    public static void printCipherReplacement(List<List> cipherReplacement) {
        System.out.println("Шифрозамена:");
        printSquare(cipherReplacement);
    }

    public static void printSquare(List<List> lists) {
        StringBuilder builder = new StringBuilder();
        for (List list : lists) {
            builder.append("[");
            for (Object character : list) {
                builder.append(character);
                if (list.indexOf(character) != (list.size() - 1)) {
                    builder.append(", ");
                }
            }
            builder.append("]")
                    .append(System.lineSeparator());
        }
        System.out.println(builder.toString());
    }

    public static void printSquare(Object[][] lists) {
        StringBuilder builder = new StringBuilder();
        for (Object[] list : lists) {
            builder.append("[");
            for (Object character : list) {
                builder.append(character)
                        .append(", ");
            }
            builder.append("]")
                    .append(System.lineSeparator());
        }
        System.out.println(builder.toString());
    }

    public static void printCipherReplacement(Map map) {
        StringBuilder builder = new StringBuilder();
        builder.append("Шифрозамена: ")
                .append(map)
                .append(System.lineSeparator());
        System.out.println(builder.toString());
    }

}
