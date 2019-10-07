package laba_5;

import java.util.List;

public class ConsoleHelper {

    public static void printEncryption(Encryption encryption) {
        String builder = System.lineSeparator() + System.lineSeparator() + System.lineSeparator() + encryption.getName() +
                System.lineSeparator() +
                "Текст: " +
                encryption.getText() +
                System.lineSeparator();
        System.out.println(builder);
    }

    public static void printResultString() {
        System.out.println();
        System.out.println("Результат:");
    }

    public static void printCipherReplacement(Object[][] cipherReplacement) {
        StringBuilder builder = new StringBuilder();
        builder.append("Шифрозамена:").append(System.lineSeparator());
        for (Object[] objects : cipherReplacement) {
            //builder.append("[");
            for (Object o : objects) {
                builder.append(o).append("\t");
                //builder.append(o).append(", ");
            }
            //builder.append("]").append(System.lineSeparator());
            builder.append(System.lineSeparator());
        }
        builder.append(System.lineSeparator());
        System.out.println(builder.toString());
    }

    public static void printCipherReplacement(List<Integer> integers) {
        StringBuilder builder = new StringBuilder();
        for (Integer objects : integers) {
            builder.append(objects).append("\t");
        }
        builder.append(System.lineSeparator());
        System.out.println(builder.toString());
    }

    public static void printBinaryCipherReplacement(List<String> integers) {
        StringBuilder builder = new StringBuilder();
        for (String objects : integers) {
            builder.append(objects).append("\t");
        }
        builder.append(System.lineSeparator());
        System.out.println(builder.toString());
    }

    public static void printSquare(List<List<String>> lists) {
        StringBuilder builder = new StringBuilder();
        for (List list : lists) {
            //builder.append("[");
            for (Object character : list) {
                builder.append(character);
                builder.append("\t");
                if (list.indexOf(character) != (list.size() - 1)) {
                    //builder.append(", ");

                }
            }
            builder//.append("]")
                    .append(System.lineSeparator());
        }
        System.out.println(builder.toString());
    }

}
