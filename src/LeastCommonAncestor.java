import java.util.Stack;

class Node_2 {
    int data;
    Node_2 left;
    Node_2 right;
}
	
public class LeastCommonAncestor {



	 /* Node is defined as :
	 class Node 
	    int data;
	    Node left;
	    Node right;
	    
	    */

	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> stack1 = new Stack<Integer>();

	static Node_2 lca(Node_2 root,int v1,int v2)
	    {
	        Node_2 temp = root;
	        find(root, v1);
	        find_1(temp, v2);
	        int v_1 = stack.size();
	        int v_2 = stack1.size();
	        if(v_1 < v_2){
	            while(v_1 != v_2){ 
	                stack1.pop();
	                v_2--;
	            }
	        }
	        else if(v_1 > v_2){
	            while(v_1 != v2){ 
	                stack.pop();
	                v_1--;
	            }
	        }
	        
	        int lca = -1;
	        while(stack.size()!=0 && stack1.size()!=0) {
	            int temp_1 = stack.pop();
	            int temp_2 = stack1.pop();
	            boolean found = false;
	            if(temp_1 == temp_2) {
	                lca = temp_1;
	                found = true;
	                break;
	            }
	            if(found)
	                break;
	                
	        }
	    System.out.println(lca);
	        return search(root, lca);
	    }

	static Node_2 search(Node_2 root, int l) {
	    
	    if(root.data == l)
	        return root;
	    if(root.data < l) {
	        if(root.left != null) {
	            search(root.left, l);
	        }
	    }
	    if(root.data > l) {
	        if(root.right != null) {
	            search(root.right, l);
	        }
	    }
	    return null;
	}
	static void find(Node_2 root, int v) {
	    if(root == null)
	        return;
	    if(root.data == v) {
	        stack.push(root.data);
	        return;
	    }
	    if(root.data < v) {
	        stack.push(root.data);
	        if(root.left != null)
	              find(root.left, v);
	    }
	    if(root.data > v) {
	        stack.push(root.data);
	        if(root.right != null)
	            find(root.right, v);
	    }

	}

	static void find_1(Node_2 root, int v) {
	    if(root == null)
	        return;
	    if(root.data == v) {
	        stack1.push(root.data);
	        return;
	    }
	    if(root.data < v) {
	        stack1.push(root.data);
	        if(root.left != null)
	              find_1(root.left, v);
	    }
	    if(root.data > v) {
	        stack1.push(root.data);
	        if(root.right != null)
	            find_1(root.right, v);
	    }
	}







}
