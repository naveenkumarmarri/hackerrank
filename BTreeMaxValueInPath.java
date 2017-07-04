
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class BTreeMaxValueInPath {
    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] values=new int[n];
        int start=s.nextInt();
        int end=s.nextInt();
        BTreeNode root=new BTreeNode();
        root.data=s.nextInt();
        for (int i = 1; i < n; i++) {
            values[i]=s.nextInt();
            insertTree(root, values[i]);
        }
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        System.out.println(root.right.right.data);
        System.out.println(root.right.left.data);
        
        int[] firstArray = determinePath(root,start).stream().mapToInt(i->i).toArray();
        int[] secondArray = determinePath(root,end).stream().mapToInt(i->i).toArray();
        
     /*   int j=0;
        int commonAncestor=0;
        for(int i : values)
        {
        	if(secondArray[j]==i)
        		continue;
        	else
        		commonAncestor=secondArray[j];
        }
        System.out.println(commonAncestor);
     */   
    }
	private static List<Integer> determinePath(BTreeNode root,int i) {
		
		List<Integer> firstPath=new ArrayList<Integer>();
			if(root!=null)
			{
				firstPath.add(root.data);
				while(root!=null)
				{
					if(root.data>i&&root!=null)
					{
						root=root.left;
						firstPath.add(root.data);
						System.out.println(root.data);
						if(root.left!=null)
							determinePath(root.left, i);
					}
					if(root.data<i&&root!=null)
					{
						root=root.right;
						firstPath.add(root.data);
						System.out.println(root.data);
						if(root.right!=null)
							determinePath(root.right, i);
					}
					if(root.data==i)
					{
						return firstPath;
					}
				}
			}
			
				return null;
	}

	private static BTreeNode insertTree(BTreeNode root, int i) {
		if(root.data<i)
		{
			if(root.right==null)
			{
				BTreeNode temp=new BTreeNode();
			root.right=temp;
			temp.data=i;
			temp.left=null;
			temp.right=null;
			}
			else
				insertTree(root.right, i);
		}
		
		if(root.data>i)
		{
			if(root.left==null)
			{
				BTreeNode temp=new BTreeNode();
			root.left=temp;
			temp.data=i;
			temp.left=null;
			temp.right=null;
			}
			else
				insertTree(root.left, i);
		}
		return root;
	}
		
	}  

class BTreeNode{
	BTreeNode left;
	BTreeNode right;
	int data;
}