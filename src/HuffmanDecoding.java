
public class HuffmanDecoding {

	/*  
	   class Node
	      public  int frequency; // the frequency of this tree
	       public  char data;
	       public  Node left, right;
	    
	*/ 

	void decode(String S ,Node_1 root)
	    {
	        int length = S.length();
	        int i = 0;
	        Node_1 temp = root;
	        while(i<length)
	        {
	            temp = root;
	            while(temp != null) {
	                if(temp.left == null && temp.right == null){
	                    System.out.print(temp.data);
	                    break;
	                }
	                if(S.charAt(i) == '0')
	                    temp = temp.left;
	                if(S.charAt(i) == '1')
	                    temp = temp.right;
	                i++; 
	            }
	            
	        }
	       
	    }

}
