import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;

public class PathSumBTree
{
    //Root of the Binary Tree
	PathSumBTreeNodes root;
	int value=10000;
	boolean traverse(PathSumBTreeNodes node,int sum)
	{
		System.out.println(sum);
		if(node!=null)
		{
			sum=sum+node.data;	
			if(node.left==null&&node.right==null){
				if(sum==value)
					return true;
				else
					sum=sum-node.data;
			}
			traverse(node.left,sum);
			traverse(node.right,sum);							
		}
		return false;
		
	}
	
	 public static void main(String args[])
	    {
		 PathSumBTree tree = new PathSumBTree();
	        tree.root = new PathSumBTreeNodes(4000);
	        tree.root.left = new PathSumBTreeNodes(5000);
	        tree.root.right = new PathSumBTreeNodes(6000);
	        tree.root.left.left = new PathSumBTreeNodes(9000);
	        tree.root.left.right = new PathSumBTreeNodes(7000);
	        System.out.println(tree.traverse(tree.root,0));
	       
	    }
}


class PathSumBTreeNodes
{
    int data;
    PathSumBTreeNodes left, right;
 
    public PathSumBTreeNodes(int item)
    {
        data = item;
        left = right = null;
    }
}
 