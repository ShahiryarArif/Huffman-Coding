package huffman;
import java.io.*;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.io.Serializable;
public class HuffmanBuilder implements Serializable{
	//do not add any additional variable here, instead use them as local to functions
	//try to breakdown the both methods into smaller parts and transfer the work to helper methods
	public  void encode(String infile, String outfile) throws FileNotFoundException
	{
		/*
		 * read the file 
		 * find unique character and their frequencies
		 * build tree using algo discussed in handout
		 * get the bitcode for each unique character by tree traversal
		 * write it to file using info from orignal file.
		 * print the frequency table similar to one shown in handout.
		 */
           // FileReader file = new FileReader(infile);
            String string = FileIO.readFile(outfile);
           // System.out.println(file.getAbsolutePath());
            Node root = frequency(string);
            Hashtable hash = new Hashtable();
            String bitcode;
            for(int i=0;i<string.length();i++)
            {
             bitcode=bitCode(root,string.charAt(i));
             hash.putIfAbsent(string.charAt(i), bitcode);
            }
        }
        public String serialize(Node root)
        {
            if(root==null)
            {
                return "-1";
            }
            
            StringBuilder str = new StringBuilder();
            str=serialize(root.left);
            str=serialize(root.right);
            
            return str;
        }
        @SuppressWarnings("unchecked")
        public Node frequency(String string)
        {
              Hashtable hash = new Hashtable();
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
        for(int i=0;i<hash.size();i++) {
        fre[i] =(int) hash.get(string.charAt(i));
        }
        Object[] o = hash.keySet().toArray();
        
            return buildTree(o,fre);
        }
        public Node buildTree(Object[] ch,int[] freq)
        {
         //   PriorityHeap ph = new PriorityHeap();
            Node[] array = new Node[ch.length];
            for(int i=0;i<ch.length;i++)
            {
                Node node = new Node((char)ch[i],freq[i]);
                array[i]=node;
            }
            sort(array);
      
            return treeFormation(array);
        }
        public void sort(Node array[])
        {
            Node temp;
            for(int i=0;i<array.length;i++)
            {
                for(int j=i+1;j<array.length;j++)
                {
                    if(array[i].getKey()>array[j].getKey())
                    {
                      temp=array[i];
                      array[i]=array[j];
                      array[j]=temp;
                    }
                }
            }
        }
        @SuppressWarnings("unchecked")
        public Node treeFormation(Node array[])
        {
            PriorityHeap ph = new PriorityHeap(2*array.length);
            
            for (Node array1 : array) {
               ph.insert(array1);
            }
            
            while(ph.size!=1)
            {
              Node one = (Node) ph.delete();
              Node two = (Node)ph.delete();
              
              Node parent = new Node('-',one.getKey()+two.getKey());
              parent.left=one;
              parent.right=two;
              ph.insert(parent);   
            }
            
            return (Node)ph.delete();
        }
        public String bitCode(Node root, char ch){

          // See if target immediately available
        if(root!=null)
        {
        if (root.left!=null&&root.left.value == ch) {
            return "0";
        }
        if (root.right!=null&&root.right.value == ch) {
            return "1";
        }
        // Search deeper
        String leftResult = bitCode(root.left, ch);
        if (leftResult != null) {
            return "0" + leftResult;
        }
        String rightResult = bitCode(root.right, ch);
        if (rightResult != null) {
            return "1" + rightResult;
        }
        }
        // Not found
        return null;

        }
	//infile will be a file which contains bitscodes
	public static void decode(String infile, String outfile)
	{

		/*
		 * read the infile
		 * get the tree
		 * build tree
		 * get the bit sequence
		 * read bit sequence and construct the string
		 * write to file.
		 */
	}

}
