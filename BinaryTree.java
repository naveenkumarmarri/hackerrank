//Java implementation to check if given Binary tree
//is a BST or not
 
/* Class containing left and right child of current
 Nodes and key value*/
class Nodes
{
    int data;
    Nodes left, right;
 
    public Nodes(int item)
    {
        data = item;
        left = right = null;
    }
}
 
public class BinaryTree
{
    //Root of the Binary Tree
    Nodes root;
 
    /* can give min and max value according to your code or
    can write a function to find min and max value of tree. */
 
    /* returns true if given search tree is binary
     search tree (efficient version) */
    boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                               Integer.MAX_VALUE);
    }
 
    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    boolean isBSTUtil(Nodes Nodes, int min, int max)
    {
        /* an empty tree is BST */
        if (Nodes == null)
            return true;
 
        /* false if this Nodes violates the min/max constraints */
        if (Nodes.data < min || Nodes.data > max)
            return false;
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(Nodes.left, min, Nodes.data-1) &&
                isBSTUtil(Nodes.right, Nodes.data+1, max));
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
    	BinaryTree tree = new BinaryTree();
        tree.root = new Nodes(4000);
        tree.root.left = new Nodes(5000);
        tree.root.right = new Nodes(6000);
        tree.root.left.left = new Nodes(9000);
        tree.root.left.right = new Nodes(7000);
 
        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}