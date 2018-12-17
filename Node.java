package huffman;
import java.util.PriorityQueue;
public class Node implements Comparable
{
	char value;//character
	private int key;//frequency
	Node left,right;
	
	//1. Complete constructor
	public Node(char v, int k) {
		value=v;
                key=k;
	}
	//----------------------------------
	//2. add all getter/setter here
	//------------------------------------  
        public void setValue(char value) {
        this.value = value;
        }

        public void setKey(int key) {
        this.key = key;
        }

        public void setLeft(Node left) {
        this.left = left;
        }

        public void setRight(Node right) {
        this.right = right;
        }

        public char getValue() {
        return value;
        }

        public int getKey() {
        return key;
        }

        public Node getLeft() {
        return left;
        }

        public Node getRight() {
        return right;
        }
	public boolean isLeaf() // method required in decoding
	{
		if(left==null && right==null)
				return true;
		else
			return false;
	}
	//----------------------
	public int compareTo(Object o)
	{
		if(o instanceof Node)
		{
			Node d=(Node)o;
			return this.key-d.key;	//will return a number= 0, <1 or >1
		}
		return -1;
	}
	//--------------------------
	public String toString()
	{
		return ""+key;
	}
}

