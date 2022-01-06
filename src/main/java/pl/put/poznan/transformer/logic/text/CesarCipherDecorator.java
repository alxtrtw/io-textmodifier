package pl.put.poznan.transformer.logic.text;

import io.vavr.collection.HashMap;

import java.util.Arrays;

/**
 * Klasa reprezentująca dekorator odwracający znaki w tekście,
 * bez zmiany wielkości liter według kolejności występowania.
 */
public class CesarCipherDecorator extends TransformerDecorator {
    public CesarCipherDecorator(Transformer transformer) {
        super(transformer);
    }

    int alphabetLen = indexToAlphabet.length();

    private char shiftChar(char letter, int shift, String direction){

        boolean isupper = Character.isUpperCase(letter);
        char lowLetter = Character.toLowerCase(letter);

        if (alphabetToIndex.keySet().contains(lowLetter)) {
            int currentIndex = alphabetToIndex.get(lowLetter).get();
            int shiftedIndex;
            if (direction.equals("góra")){
                shiftedIndex = currentIndex+shift;
            } else {
                shiftedIndex = currentIndex-shift;
            }
            int newIndex = Math.floorMod(shiftedIndex, alphabetLen);

            char newLetter = indexToAlphabet.get(newIndex).get();
            if (isupper){
                return Character.toUpperCase(newLetter);
            }else{
                return newLetter;
            }

        }else{
            return letter;
        }
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        String[] words = text.split(" ");
        String direction = words[0].toLowerCase();
        assert (direction.equals("góra") || direction.equals("dół"));
        int shift = Integer.parseInt(words[1])%alphabetLen;
        String encodedText = String.join(" ", Arrays.copyOfRange(words, 2, words.length));

        String decodedText = "";

        for (int i = 0; i < encodedText.length(); i++){
            decodedText = decodedText + shiftChar(encodedText.charAt(i), shift, direction);
        }

        return decodedText;
    }

    private static final HashMap<Integer, Character> indexToAlphabet = HashMap
            .of(0, 'a')
            .put(1, 'ą')
            .put(2, 'b')
            .put(3, 'c')
            .put(4, 'ć')
            .put(5, 'd')
            .put(6, 'e')
            .put(7, 'ę')
            .put(8, 'f')
            .put(9, 'g')
            .put(10, 'h')
            .put(11, 'i')
            .put(12, 'j')
            .put(13, 'k')
            .put(14, 'l')
            .put(15, 'ł')
            .put(16, 'm')
            .put(17, 'n')
            .put(18, 'ń')
            .put(19, 'o')
            .put(20, 'ó')
            .put(21, 'p')
            .put(22, 'q')
            .put(23, 'r')
            .put(24, 's')
            .put(25, 'ś')
            .put(26, 't')
            .put(27, 'u')
            .put(28, 'v')
            .put(29, 'w')
            .put(30, 'x')
            .put(31, 'y')
            .put(32, 'z')
            .put(33, 'ź');

    private static final HashMap<Character, Integer> alphabetToIndex = HashMap
            .of('a', 0)
            .put('ą', 1)
            .put('b', 2)
            .put('c', 3)
            .put('ć', 4)
            .put('d', 5)
            .put('e', 6)
            .put('ę', 7)
            .put('f', 8)
            .put('g', 9)
            .put('h', 10)
            .put('i', 11)
            .put('j', 12)
            .put('k', 13)
            .put('l', 14)
            .put('ł', 15)
            .put('m', 16)
            .put('n', 17)
            .put('ń', 18)
            .put('o', 19)
            .put('ó', 20)
            .put('p', 21)
            .put('q', 22)
            .put('r', 23)
            .put('s', 24)
            .put('ś', 25)
            .put('t', 26)
            .put('u', 27)
            .put('v', 28)
            .put('w', 29)
            .put('x', 30)
            .put('y', 31)
            .put('z', 32)
            .put('ź', 33);
}

