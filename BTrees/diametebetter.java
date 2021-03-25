import java.util.*;
import java.lang.Math;

public class diametebetter
{
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
    public static class Pair
    {
        int h;
        int d;

        public Pair()
        {

        }
    }

    public static Pair both(Node tree)
    {
        if(tree==null)
        {
            Pair p=new Pair();
            p.h = 0;
            p.d = 0;
            return p;
        }

        Pair leftans = both(tree.left);
        Pair rightans = both(tree.right);
        
        int lheight = leftans.h;
        int rheight = rightans.h;
        int ldia = leftans.d;
        int rdia = rightans.d;

        int height = 1+ Math.max(lheight, rheight);
        int diameter = Math.max(lheight+rheight,Math.max(ldia,rdia));

        Pair ans = new Pair();
        ans.h = height;
        ans.d = diameter;


        return ans;
    }

    public static void main(String[] args) {

        Node tree = new Node(1);

        tree = new Node(1); 
        tree.left = new Node(2); 
        tree.right = new Node(3); 
        tree.left.left = new Node(4); 
        tree.left.right = new Node(5); 
        tree.left.right.right =new Node(6);

        Pair p=both(tree);


        System.out.println("height: "+p.h);
        System.out.println("diameter: "+p.d);
        
        int[] tree = new int[]{1,2,3,4,5,6,7};

        buildBST(tree);

        
    }
}