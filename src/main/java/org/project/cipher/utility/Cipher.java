package org.project.cipher.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Cipher {
    private static final Logger log = LoggerFactory.getLogger(Cipher.class);
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{};:',<>./?`~\\|\"0123456789";
    private final Map<Character, Integer> alphabetIndex;

    public Cipher() {
        this.alphabetIndex = new HashMap<Character, Integer>();

        for(int i = 0; i < ALPHABET.length(); ++i)
            alphabetIndex.put(ALPHABET.charAt(i), i);
    }

    public String encode(String word) {
        char[] encoded = new char[word.length()];

        int shift = 1;

        for(int i = 0; i < word.length(); i++) {
            if(SPECIAL_CHARACTERS.indexOf(word.charAt(i)) != -1) { // if character is a special character, don't encode or shift
                encoded[i] = word.charAt(i);
                continue;
            }

            encoded[i] = shiftCharacterEncode(word.charAt(i), shift);
            shift++;
        }

        return String.valueOf(encoded);
    }

    public String decode(String word) {
        char[] encoded = new char[word.length()];

        int shift = 1;

        for(int i = 0; i < word.length(); i++) {
            if(SPECIAL_CHARACTERS.indexOf(word.charAt(i)) != -1) {
                encoded[i] = word.charAt(i);
                continue;
            }

            encoded[i] = shiftCharacterDecode(word.charAt(i), shift);
            shift++;
        }

        return String.valueOf(encoded);
    }

    public char shiftCharacterEncode(char shiftedChar, int shift) {
        int index = this.alphabetIndex.get(Character.toLowerCase(shiftedChar)) + shift;
        while(index > 25)
            index -= 26;

        return shiftedChar < 91 ? Character.toUpperCase(ALPHABET.charAt(index)) : ALPHABET.charAt(index);
    }

    public char shiftCharacterDecode(char shiftedChar, int shift) {
        int index = this.alphabetIndex.get(Character.toLowerCase(shiftedChar)) - shift;
        while(index < 0)
            index += 26;

        return shiftedChar < 91 ? Character.toUpperCase(ALPHABET.charAt(index)) : ALPHABET.charAt(index);
    }

}
