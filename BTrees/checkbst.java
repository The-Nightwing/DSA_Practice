
import java.util.*;

import jdk.javadoc.internal.doclets.toolkit.taglets.ReturnTaglet;

public class checkbst {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            left=null;
            right = null;
        }
    }
    static ArrayList<Node> queue = new ArrayList<Node>();

    public static Node takeInput()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter root: ");
        int root = in.nextInt();
        if(root == -1)
        {
            return null;
        }
        Node tree = new Node(root);
        queue.add(tree);

        while(queue.size()!=0)
        {
            Node front = queue.get(0);
            queue.remove(0);
            System.out.println("Enter left child of "+front.data);
            int leftchild =in.nextInt();

            if(leftchild!=-1)
            {
                Node child = new Node(leftchild);
                front.left = child;
                queue.add(child);
            }

            System.out.println("Enter right child of "+front.data);

            int rightchild =in.nextInt();
            if(rightchild!=-1)
            {
                Node child = new Node(rightchild);
                front.right = child;
                queue.add(child);
            }
        }
        return tree;
    }

    public static void display(Node tree)
    {
        if(tree==null)
        {
            return;
        }

        System.out.print(tree.data+":");
        if(tree.left!=null)
        {
            System.out.print("L"+tree.left.data+" ");
        }
        if(tree.right!=null){
            System.out.print("R"+tree.right.data);
        }
        System.out.println();
        display(tree.left);
        display(tree.right);
    }

    public static int Lmaximum(Node tree)
    {
        if(tree==null){
            return Integer.MIN_VALUE;
        }

        return Math.max(tree.data,Math.max(Lmaximum(tree.left),Lmaximum(tree.right)));
    }
    public static int Rminimum(Node tree)
    {
        if(tree==null){
            return Integer.MAX_VALUE;
        }

        return Math.min(tree.data,Math.min(Rminimum(tree.left),Rminimum(tree.right)));
    }
    public static boolean check(Node tree){
        if(tree == null)
        {
            return true;
        }

        int Lmax = Lmaximum(tree.left);
        int Rmin = Rminimum(tree.right);

        if( tree.data > Lmax && tree.data < Rmin && check(tree.left) && check(tree.right))
        {
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        Node tree = null;
        tree = takeInput();

        display(tree);
        boolean ans = check(tree);
        System.out.println(ans);
        //display(tree);        
    }
    
}

//1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1