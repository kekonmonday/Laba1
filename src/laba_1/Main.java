package laba_1;

import laba_1.encryption.*;
import laba_1.helper.ConsoleHelper;

public class Main {

    public static void main(String[] args) {
        String result = new CesarEncryption("САМОЙЛЕНКО", "2").execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new LosungEncryption("САМОЙЛЕНКО", "ЯХТА").execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new PolibianSquareEncryption("САМОЙЛЕНКО").execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new TrisemuseSquareEncryption("САМОЙЛЕНКО", "ІНФОРМАЦІЯ").execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new PlayfairEncryption("САМОЙЛЕНКО", "ІНФОРМАЦІЯ").execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new OmophonesEncryption("САМОЙЛЕНКО").execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
        result = new VisionerEncryption("САМОЙЛЕНКО", "ЯХТА").execute();
        ConsoleHelper.printResultString();
        System.out.println(result);
        System.out.println(System.lineSeparator());
    }

}
