package DailyCoding;
import Trees.Tree;
import Trees.PreOrderTraversal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
 */

// for a complete binary , where all the levels are completely filled except the last one , we can store the level order traversal
// for a full binary tree , where each node has two or 0 children , we can store preorder traversal along with a marker to mention if its the leaf node or not
// for a bst , either preorder or post order would be good
// for a generic tree , we need to store both inorder and preorder (or) preorder and markers which mention if children are present or not

// as we are not sure about the type of tree , we'll go by the generic approach
public class Day3 {
    // this function will write our tree into the file
    static void writetoFile(Tree obj,FileWriter fw) throws IOException
    {
        if(obj == null)
        {
            fw.write(">"); // this signified that it has no children
            return;
        }
        else
        {
            System.out.println("writing the current node "+obj.root);
            // preorder
            fw.write(Integer.toString(obj.root));
            writetoFile(obj.leftchild,fw);
            writetoFile(obj.rightchild,fw);
        }
    }
    // this function will read our tree from the file
    static Tree readfromFile(FileReader fr) throws IOException
    {
        Tree obj;
        int ch = fr.read();
        System.out.println("current output is "+(ch-'0'));
        if(ch == '>' || ch == -1) // i.e either the file has been completely processed(-1) or it has no children(>)
        {
            return null;
        }
        else
        {
            obj = Tree.addChild(ch - '0');
            obj.leftchild = readfromFile(fr);
            obj.rightchild = readfromFile(fr);
        }
        return obj;
    }
    public static void main(String[] args) throws IOException
    {
        // we'll basically serialize and de serialize using writetoFile and readfromFile respectively
        Tree obj = new Tree(1);
        obj.leftchild = obj.addChild(2);
        obj.rightchild = obj.addChild(3);
        obj.leftchild.leftchild = obj.addChild(4);
        obj.leftchild.rightchild = obj.addChild(5);
        obj.leftchild.leftchild.leftchild = obj.addChild(6);
        obj.leftchild.leftchild.rightchild = obj.addChild(7);
        obj.leftchild.rightchild.leftchild = obj.addChild(8);
        obj.leftchild.rightchild.rightchild = obj.addChild(9);
        PreOrderTraversal.preorder(obj);
        String file_name = "give_your_filePath";
        // Serialize the tree , we will store it into a file

        System.out.println("writing the tree into a file");
        FileWriter fw = null;
        try {
            System.out.println("creating a new file");
            fw = new FileWriter(file_name);
        }catch (Exception e)
        {
            System.out.println("not able to create file writer");
            e.printStackTrace();
        }
        writetoFile(obj,fw); // root node , file writer , // we'll write -1 for no child and value for a child

        System.out.println("succesfully written into the file , now let us construct the tree from this ");
        fw.close();
        FileReader fr = null;
        try
        {
            fr = new FileReader(file_name);
        }catch (Exception e)
        {
            System.out.println("issue in reading the file ");
            e.printStackTrace();
        }

        Tree constructed_from_file = readfromFile(fr);
        System.out.println("tree passed as input");
        PreOrderTraversal.preorder(obj);
        System.out.println("tree extracted as output");
        PreOrderTraversal.preorder(constructed_from_file);
        fr.close();

    }
}
