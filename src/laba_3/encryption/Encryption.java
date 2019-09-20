package laba_3.encryption;

import laba_3.helper.ConsoleHelper;

public abstract class Encryption {

    private String name;

    private String text;

    private String key;

    Encryption(String name, String text, String key) {
        this.name = name;
        this.text = text;
        this.key = key;
        ConsoleHelper.printEncryption(this);
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public abstract String execute();

}
