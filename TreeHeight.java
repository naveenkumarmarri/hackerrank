
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

class TreeHeight {
    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] values=new int[n];
        Node root=new Node();
        root.value=s.nextInt();
        for (int i = 1; i < n; i++) {
            values[i]=s.nextInt();
            insertTree(root, values[i]);
        }
        System.out.println(determineHieght(root));

        
    }

	private static int determineHieght(Node root) {
		if(root==null)
			return 1;
		else
			return Math.max(determineHieght(root.left),determineHieght(root.right))+1;
		
		
	}

	private static Node insertTree(Node root,int i) {
		if(root.value<i)
		{
			if(root.right==null)
			{
			Node temp=new Node();
			root.right=temp;
			temp.value=i;
			temp.left=null;
			temp.right=null;
			}
			else
				insertTree(root.right, i);
		}
		
		if(root.value>i)
		{
			if(root.left==null)
			{
			Node temp=new Node();
			root.left=temp;
			temp.value=i;
			temp.left=null;
			temp.right=null;
			}
			else
				insertTree(root.left, i);
		}
		return root;
	}
}
class Node{
	int value;
	Node left;
	Node right;
}
