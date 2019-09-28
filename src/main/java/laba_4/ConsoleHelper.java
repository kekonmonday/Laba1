package laba_4;

import java.util.List;

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

    public static void printCipherReplacement(Object[][] cipherReplacement) {
        StringBuilder builder = new StringBuilder();
        builder.append("Шифрозамена:").append(System.lineSeparator());
        for (Object[] objects : cipherReplacement) {
            builder.append("[");
            for (Object o : objects) {
                builder.append(o).append(", ");
            }
            builder.append("]").append(System.lineSeparator());
        }
        builder.append(System.lineSeparator());
        System.out.println(builder.toString());
    }

    public static void printSquare(List<List<String>> lists) {
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

}
