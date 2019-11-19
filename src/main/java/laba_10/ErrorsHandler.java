package laba_10;

import org.apache.commons.lang3.StringUtils;
import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ErrorsHandler {

    public void execute(String text) {
        System.out.println("Текст = " + text);
        SimpleMatrix vector = new SimpleMatrix(1, 15);
        SimpleMatrix matrix = new SimpleMatrix(4, 15);
        /*for (int i = 0; i < 15; i++) {
            if (i == 0 || i == 1 || i == 3 || i == 7) {
                vector.set(i, 0);
            } else {
                vector.set(i, new Random().nextInt(2));
            }
        }*/
        vector.set(0, 0);
        vector.set(1, 0);
        vector.set(2, Integer.valueOf(text.split("")[0]));
        vector.set(3, 0);
        vector.set(4, Integer.valueOf(text.split("")[1]));
        vector.set(5, Integer.valueOf(text.split("")[2]));
        vector.set(6, Integer.valueOf(text.split("")[3]));
        vector.set(7, 0);
        vector.set(8, Integer.valueOf(text.split("")[4]));
        vector.set(9, Integer.valueOf(text.split("")[5]));
        vector.set(10, Integer.valueOf(text.split("")[6]));
        vector.set(11, Integer.valueOf(text.split("")[7]));
        vector.set(12, Integer.valueOf(text.split("")[8]));
        vector.set(13, Integer.valueOf(text.split("")[9]));
        vector.set(14, Integer.valueOf(text.split("")[10]));
        for (int i = 0; i < 15; i++) {
            String binary = StringUtils.reverse(Integer.toBinaryString(i + 1));
            int j = 0;
            System.out.println(binary);
            for (; j < binary.length(); j++) {
                System.out.println("i = " + i + ", j = " + j);
                matrix.set(j, i, binary.charAt(j) == '0' ? 0 : 1);
            }
            for (; j < 4; j++) {
                matrix.set(j, i, 0);
            }
        }
        System.out.println();
        vector.print();
        System.out.println();
        matrix.print();
        int pb = 0;
        for (int i = 0; i < 15; i++) {
            pb += vector.get(i);
        }
        pb = pb % 2;
        int r1 = ((int) vector.mult(matrix.rows(0, 1).transpose()).get(0)) % 2;
        int r2 = ((int) vector.mult(matrix.rows(1, 2).transpose()).get(0)) % 2;
        int r3 = ((int) vector.mult(matrix.rows(2, 3).transpose()).get(0)) % 2;
        int r4 = ((int) vector.mult(matrix.rows(3, 4).transpose()).get(0)) % 2;
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);
        vector.set(0, r1);
        vector.set(1, r2);
        vector.set(3, r3);
        vector.set(7, r4);
        int pb1 = 0;
        for (int i = 0; i < 15; i++) {
            pb1 += vector.get(i);
        }
        pb1 = pb1 % 2;
        System.out.println("pb = " + pb);
        System.out.println("pb1 = " + pb1);
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            s.add(((int) vector.mult(matrix.rows(i, i + 1).transpose()).get(0)) % 2);
        }
        System.out.println("s = " + s.toString());
        int count1 = 0;
        for (Integer i :
                s
        ) {
            count1 += i;

        }
        String S = s.toString().replace("[", "").replace(" ", "").replace(",", "").replace("]", "");
        if (pb == pb1 && count1 == 0) {
            System.out.println("Ошибок нет");
        } else if (pb != pb1 && count1 != 0) {
            System.out.println("Одиночная исправимая ошибка, i = " + Integer.valueOf(S, 2));
        } else if (pb1 == pb) {
            System.out.println("Двойная неисправимая ошибка");
        } else if (pb != pb1) {
            System.out.println("Тройная неисправимая ошибка");
        }

    }

}
