package generator;

public abstract class Generator {

    public static String ALPHABET = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";

    private String text;

    private int index;

    Generator(String text) {
        this.text = text;
        this.index = 0;
    }

    public abstract Character next();

    void setIndex(int index) {
        this.index = index;
    }

    int getIndex() {
        return index;
    }

    int increaseIndex() {
        return index++;
    }

}
