package org.project.cipher.utility;

import java.util.HashMap;
import java.util.Map;

public class Cipher
{
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{};:',<>./?`~\\|\"0123456789";
    private Map<Character, Integer> alphabetIndex;

    public Cipher()
    {
        alphabetIndex = new HashMap<Character, Integer>();

        for(int i = 0; i < ALPHABET.length(); ++i)
            alphabetIndex.put(ALPHABET.charAt(i), i);
    }

    public String encode(String word)
    {
        char[] encoded = new char[word.length()];

        int shift = 1;

        for(int i = 0; i < word.length(); i++)
        {
            if(SPECIAL_CHARACTERS.indexOf(word.charAt(i)) != -1) // if character is punctuation & not letter
            {
                encoded[i] = word.charAt(i);
                continue;
            }

            if(word.charAt(i) < 91) // if word is uppercase
                encoded[i] = encodeUpperCase(word.charAt(i), shift);
            if(word.charAt(i) >= 97) // if word is lowercase
                encoded[i] = encodeLowerCase(word.charAt(i), shift);

            shift++;
        }

        return String.valueOf(encoded);
    }

    public String decode(String word)
    {
        char[] encoded = new char[word.length()];

        int shift = 1;

        for(int i = 0; i < word.length(); i++)
        {
            if(SPECIAL_CHARACTERS.indexOf(word.charAt(i)) != -1) // if character is punctuation & not letter
            {
                encoded[i] = word.charAt(i);
                continue;
            }

            if(word.charAt(i) < 91) // if word is uppercase
                encoded[i] = decodeUpperCase(word.charAt(i), shift);
            if(word.charAt(i) >= 97) // if word is lowercase
                encoded[i] = decodeLowerCase(word.charAt(i), shift);

            shift++;
        }

        return String.valueOf(encoded);
    }

    public char encodeLowerCase(char n, int shift)
    {
        int index = alphabetIndex.get(n) + shift;
        while(index > 25)
            index -= 26;

        return ALPHABET.charAt(index);
    }

    public char encodeUpperCase(char n, int shift)
    {
        int index = alphabetIndex.get(Character.toLowerCase(n)) + shift;
        while(index > 25)
            index -= 26;

        return Character.toUpperCase(ALPHABET.charAt(index));
    }

    public char decodeLowerCase(char n, int shift)
    {
        int index = alphabetIndex.get(n) - shift;
        while(index < 0)
            index += 26;

        return ALPHABET.charAt(index);
    }

    public char decodeUpperCase(char n, int shift)
    {
        int index = alphabetIndex.get(Character.toLowerCase(n)) - shift;
        while(index < 0)
            index += 26;

        return Character.toUpperCase(ALPHABET.charAt(index));
    }
}
