import java.util.Scanner;

public class bstoperations {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            left = null;
            right  = null;
        }
    }

    static Node delete(Node root,int data){
        if(root == null)
        {
            return null;
        }

        if(data > root.data){
            root.right = delete(root.right,data);
            return root;
        }
        else if(data < root.data)
        {
            root.left = delete(root.left,data);
            return root;
        }
        else{
            if(root.left==null && root.right==null)
            {                                                                                                
                return null;
            }
            else if(root.left==null){
                Node temp = root.right;
                root.right = null;
                return temp;
            }
            else if(root.right==null){
                Node temp = root.left;
                root.left = null;
                return temp;
            }
            else{
                Node min = root.right;
                while(min.left != null)
                {
                    min = min.left;
                }
                int rightmin = min.data;

                root.data = rightmin;
                root.right = delete(root.right, rightmin);
                return root;
            }
        }

    }

    static Node insert(Node root,int data){
        if(root==null)
        {
            return new Node(data);
        }

        if(data > root.data)
        {
            root.right = insert(root.right,data);
        }

        else if(data <= root.data)
        {
            root.left  = insert(root.left,data);
        }

        return root;
    }

    static void display(Node root)
    {
        if(root == null)
        {
            return;
        }

        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Node tree = null;
        
        tree = insert(tree,4);
        tree = insert(tree,5);
        tree = insert(tree,1);
        tree = insert(tree,2);

        tree = delete(tree,1);
        display(tree);
    }
    
}