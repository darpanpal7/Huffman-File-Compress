import java.util.*;
import java.lang.*;
import java.io.*;

class ENode 
{  
    char c;
    int count;
    ENode left; 
    ENode right; 

    ENode(char c, int count, ENode left, ENode right)
    {
        this.c = c;
        this.count = count;
        this.left = left;
        this.right = right;
    }
} 

class MyComparator implements Comparator<ENode> 
{ 
    public int compare(ENode x, ENode y) 
    { 
        return x.count - y.count; 
    } 
}

class HuffmanEncode 
{
    private int n;
    private char[] words;
    private int[] freq;
    private ENode root = null;
    Map<Character, String> list = new HashMap<>();

    HuffmanEncode(char[] words, int[] freq, int n) 
    {
        this.n = n;
        this.words =  words;
        this.freq = freq;
    }

    public ENode create() 
    {
        PriorityQueue<ENode> pq = new PriorityQueue<ENode>(n, new MyComparator());
        for(int i = 0; i < n; i ++)
        {
            ENode hn = new ENode(words[i], freq[i], null, null);
            pq.add(hn);
        }

        while(pq.size() > 1)
        {
            ENode x = pq.poll(); 
            ENode y = pq.poll(); 
            
            ENode f = new ENode('-', (x.count + y.count), x, y);
            root = f;
            pq.add(f);
        }

        return root;
    }

    public void getECode (ENode root, String s)
    {
        if (root.left == null && root.right == null) 
        {
            list.put(root.c, s);
            //System.out.println(root.c + ":" + s); 
            return;
        } 
        getECode(root.left, s + "0"); 
        getECode(root.right, s + "1"); 
    }

    public String getEString(String inputStream) 
    {
        String outputStream = "";
        for(int j = 0; j < inputStream.length(); j++)
        {
            char c = inputStream.charAt(j);
            outputStream.concat(list.get(c));
        }
        return outputStream;
    }
}
