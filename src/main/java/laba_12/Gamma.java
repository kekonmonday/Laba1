package laba_12;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Arrays;
import java.util.List;

public class Gamma {

    public static void main(String[] args) {
        new Gamma().execute("Sfdf", "fdsf", "dasd", "dddd");
    }

    public void execute(String text, String g1, String g2, String g3) {
        g1 = g1.substring(0, text.length());
        g2 = g2.substring(0, text.length());
        g3 = g3.substring(0, text.length());
        System.out.println("Текст = " + text);
        System.out.println("Гамма 1 = " + g1);
        System.out.println("Гамма 2 = " + g2);
        System.out.println("Гамма 3 = " + g3);
        List<String> tt = getStringToBinary(text).blockingGet();
        List<String> gg1 = getStringToBinary(g1).blockingGet();
        List<String> gg2 = getStringToBinary(g2).blockingGet();
        List<String> gg3 = getStringToBinary(g3).blockingGet();
        System.out.println();
        System.out.println("Текст: ");
        print(tt);
        System.out.println("Гами: ");
        print(gg1);
        print(gg2);
        print(gg3);
        List<String> xors = Observable.range(0, tt.size()).map(integer -> Integer.valueOf(tt.get(integer), 2)
                ^ Integer.valueOf(gg1.get(integer), 2)
                ^ Integer.valueOf(gg2.get(integer), 2)
                ^ Integer.valueOf(gg3.get(integer), 2))
                //.map(integer -> (char) integer.intValue())
                .map(Integer::toBinaryString)
                .toList()
                .blockingGet();
        System.out.println("Результат: ");
        print(xors);
        List<String> decode = Observable.range(0, xors.size()).map(integer -> Integer.valueOf(xors.get(integer), 2)
                ^ Integer.valueOf(gg2.get(integer), 2)
                ^ Integer.valueOf(gg1.get(integer), 2)
                ^ Integer.valueOf(gg3.get(integer), 2))
                //.map(integer -> (char) integer.intValue())
                .map(Integer::toBinaryString)
                .toList()
                .blockingGet();
        System.out.println("Декодування: ");
        print(decode);


        //List<Integer> t = Arrays.asList(Arrays.stream(text.split("")).map(s -> s.charAt(0)).toArray());
    }

    public Single<List<String>> getStringToBinary(String text) {
        return Observable.fromIterable(Arrays.asList(text.split(""))).map(s -> Integer.toBinaryString((int) s.charAt(0))).toList();
    }

    public void print(List list) {
        Observable.fromIterable(list).doOnNext(o -> System.out.print(o + "\t")).blockingSubscribe();
        System.out.println();
    }

}
