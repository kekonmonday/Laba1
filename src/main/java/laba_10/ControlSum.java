package laba_10;

public class ControlSum {

    public void execute(int val) {
        System.out.println("Число = "+ val);
        String binary = Integer.toBinaryString(val);
        System.out.println("Binary = " + binary);
        int newVal = val << 4;
        String newBinary = Integer.toBinaryString(newVal);
        System.out.println("Binary' = " + newBinary);
        System.out.println(System.lineSeparator());
        String chastnoe = "";
        for (int i = 0; i < binary.length(); i++) {
            int divider = help(val, binary.length());
            System.out.println("val = " + Integer.toBinaryString(val));
            System.out.println("divider = " + Integer.toBinaryString(divider));
            if (divider != 0) {
                val ^= help(val, binary.length());
                chastnoe += "1";
            } else {
                chastnoe += "0";
            }
            if (i != binary.length() - 1) {
                val = val << 1;
            }
            System.out.println(Integer.toBinaryString(val));
            System.out.println(System.lineSeparator());
        }
        System.out.println("Частное = " + Integer.valueOf(chastnoe, 2) + ", binary = " + chastnoe);
        System.out.println("Остаток = " + val + ", binary = " + Integer.toBinaryString(val));
        StringBuilder newBinaryVal = new StringBuilder(Integer.toBinaryString(val));
        for (; newBinaryVal.length() < binary.length() - 1;) {
            newBinaryVal.insert(0, "0");
        }
        System.out.println("Результат = " + Integer.valueOf(binary + newBinaryVal.toString(), 2) + ", binary = " + (binary + newBinaryVal.toString()));

    }

    public int help(int i, int lenght) {
        String s = Integer.toBinaryString(i);
        if (s.length() == lenght && s.charAt(0) == '1') {
            return Integer.valueOf("10011", 2);
        } else {
            return 0;
        }
        /*StringBuilder s1 = new StringBuilder(s);
        for (; s1.length() < lenght;) {
            s1.insert(0, "0");
        }
        s = s1.toString();
        String newVal = "";
        for (int index = lenght - 1; index >= 0; index--) {
            if (index == 4 || index == 1 || index == 0) {
                newVal +=  s.charAt((lenght - 1) - index);
            } else {
                newVal += 0;
            }
        }
        return Integer.valueOf(newVal, 2);*/
    }

}
