package laba_4;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class EncryptionHelper {

    @Nullable
    public static Indexes getIndexes(Character[][] table, char charA) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] != null && table[i][j] == charA) {
                    return new Indexes(i ,j);
                }
            }
        }
        return null;
    }

    public static List<String> splitBySize(String text, int size) {
        List<String> parts = new ArrayList<>();
        int length = text.length();
        for (int i = 0; i < length; i += size) {
            parts.add(text.substring(i, Math.min(length, i + size)));
        }
        return parts;
    }

    public static List<List<String>> verticalSort(List<List<String>> table, String[] keys) {
        TreeMap<String, List<String>> result = new TreeMap<>();
        for (String character : keys) {
            ArrayList arrayList = new ArrayList();
            for (List list : table) {
                arrayList.add(list.get(result.size()));
            }
            if (result.containsKey(character)) {
                character = character + new Random().nextInt(1000);
            }
            result.put(character, arrayList);
        }
        return transpose(new ArrayList<>(result.values()));
    }

    public static List<List<String>> transpose(List<List<String>> table) {
        List<List<String>> ret = new ArrayList<>();
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

}
