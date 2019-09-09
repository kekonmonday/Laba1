package laba_1.generator;

public class GeneratorFactory {

    public static Generator getGeneratorWithShift(String text, int shift) {
        return new Generator(text) {

            boolean needToShift = true;

            @Override
            public Character next() {
                if (needToShift) {
                    for (int i = 0; i < shift; i++) {
                        increaseIndex();
                    }
                    needToShift = false;
                }
                Character s = text.charAt(increaseIndex());
                if (getIndex() == text.length()) {
                    setIndex(0);
                }
                return s;
            }
        };
    }

}
