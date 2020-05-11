import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        Cipher cipher = new Cipher();

        String input = "";
        while(!input.equals("exit"))
        {
            System.out.print("Enter word: ");
            input = reader.nextLine();
            System.out.print("Encode or decode? ");
            String choice = reader.nextLine();
            System.out.print("Key: ");
            int key = Integer.parseInt(reader.nextLine());

            String[] words = input.split("\\s+");

            while(key > 0)
            {
                if(choice.equals("encode"))
                {
                    for(int i = 0; i < words.length; ++i)
                        words[i] = cipher.encode(words[i]);
                }
                if(choice.equals("decode"))
                {
                    for(int i = 0; i < words.length; ++i)
                        words[i] = cipher.decode( words[i]);
                }
                key--;
            }

            if(words.length > 1)
            {
                StringBuilder sentence = new StringBuilder();
                for(String word : words)
                    sentence.append(word + " ");

                System.out.println(sentence.toString());
            }
            else
                System.out.println(words[0]);
        }
    }
}