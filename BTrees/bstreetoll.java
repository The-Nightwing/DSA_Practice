
import java.util.*;

public class bstreetoll {
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

    public static class linkedlist{
        int data;
        linkedlist next;

        public linkedlist(int data)
        {
            this.data = data;
            next = null;
        }
    }

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

    static linkedlist ll = null;
    static linkedlist head = null;
    static linkedlist tail = null;

    public static void display(Node tree)
    {
        if(tree==null)
        {
            return;
        }

        display(tree.left);

        if(ll==null)
        {
            ll= new linkedlist(tree.data);
            head = ll;
            tail = ll;
        }
        else{
            linkedlist temp = new linkedlist(tree.data);
            tail.next = temp;
            tail = tail.next;
            tail = temp;
        }
        
        display(tree.right);
    }

    public static void showf()
    {
        while(head.next != null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

   
    public static void main(String[] args) {

        Node tree = null;

        tree = takeInput();
        display(tree);
        showf();
    }
    
}