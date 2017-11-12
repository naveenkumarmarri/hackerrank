
public class BInsert {
		
	public static void main(String[] args) {
		
		int[] a = {4,12,1,6,3,9};
		BNode head= new BNode(a[0]);
		for(int i=1;i<a.length;i++)
			insert(head,a[i]);		
		
		System.out.println(head.value);
		System.out.println(head.left.value);
		System.out.println(head.right.value);
	}

	private static void insert(BNode node,int a) {
		if(node==null)
		{
			
			BNode temp=new BNode(a);
			node=temp;
					
		}
		if(node.value>a)
		{
			if(node.left==null)
			{
				BNode temp=new BNode(a);
				node.left=temp;
			}
			else
				insert(node.left,a);
			
		}			
		if(node.value<a)
		{
			if(node.right==null)
			{
				BNode temp=new BNode(a);
				node.right=temp;
			}
			else
				insert(node.right,a);
		}

	}
	
}
class BNode{
	BNode(int a)
	{
		left=null;
		 right=null;
		value=a;
	}
	BNode()
	{
		
	}
	
	BNode left;
	BNode right;
	int value;
}