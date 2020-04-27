import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static final char[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final String PUNCTUATION = ".,':!?";

    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        Map<Character, Integer> alphabetIndex = new HashMap<Character, Integer>();

        for(int i = 0; i < ALPHABET.length; ++i)
            alphabetIndex.put(ALPHABET[i], i);

        String input = "";
        while(!input.equals("exit"))
        {
            System.out.print("Enter word: ");
            input = reader.nextLine();
            System.out.print("Encode or decode? ");
            String choice = reader.nextLine();

            String[] words = input.split("\\s+");
            String[] encodedSentence = new String[words.length];
            String fullyEncoded = "";
            if(choice.equals("encode"))
            {
                for(int i = 0; i < words.length; ++i)
                    encodedSentence[i] = encode(alphabetIndex, words[i]);
            }
            if(choice.equals("decode"))
            {
                for(int i = 0; i < words.length; ++i)
                    encodedSentence[i] = decode(alphabetIndex, words[i]);
            }

            if(encodedSentence.length > 1)
            {
                StringBuilder sentence = new StringBuilder();
                for(String word : encodedSentence)
                    sentence.append(word + " ");

                fullyEncoded = sentence.toString();
            }
            else
                fullyEncoded = encodedSentence[0];

            System.out.println(fullyEncoded);
        }
    }

    public static String encode(Map<Character, Integer> alphabetIndex, String word)
    {
        char[] wordCharacter = word.toCharArray();
        char[] encoded = new char[wordCharacter.length];
        int shift = 1;

        for(int i = 0; i < wordCharacter.length; i++)
        {
            if(PUNCTUATION.indexOf(wordCharacter[i]) != -1) // if character is punctuation & not letter
            {
                encoded[i] = wordCharacter[i];
                continue;
            }

            int index = alphabetIndex.get(wordCharacter[i]) + shift;
            while(index > 25)
                index -= 26;

            encoded[i] = (wordCharacter[i] < 91 ? Character.toUpperCase(ALPHABET[index]) : ALPHABET[index]);
            shift++;
        }

        return String.valueOf(encoded);
    }

    public static String decode(Map<Character, Integer> alphabetIndex, String word)
    {
        char[] wordCharacter = word.toCharArray();
        char[] encoded = new char[wordCharacter.length];
        int shift = 1;

        for(int i = 0; i < wordCharacter.length; i++)
        {
            if(PUNCTUATION.indexOf(wordCharacter[i]) != -1) // if character is punctuation & not letter
            {
                encoded[i] = wordCharacter[i];
                continue;
            }
            int index = alphabetIndex.get(wordCharacter[i]) - shift;

            while (index < 0)
                index += 26;

            encoded[i] = ALPHABET[index];
            shift++;
        }

        return String.valueOf(encoded);
    }
}