import java.util.Stack;

class Node_1 {
    int data;
    Node_1 left;
    Node_1 right;
}
	
public class LeastCommonAncestor {


	 /* Node is defined as :
	 
	    
	    */

	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> stack1 = new Stack<Integer>();

	static Node_1 lca(Node_1 root,int v1,int v2)
	    {
	        find(root, v1);
	        find_1(root, v2);
	        int v_1 = stack.size();
	        int v_2 = stack1.size();
	        if(v_1 < v_2){
	            while(v_1 != v2){ 
	                stack1.pop();
	            }
	        }
	        else if(v_1 > v_2){
	            while(v_1 != v2){ 
	                stack.pop();
	            }
	        }
	        int lca = -1;
	        for(int i=0;i<stack.size();i++) {
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
	        return search(root, lca);
	    }

	static Node_1 search(Node_1 root, int l) {
	    
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
	    return;
	}
	static void find(Node_1 root, int v) {
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

	static void find_1(Node_1 root, int v) {
	    if(root == null)
	        return;
	    if(root.data == v) {
	        stack1.push(root.data);
	        return;
	    }
	    if(root.data < v) {
	        stack1.push(root.data);
	        if(root.left != null)
	              find(root.left, v);
	    }
	    if(root.data > v) {
	        stack1.push(root.data);
	        if(root.right != null)
	            find(root.right, v);
	    }
	}





}
