import java.util.*;
import java.lang.*;
import java.io.*;

class DNode
{
    char val;
    DNode left;
    DNode right;

    DNode(char val, DNode left, DNode right) 
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class HuffmanDecode
{
    private Map<Character, String> list;
    private DNode root = null;

    HuffmanDecode(Map<Character, String> list) 
    {
        this.list = list;
    }

    void insertNode(char c, String s) {
        DNode temp = root;
        if (temp == null)
        {
            for(int i = 0; i < s.length(); i++)
            {
                char ch = s.charAt(i); 
                if(ch == '0')
                {
                    temp.left = new DNode('0', null, null);
                    temp = temp.left;
                }
                else 
                {
                    temp.right = new DNode('1', null, null);
                    temp = temp.right;
                }
            }
            DNode terminal = new DNode(c, null, null);
            temp.left = terminal;
            temp.right = terminal;
        }
        else 
        {
            for(int i = 0; i < s.length(); i++)
            {
                char ch = s.charAt(i);
                if(ch == '0')
                {
                    if(temp.left != null)
                    {   
                        temp = temp.left;
                    }
                    else 
                    {
                        temp.left = new DNode('0', null, null);
                        temp = temp.left;
                    }
                }
                else 
                {
                    if(temp.right != null)
                    {
                        temp = temp.right;
                    }
                    else
                    {
                        temp.right = new DNode('1', null, null);
                        temp = temp.right;
                    }
                }
            }
            DNode terminal = new DNode (c, null, null);
            temp.left = terminal;
            temp.right = terminal;
        }
    }

    public DNode create()
    {
        for (char c : list.keySet())
        {
            insertNode(c, list.get(c));
        }
        return root;
    }

    public String getDString(String inputStream) 
    {
        StringBuilder outputStream = new StringBuilder("");
        DNode temp = root;
        for(int i = 0; i < inputStream.length(); i++)
        {
            char ch = inputStream.charAt(i);
            if(temp.left == temp.right)
            {
                DNode block = temp.left;
                outputStream.append(block.val);
                i--;
                temp = root;
            }
            else if(ch == '0') 
            {
                temp = temp.left;
            }
            else 
            {
                temp = temp.right;
            }
        }
        return outputStream.toString();    
    }
}