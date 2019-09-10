package laba_2.helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class EncryptionHelper {

    public static final String SPLIT_BY = " ";

    public static String[] splitBySize(String text, int size) {
        List<String> parts = new ArrayList<>();
        int length = text.length();
        for (int i = 0; i < length; i += size) {
            parts.add(text.substring(i, Math.min(length, i + size)));
        }
        return parts.toArray(new String[0]);
    }

    public static List<List> createTable(String text, int size) {
        List<List> table = new LinkedList<>();
        String[] texts = EncryptionHelper.splitBySize(text, 5);
        for (String t : texts) {
            ArrayList currentList = new ArrayList();
            StringBuilder newText = new StringBuilder(t);
            if (t.length() != size) {
                for (int i = t.length(); i < size; i++) {
                    newText.append(" ");
                }
            }
            for (Character character : newText.toString().toCharArray()) {
                currentList.add(character);
            }
            table.add(currentList);
        }
        return table;
    }

    public static Integer[][] createMagicSquare(int size) {
        Integer[][] magicSq = new Integer[size][size];
        int row = 0;
        int column = size / 2;
        int lastRow = row;
        int lastColumn = column;
        int matrixSize = size * size;
        magicSq[row][column] = 1;
        for (int k = 2; k < matrixSize + 1; k++) {
            if (row - 1 < 0) {
                row = size - 1;
            } else {
                row--;
            }
            if (column + 1 == size) {
                column = 0;
            } else {
                column++;
            }
            if (magicSq[row][column] == null) {
                magicSq[row][column] = k;
            } else {
                row = lastRow;
                column = lastColumn;
                if (row + 1 == size) {
                    row = 0;
                } else {
                    row++;
                }
                magicSq[row][column] = k;
            }
            lastRow = row;
            lastColumn = column;
        }
        return magicSq;
    }

    public static List<List> verticalSort(List<List> table, String[] keys) {
        TreeMap<Integer, List<Character>> result = new TreeMap<>();
        for (String character : keys) {
            int k = Integer.valueOf(character) - 1;
            ArrayList arrayList = new ArrayList();
            for (List list : table) {
                arrayList.add(list.get(result.size()));
            }
            result.put(k, arrayList);
        }
        return transpose(new ArrayList<>(result.values()));
    }

    private static List<List> transpose(List<List> table) {
        List<List> ret = new ArrayList<>();
        final int N = table.get(0).size();
        for (int i = 0; i < N; i++) {
            List col = new ArrayList();
            for (List row : table) {
                col.add(row.get(i));
            }
            ret.add(col);
        }
        return ret;
    }


    public static List<List> horizontalSort(List<List> table, String[] keys) {
        TreeMap<Integer, List<Character>> result = new TreeMap<>();
        for (String character : keys) {
            int k = Integer.valueOf(character) - 1;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < table.get(0).size(); i++) {
                arrayList.add(table.get(result.size()).get(i));
            }
            result.put(k, arrayList);
        }
        return new ArrayList<>(result.values());
    }

    public static boolean[][] rotateTable(boolean[][] table) {
        int totalRowsOfRotatedTable = table[0].length;
        int totalColsOfRotatedTable = table.length;
        boolean[][] rotatedTable = new boolean[totalRowsOfRotatedTable][totalColsOfRotatedTable];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                rotatedTable[j][(totalColsOfRotatedTable - 1) - i] = table[i][j];
            }
        }
        return rotatedTable;
    }

    public static boolean[][] getLattice() {
        return new boolean[][]{
                {false, true, false, false},
                {true, false, false, false},
                {false, false, true, false},
                {false, false, false, true}
        };
    }
}
