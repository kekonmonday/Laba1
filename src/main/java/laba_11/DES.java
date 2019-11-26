package laba_11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DES {

    Map<Integer, int[][]> s = new HashMap<>();

    int[] pc1 = new int[]{
            57, 49, 41, 33, 25, 17, 9,
            1, 58, 50, 42, 34, 26, 18,
            10, 2, 59, 51, 43, 35, 27,
            19, 11, 3, 60, 52, 44, 36,
            63, 55, 47, 39, 31, 23, 15,
            7, 62, 54, 46, 38, 30, 22,
            14, 6, 61, 53, 45, 37, 29,
            21, 13, 5, 28, 20, 12, 4
    };

    int[] iterations = new int[]{
            1,
            1,
            2,
            2,
            2,
            2,
            2,
            2,
            1,
            2,
            2,
            2,
            2,
            2,
            2,
            1
    };

    int[] k = new int[]{
            14, 17, 11, 24, 1, 5,
            3, 28, 15, 6, 21, 10,
            23, 19, 12, 4, 26, 8,
            16, 7, 27, 20, 13, 2,
            41, 52, 31, 37, 47, 55,
            30, 40, 51, 45, 33, 48,
            44, 49, 39, 56, 34, 53,
            46, 42, 50, 36, 29, 32
    };

    int[] ip = new int[]{
            58, 50, 42, 34, 26, 18, 10, 2,
            60, 52, 44, 36, 28, 20, 12, 4,
            62, 54, 46, 38, 30, 22, 14, 6,
            64, 56, 48, 40, 32, 24, 16, 8,
            57, 49, 41, 33, 25, 17, 9, 1,
            59, 51, 43, 35, 27, 19, 11, 3,
            61, 53, 45, 37, 29, 21, 13, 5,
            63, 55, 47, 39, 31, 23, 15, 7
    };

    int[] ef = new int[]{
            32, 1, 2, 3, 4, 5,
            4, 5, 6, 7, 8, 9,
            8, 9, 10, 11, 12, 13,
            12, 13, 14, 15, 16, 17,
            16, 17, 18, 19, 20, 21,
            20, 21, 22, 23, 24, 25,
            24, 25, 26, 27, 28, 29,
            28, 29, 30, 31, 32, 1
    };

    int[] p = new int[]{
            16, 7, 20, 21,
            29, 12, 28, 17,
            1, 15, 23, 26,
            5, 18, 31, 10,
            2, 8, 24, 14,
            32, 27, 3, 9,
            19, 13, 30, 6,
            22, 11, 4, 25
    };

    int[] ip11 = new int[]{
            40, 8, 48, 16, 56, 24, 64, 32,
            39, 7, 47, 15, 55, 23, 63, 31,
            38, 6, 46, 14, 54, 22, 62, 30,
            37, 5, 45, 13, 53, 21, 61, 29,
            36, 4, 44, 12, 52, 20, 60, 28,
            35, 3, 43, 11, 51, 19, 59, 27,
            34, 2, 42, 10, 50, 18, 58, 26,
            33, 1, 41, 9, 49, 17, 57, 25
    };

    public DES() {
        s.put(0, new int[][]{
                {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13},
        });
        s.put(1, new int[][]{
                {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9},
        });
        s.put(2, new int[][]{
                {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
        });
        s.put(3, new int[][]{
                {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
        });
        s.put(4, new int[][]{
                {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
        });
        s.put(5, new int[][]{
                {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13},
        });
        s.put(6, new int[][]{
                {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12},
        });
        s.put(7, new int[][]{
                {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11},
        });
    }

    public void execute() {
        String text = "1111 0001 0010 1111 0100 0101 0110 0111 1000 1111 1010 1011 1100 1101 1110 0000".replace(" ", "");
        String key = "11010011 00110100 01010111 01111001 10011011 11111111 11011111 11110001".replace(" ", "");
        System.out.println(text);
        System.out.println("key = " + key);
        String pc1text = getReplacement(key, pc1);
        /*for (Integer i : pc1) {
            pc1text += text.charAt(i - 1);
        }*/
        System.out.println("pc1 = " + pc1text);
        String c0 = pc1text.substring(0, pc1text.length() / 2);
        System.out.println("c0= " + c0);
        String d0 = pc1text.substring(pc1text.length() / 2, pc1text.length());
        System.out.println("d0= " + d0);
        List<String> c = new ArrayList<>();
        List<String> d = new ArrayList<>();
        c.add(c0);
        d.add(d0);
        for (int i = 0; i < iterations.length; i++) {
            String oldC = c.get(i);
            c.add(oldC.substring(iterations[i]) + oldC.substring(0, iterations[i]));
            System.out.println("c" + (i + 1) + "= " + c.get(i + 1));
            String oldD = d.get(i);
            d.add(oldD.substring(iterations[i]) + oldD.substring(0, iterations[i]));
            System.out.println("d" + (i + 1) + "= " + d.get(i + 1));
        }
        List<String> ks = new ArrayList<>();
        for (int i = 1; i < c.size(); i++) {
            String ki = getReplacement(c.get(i) + d.get(i), k);
            ks.add(ki);
            System.out.println("k" + i + "= " + ki);
        }
        String ip = getReplacement(text, this.ip);
        List<String> l = new ArrayList<>();
        String l0 = ip.substring(0, ip.length() / 2);
        System.out.println("l0= " + l0);
        l.add(l0);
        List<String> r = new ArrayList<>();
        String r0 = ip.substring(ip.length() / 2);
        System.out.println("r0= " + r0);
        r.add(r0);
        for (int i = 0; i < ks.size(); i++) {
            String ll = r.get(i);
            System.out.println("l" + (i + 1) + "= " + ll);
            l.add(ll);
            String rr = norm(new BigInteger(l.get(i), 2).xor(f(r.get(i), ks.get(i))).toString(2), 32);
            System.out.println("r" + (i + 1) + "= " + rr);
            r.add(rr);
        }
        String r16l16 = r.get(16) + l.get(16);
        String cString = getReplacement(r16l16, ip11);
        System.out.println("c = " + new BigInteger(cString, 2).toString(16));
    }

    private BigInteger f(String r, String k) {
        String er = getReplacement(r, ef);
        String xor1 = norm(new BigInteger(k, 2).xor(new BigInteger(er, 2)).toString(2), 48);
        List<String> b = new ArrayList<>();
        for (int i = 0; i < 48; i += 6) {
            b.add(xor1.substring(i, i + 6));
        }
        String s = "";
        for (int i = 0; i < b.size(); i++) {
            s += s(b.get(i), i);
        }
        return new BigInteger(getReplacement(s, p), 2);
    }

    public String s(String b, int it) {
        int[][] s = this.s.get(it);
        String[] splitB = b.split("");
        String ii = splitB[0] + splitB[5];
        String jj = splitB[1] + splitB[2] + splitB[3] + splitB[4];
        int i = Integer.valueOf(ii, 2);
        int j = Integer.valueOf(jj, 2);
        int finded = s[i][j];
        return norm(Integer.toBinaryString(finded), 4);
    }

    public String norm(String s, int count) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (; stringBuilder.length() != count; ) {
            stringBuilder.insert(0, '0');
        }
        return stringBuilder.toString();
    }

    public String getReplacement(String text, int[] pc) {
        String replacement = "";
        for (Integer i : pc) {
            replacement += text.charAt(i - 1);
        }
        return replacement;
    }

    public static void main(String[] args) {
        new DES().execute();
    }
}
