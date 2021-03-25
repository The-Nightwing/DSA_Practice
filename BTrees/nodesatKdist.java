/*
Print nodes at distance k from node
Given a binary tree, a node and an integer K, print nodes which are at K distance from the the given node.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Line 2 : Node

Line 3 : K

Output format : Answer nodes in different line

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
3
1
Sample Output :
9
6
 */
import java.util.*;
public class nodesatKdist {

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
    static Node takeInput(){

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

    static void down(Node root, int node, int k)
    {
        if(root==null || k<0){
            return;
        }

        if(k==0){
            System.out.println(root.data);
            return;
        }
        
        down(root.left,node,k-1);

        down(root.right,node,k-1);
    }

    static int find(Node root, int node, int k){ //distance between targetnode and root.
        if(root==null){
            return -1;
        }

        if(root.data==node){
            down(root,node,k);
            return 0;
        }

        int leftdistance = find(root.left,node,k);

        if(leftdistance!=-1){

            if(leftdistance+1==k){
                System.out.println(root.data);
            }

            else{
                find(root.right,node,k-leftdistance-2);
            }

            return 1+leftdistance;
        }

        int rightdistance = find(root.right,node,k);
        if(rightdistance!=-1){
            if(rightdistance+1==k){
                System.out.println(root.data);
            }
            else{
                find(root.left,node,k-rightdistance-2);
            }
            return 1+rightdistance;
        }

        return -1;
    }

    public static void main(String[] args) {
Scanner in = new Scanner(System.in);
        Node tree = null;
        tree = takeInput();

        int node = in.nextInt();
        int k = in.nextInt();

        
        int c = find(tree,node,k);
        
    }
    
}