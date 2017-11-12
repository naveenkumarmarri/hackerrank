import java.io.InputStream;
import java.util.Scanner;

public class ReverseLL {

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			if(i==0)
			{
				head.data=sc.nextInt();
				head.next=null;
				
			}
			else{
			int value=sc.nextInt();
			LinkedNode node = new LinkedNode();
			node=head;
			while(node!=null)
			{
				if(node.next==null)
				{
					LinkedNode temp = new LinkedNode();
					temp.data=value;
					node.next=temp;
					temp.next=null;
					node=node.next;
				}
				node=node.next;
			}
			
			}
		}
		
		LinkedNode reverse = deleteNode(head,3);
		while(reverse!=null)
		{
			System.out.println(reverse.data);
			reverse=reverse.next;
		}
	}
	private static LinkedNode deleteNode(LinkedNode head,int value)
	{
		while(head!=null)
		{
			  head.data = head.next.data;

            head.next = head.next.next;
	            
		}
		return head;
		
	}
	
	private static LinkedNode reverse(LinkedNode head) {
		LinkedNode currNode = head;
		LinkedNode nextNode = null;
		LinkedNode prevNode = null;

		while(currNode!=null){
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		head = prevNode;
		return head;
	}

	
	

}
class LinkedNode{
	LinkedNode next;
	int data;
}
