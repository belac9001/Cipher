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

            String[] words = input.split("\\s+");
            StringBuilder encoded = new StringBuilder();

            if(choice.equals("encode"))
            {
                for(int i = 0; i < words.length; ++i)
                    encoded.append(cipher.encode(words[i]) + " ");
            }
            if(choice.equals("decode"))
            {
                for(int i = 0; i < words.length; ++i)
                    encoded.append(cipher.decode(words[i]) + " ");
            }

            System.out.println(encoded.toString());
        }
    }
}