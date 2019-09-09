package helper;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncryptionHelper {

    public static List<List<Character>> getSquare() {
        List<List<Character>> list = new ArrayList<>();
        list.add(Arrays.asList('А', 'Б', 'В', 'Г', 'Ґ', 'Д'));
        list.add(Arrays.asList('Е', 'Є', 'Ж', 'З', 'И', 'І'));
        list.add(Arrays.asList('Ї', 'Й', 'К', 'Л', 'М', 'Н'));
        list.add(Arrays.asList('О', 'П', 'Р', 'С', 'Т', 'У'));
        list.add(Arrays.asList('Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ'));
        list.add(Arrays.asList('Ь', 'Ю', 'Я', null, null, null));
        return list;
    }

    public static boolean squareContains(List<List> list, @Nullable Object character) {
        for (List characters : list) {
            for (Object c : characters) {
                if (character.equals(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public static int[] getIndex(List<List> cipherReplacement, char charA) {
        for (int i = 0; i < cipherReplacement.size(); i++) {
            for (int j = 0; j < cipherReplacement.get(0).size(); j++) {
                if (cipherReplacement.get(i).get(j).equals(charA)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
