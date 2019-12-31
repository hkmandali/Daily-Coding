package DailyCoding;
import Trees.Tree;
/*
A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
 */
public class Day8 {
    // unival trees are those , which have same value throughout the tree
    // this method finds out the num of unival subtrees for a tree
    // we need to check if a tree is unival or not
    static int counter = 0;
    static boolean isUnival(Tree Node,int value)
    {
       if(Node == null)
           return true;
       if(Node.root == value)
       {
           if(isUnival(Node.rightchild,value) && isUnival(Node.leftchild,value))
               return true;
       }
       return false;
    }

    // this function counts the number of unival subtress for a given tree
    static int numUnivalTrees(Tree Node)
    {
        if(Node == null)
            return 0;
        int left = numUnivalTrees(Node.leftchild);
        int right = numUnivalTrees(Node.rightchild);
        if(isUnival(Node,Node.root))
            return 1+left+right;
        return left+right;
    }

    // the above approach will cost us O(n2) because for every node we need to evaluate all other nodes,
    // eg: for root we find numunivaltrees(left) in line 40 and isunival in line 42 which in turn calls the same , so every node gets called twice making it n2

    // this function counts the number of unival subtress for a given tree in O(n) by coming in bottom up approach
    static boolean checkisUnival(Tree Node) // if it is unival , we increment the counter
    {
        if(Node == null)
            return true;

        boolean left = checkisUnival(Node.leftchild);
        boolean right = checkisUnival(Node.rightchild);
        // the above steps are same as above approach , and instead of checking if it is unival recursively , we'll check if root's data is the same or not
        if(left == false || right == false)
            return false;

        // now we'll check if the root's data is the same as left and right child's data
        if(Node.leftchild != null && Node.root != Node.leftchild.root || (Node.rightchild != null && Node.root != Node.rightchild.root))
            return false;

        counter++;
        return true;
    }
    public static void main(String[] args)
    {
        Tree obj = new Tree(1);
        obj.leftchild = obj.addChild(2);
        obj.rightchild = obj.addChild(3);
        obj.leftchild.leftchild = obj.addChild(4);
        obj.leftchild.rightchild = obj.addChild(5);
        obj.leftchild.leftchild.leftchild = obj.addChild(6);
        obj.leftchild.leftchild.rightchild = obj.addChild(7);
        obj.leftchild.rightchild.leftchild = obj.addChild(5);
        obj.leftchild.rightchild.rightchild = obj.addChild(5);

        Tree obj1 = new Tree(2);
        obj1.leftchild = obj.addChild(2);
        obj1.rightchild = obj.addChild(1);

        System.out.println(" the number of unival subtrees are "+numUnivalTrees(obj1));
        checkisUnival(obj);
        System.out.println(" the number of unival subtrees for first tree are "+counter);
    }
}
