import java.util.*;

public class sumPair {
    static Node tree = null;
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    static ArrayList<Node> queue = new ArrayList<Node>();
    static Node takeInput(Node node){

        Scanner in = new Scanner(System.in);
        int rootData = in.nextInt();
        if(rootData==-1){
            return null;
        }
        Node tree = new Node(rootData);
        queue.add(tree);

        while(queue.size()!=0){
            Node front = queue.get(0);
            queue.remove(0);

            int leftChild = in.nextInt();

            if(leftChild!=-1){
                Node left = new Node(leftChild);
                front.left = left;
                queue.add(left);
            }
            int rightChild = in.nextInt();
            if(rightChild!=-1){
                Node right = new Node(rightChild);
                front.right = right;
                queue.add(right);
            }
        }
        return tree;
    }

    public static boolean search(Node root,int data){

    if(root == null){
        return false;
    }

    if (root.data == data) 
        return true; 
      
     if (root.data < data) 
        return search(root.right, data); 

     return search(root.left, data); 
    }

    static void pair(Node node, int data)
    {
        //System.out.println("h");
        if(node==null){
            return;
        }
        boolean f = false;
        int temp=data-node.data;

        if(temp > data/2)
            f= search(tree,(data-node.data));

        if(f) {
            System.out.print(node.data+" "+(data-node.data));
            System.out.println();
        }
        
        pair(node.left,data);
        pair(node.right,data);
    }

    public static void main(String[] args) {

        
        Scanner in = new Scanner(System.in);
        tree = takeInput(tree);

        int sum = in.nextInt();

        pair(tree,sum);

        
    }
    
}