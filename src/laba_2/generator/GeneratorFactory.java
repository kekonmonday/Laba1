package laba_2.generator;

public class GeneratorFactory {

    public static Generator getGenerator(String text) {
        return  new Generator(text) {

            @Override
            public Character next() {
                Character character = null;
                if (getIndex() < text.length()) {
                    character = text.charAt(increaseIndex());
                }
                return character;
            }

        };
    }

}
