package laba_6;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class BinaryEncryption {

    @NotNull
    public static String toBinary(int i) {
        return Integer.toBinaryString(i);
    }

    @NotNull
    public static String toOnesComplememt(int i) {
        String binary = Integer.toUnsignedString(Math.abs(i), 2);
        StringBuilder ones = new StringBuilder();
        for (int index = 0; index < binary.length(); index++) {
            ones.append(flip(binary.charAt(index)));
        }
        return i < 0 ? "1" + ones.toString() : ones.toString();
    }

    public static String toTwosComplememt(int i) {
        if (i < 0) {
            String binary = toOnesComplememt(i);
            String twos = binary;
            int index;
            for (index = binary.length() - 1; index >= 0; index--) {
                if (binary.charAt(index) == '1') {
                    twos = twos.substring(0, index) + '0' + twos.substring(index + 1);
                } else {
                    twos = twos.substring(0, index) + '1' + twos.substring(index + 1);
                    break;
                }
            }
            if (index == -1) {
                twos = '1' + twos;
            }
            return twos;
        } else {
            return toBinary(i);
        }

    }

    @NotNull
    public static String toFloatBits(float f) {
        int i = Float.floatToIntBits(f);
        return Integer.toBinaryString(i);
    }

    @NotNull
    public static String toFloatBits4(float f) {
        int toSearch = Math.abs((int) f);
        int pow = 0;
        while (toSearch > 0){
            toSearch >>= 1;
            pow++;
        }
        pow--;
        int exp = (int) Math.pow(2, pow);
        double M =  Math.abs(f) / exp;
        String mantissa = getMantissa(M - 1, 15);
        StringBuilder powStr = new StringBuilder(Integer.toBinaryString(pow));
        while (powStr.length() != 7) {
            powStr.insert(0, 0);
        }
        return (f > 0 ? 0 : 1) + powStr.toString() + 0 + mantissa;
    }

    @NotNull
    public static String getMantissa(double num, int k_prec) {
        StringBuilder binary = new StringBuilder();
        int Integral = (int) num;
        double fractional = num - Integral;
        while (k_prec-- > 0) {
            fractional *= 2;
            int fract_bit = (int) fractional;
            if (fract_bit == 1) {
                fractional -= fract_bit;
                binary.append((char) (1 + '0'));
            } else {
                binary.append((char) (0 + '0'));
            }
        }
        return binary.toString();
    }



    @NotNull
    public static String decimalToBinary(double num, int k_prec) {
        StringBuilder binary = new StringBuilder();
        int Integral = (int) num;
        double fractional = num - Integral;
        while (Integral > 0) {
            int rem = Integral % 2;
            binary.append((char) (rem + '0'));
            Integral /= 2;
        }
        binary = new StringBuilder(reverse(binary.toString()));
        binary.append('.');
        while (k_prec-- > 0) {
            fractional *= 2;
            int fract_bit = (int) fractional;
            if (fract_bit == 1) {
                fractional -= fract_bit;
                binary.append((char) (1 + '0'));
            } else {
                binary.append((char) (0 + '0'));
            }
        }
        return binary.toString();
    }

    @NotNull
    private static String reverse(@NotNull String input) {
        char[] temparray = input.toCharArray();
        int left, right = 0;
        right = temparray.length - 1;
        for (left = 0; left < right; left++, right--) {
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }
        return String.valueOf(temparray);
    }

    @Contract(pure = true)
    private static char flip(char c) {
        return (c == '0') ? '1' : '0';
    }
}


