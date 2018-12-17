package huffman;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shahiryar
 */
import huffman.Node;
import java.util.Hashtable;
import java.util.HashMap;
public class NewClass {

public static void main(String[] args)
{
    PriorityHeap ph = new PriorityHeap();
    String string = "My Name Is shahiryar";
    Hashtable hash = new Hashtable();
    HashMap map = new HashMap();
    int old=0,value=1;
    for(int i=0;i<string.length();i++)
    {
        if(hash.containsKey(string.charAt(i)))
        {
            old=(int)hash.getOrDefault(string.charAt(i), string.charAt(0));
            value=old;
            value++;
            hash.replace(string.charAt(i), old, value);
        }
        else
        {
            value=1;
        hash.putIfAbsent(string.charAt(i),value );
        }
    }
   
    int[] fre = new int[hash.size()];
    for(int i=0;i<hash.size();i++)
    fre[i] =(int) hash.get(string.charAt(i));

    for(int i=0;i<fre.length;i++)
    System.out.println(fre[i]);
    
    Object[] o = hash.keySet().toArray();
    
    for(int i=0;i<hash.size();i++)
    System.out.println(o[i]);
    
     Node[] array = new Node[o.length];
            for(int i=0;i<o.length;i++)
            {
                Node node = new Node((char)o[i],fre[i]);
                array[i]=node;
            }
    for(int i=0;i<array.length;i++)
        ph.insert(array[i]);
    
            System.out.println("/////////////////////////////////////////////");
           while(!ph.isEmpty())
           System.out.println(ph.delete());
   }
}
