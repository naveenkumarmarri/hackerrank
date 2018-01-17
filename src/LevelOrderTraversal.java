
public class LevelOrderTraversal {
   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
   void levelOrder(Node_1 root) {
      if(root==null)
          return;
       int height = getHeight(root);
       for(int i=0; i<height; i++) {
           printLevel(root, i, 0);
       }
       
      
    }

    void printLevel(Node_1 root, int i, int track) {
        if(root != null && track == i) {
            System.out.print(root.data+" ");
        }
        if(track != i) {
            if(root.left != null)
                printLevel(root.left, i, track+1);
            if(root.right != null)
                printLevel(root.right, i, track+1);
        }
    }
    
    int getHeight(Node_1 root){
        if(root.left !=null && root.right != null)
            return 1+Math.max(getHeight(root.left), getHeight(root.right));
        if(root.left == null && root.right != null)
            return 1+getHeight(root.right);
        if(root.left != null && root.right == null)
            return 1+getHeight(root.left);
        
        return 1;
    }

}
