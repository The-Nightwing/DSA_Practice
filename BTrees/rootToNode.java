
import java.util.*;

public class rootToNode{

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
//1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1
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

    static ArrayList<Integer> root_to_node(Node root,int data)
    {
        if(root == null){
            return null;
        }

        if(root.data==data){
            ArrayList<Integer> p = new ArrayList<Integer>();
            p.add(data);
            return p;
        }

        ArrayList<Integer> left = new ArrayList<Integer>();
        left = root_to_node(root.left,data);

        if(left!=null){
            left.add(root.data);
            return left;
        }

        ArrayList<Integer> right = new ArrayList<Integer>();
        right = root_to_node(root.right,data);

        if(right!=null){
            right.add(root.data);
            return right;
        }

        else{
            return null;
        }
    }

    public static void main(String[] args) {

        Node tree = null;
        tree = takeInput();
        Scanner in = new Scanner(System.in);
        int data = in.nextInt();

        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans = root_to_node(tree,data);
        
        for(int i=0;i<ans.size();i++)
        {
            System.out.print(ans.get(i)+" ");
        }
    }
}