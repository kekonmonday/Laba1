package laba_3.helper;

import laba_3.encryption.Encryption;

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
        System.out.println();
        System.out.println("Результат:");
    }

    public static void printCipherReplacement(Object[] cipherReplacement) {
        System.out.println();
        StringBuilder builder = new StringBuilder();
        for (Object o : cipherReplacement) {
            builder.append(o).append("\t");
        }
        System.out.println(builder.toString());
    }

    public static void printBinaryCipherReplacement(Object[] cipherReplacement) {
        System.out.println();
        StringBuilder builder = new StringBuilder();
        for (Object o : cipherReplacement) {
            if (o instanceof Integer) {
                Integer character = (Integer) o;
                StringBuilder binary = new StringBuilder(Integer.toBinaryString(character));
                while (binary.length() != 7) {
                    binary.insert(0, 0);
                }
                builder.append(binary.toString()).append("\t");
            }
        }
        builder.append(System.lineSeparator());
        for (Object o : cipherReplacement) {
            builder.append(o).append("\t");
        }
        System.out.println(builder.toString());
    }

    public static void printModule(int module) {
        System.out.println(new StringBuilder().append("Модуль: ").append(module).toString());
    }
}
