import java.util.Scanner;

public class Test
{
    public static final Cipher CIPHER = new Cipher();

    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);

        String input = "";
        while(!input.equals("exit"))
        {
            System.out.print("Enter word: ");
            input = reader.nextLine();
            System.out.print("Encode or decode? ");
            String choice = reader.nextLine();

            String[] words = input.split("\\s+");
            String[] encodedSentence = new String[words.length];

            if(choice.equals("encode"))
            {
                for(int i = 0; i < words.length; ++i)
                    encodedSentence[i] = CIPHER.encode(words[i]);
            }
            if(choice.equals("decode"))
            {
                for(int i = 0; i < words.length; ++i)
                    encodedSentence[i] = CIPHER.decode( words[i]);
            }

            if(encodedSentence.length > 1)
            {
                StringBuilder sentence = new StringBuilder();
                for(String word : encodedSentence)
                    sentence.append(word + " ");

                System.out.println(sentence.toString());
            }
            else
                System.out.println(encodedSentence[0]);
        }
    }
}