import java.util.*;
import java.lang.Math;

public class diameter{
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    public static int height(Node node)
    {
        if(node == null)
        {
            return 0;
        }

        return 1+Math.max(height(node.left),height(node.right));
    }

    public static int diameterf(Node tree)
    {
        if(tree == null) 
        {
            return 0;
        }

        int option1 = height(tree.left)+height(tree.right);
        int option2 = diameterf(tree.left);
        int option3 = diameterf(tree.right);
        
        return (int)Math.max(option1, Math.max(option2, option3));
    }
    public static int display(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        display(root.left);
        System.out.println(root.data);

        return 0;
    }
    public static void main(String[] args) {
        Node tree = new Node(1);

        tree = new Node(1); 
        tree.left = new Node(2); 
        tree.right = new Node(3); 
        tree.left.left = new Node(4); 
        tree.left.right = new Node(5); 
        tree.left.right.right =new Node(6);

  
        
        int ans = diameterf(tree);

    //System.out.println(ans);
    //display(tree);
    }
}