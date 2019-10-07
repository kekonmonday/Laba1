package laba_5;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public abstract class Encryption {

    private String name;

    private String text;

    Encryption(String name, String text) {
        this.name = name;
        this.text = text;
        ConsoleHelper.printEncryption(this);
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public abstract String execute();

}
