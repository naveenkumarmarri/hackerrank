import sun.applet.Main;

public class MinHeighBTree {
	
	public static void main(String[] args) {
		NameNode node=new NameNode();
		node.value=10;
		node.left=new NameNode();
		node.right=null;
		
		node.left.value=2;
		
		
		node.left.left=null;
		node.left.right=null;
		
		
		System.out.println(min(node));
	}
	
	public static int min(NameNode node)
	{
		if(node==null)
			 return 0;
		
		if(node.left==null)
		{
			return 1+min(node.right);
		}
		 if(node.right==null)
		{
			return 1+min(node.left);
		}
		 if(node.left==null&&node.right==null)
		 {
			 return 1;
		 }
		 
			return 1+Math.min(min(node.left),min(node.right));
		
				
		//return 0;
	}
}

class NameNode{
	int value;
	NameNode left;
	NameNode right;
}