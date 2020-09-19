import java.util.*;
import java.lang.*;
import java.io.*;
import classes.*;

class Driver 
{
    /*
    public static String readFile(String fileName) throws Exception 
    { 
        String data = ""; 
        data = new String(Files.readAllBytes(Paths.get(fileName))); 
        return data; 
    } 
    */

    public static String rf(String fileName)
    {
	    Scanner input = new Scanner( new File(fileName) );
	    String text = input.useDelimiter("\\A").next();
	    return text;
    }

    public static void encode(String fileName)
    {
        String inputStream = rf(fileName);

        Map<Character, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < inputStream.length(); i++) 
        {
            char c = inputStream.charAt(i);
            if(!wordCount.containsKey(c))
            {
                wordCount.put(c, 1);
            }
            else 
            {
                wordCount.put(c, wordCount.get(c) + 1);
            }
        }

        int n = wordCount.size();
        char[] words = new char[n];
        int[] freq = new int[n];

        int i = 0;
        for (char c : wordCount.keySet()) 
        {
            words[i] = c;
            freq[i] = wordCount.get(c);
            i += 1;
        }

        HuffmanEncode h = new HuffmanEncode(words, freq, n);
        ENode r = h.create();
        h.getECode(r, "");
        String outputStream = h.getEString(inputStream);
        System.out.println(outputStream);
    }

    public static void decode(String Filename) 
    {
        //String inputStream = rf(fileName);
        System.out.println("Not done yet! ");
    }

    public static void main(String[] args) throws Exception
    {
        /*
        if (args.length != 2)
        {
            throw new IllegalArgumentException("Exactly 2 parameters required !");
        }

        String opr = args[0];
        String fileName = args[1];

        if (opr.equals("encode")) 
        {
            encode(fileName);
        }
        else if (opr.equals("decode"))
        {
            decode(fileName);
        }
        else 
        {
            throw new IllegalArgumentException("First parameter must be encode or decode !");
        }
        */
        String f = "input.txt";
        encode(f);
    }
}