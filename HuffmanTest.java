package huffman;

import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package huffman;

/**
 *
 * @author shahiryar
 */
public class HuffmanTest {
    public static void main(String[] args) throws FileNotFoundException
    {
        HuffmanBuilder man = new HuffmanBuilder();
       String infile = "‪‪C:\\Users\\Shahiryar Arif\\Desktop\\Test.txt";
       String outfile = "C:\\Users\\Shahiryar Arif\\Desktop\\The Black Cat.txt";
       
        man.encode(infile,outfile);
        Node root= man.frequency(infile);
    }
    public static void inorder(Node root){
        if(root==null)
            return;
        
        inorder(root.left);
        if(root.left!=null&&root.right!=null)
        System.out.print("");
        else
        System.out.println(" "+root.getValue()+" "+root.getKey());
        inorder(root.right);
    }
    
}
