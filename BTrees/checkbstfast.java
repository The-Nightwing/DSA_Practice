import java.util.*;
import java.lang.Math;

public class checkbstfast {

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

    public static class Pair{
        int min;
        int max;
        boolean isBst;

        public Pair()
        {

        }
        
    }
    public static Pair check(Node tree)
    {
        if(tree == null)
        {
            Pair p = new Pair();
            p.min = Integer.MAX_VALUE;
            p.max = Integer.MIN_VALUE;
            p.isBst = true;

            return p;
        }

        Pair p1 = check(tree.left); //left ouptut.
        Pair p2 = check(tree.right);//right ouput.

        int max = Math.max(tree.data,Math.max(p1.max,p2.max));
        int min = Math.min(tree.data,Math.min(p1.min,p2.min));
        
        boolean isBstf = false;

        if(tree.data> p1.max && tree.data<= p2.min && p1.isBst && p2.isBst)
        {
            isBstf = true;
        }

        Pair ret  = new Pair();
        ret.min = min;
        ret.max = max;
        ret.isBst = isBstf;
        
        return ret;
}

public static boolean check3(Node root,int min,int max)
{
    if(root==null)
    {
        return true;
    }

    if(root.data<min || root.data>max)
{
    return false;
}

boolean isleftok  = check3(root.left,min,root.data-1);
boolean isrightok = check3(root.right,root.data-1,max);

return isleftok && isrightok;

}
    public static void main(String[] args) {
        Node tree  = null;
        tree = takeInput();
        Pair p  = check(tree);
        System.out.println(p.isBst);
        System.out.println(check3(tree,Integer.MIN_VALUE,Integer.MAX_VALUE));
        //display(tree);
    }
    
}