package laba_10;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;

public class EvenCheck {

     public void execute(String text) {
        String binary = new BigInteger(text.getBytes()).toString(2);
        int count1 = StringUtils.countMatches(binary, '1');
        System.out.println("Четный паритетный бит = " + ((count1 % 2 != 0) ? '1' : '0'));
        System.out.println("Нечетный паритетный бит = " + ((count1 % 2 == 0) ? '1' : '0'));
     }

}
