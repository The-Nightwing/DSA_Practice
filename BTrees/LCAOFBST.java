
/*LCA of BST
Given a binary search tree and two nodes, find LCA(Lowest Common Ancestor) of the given two nodes in the BST. Read about LCA if you are having doubts about the definition.
If out of 2 nodes only one node is present, return that node.
If both are not present, return -1.
Input format :
Line 1 :  Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Two integers, Node 1 and Node 2 (separated by space)
Output Format :
LCA
Constraints :
1 <= N <= 1000
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 10
Sample Output 1:
8
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 6
Sample Output 2:
5
Sample Input 3:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12 78
Sample Output 3:
-1

*/

import java.util.*;

public class LCAOFBST {
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

    public static Node LCA(Node node,int n1,int n2){
        if(node==null){
            return null;
        }
        if(node.data == n1 || node.data == n2){
            return node;
        }

        Node leftsearch = LCA(node.left,n1,n2);
        Node rightsearch = LCA(node.right,n1,n2);

        if(leftsearch==null && rightsearch==null){
            return null;
        }
        else if(leftsearch == null){
            return rightsearch;
        }
        else if(rightsearch == null){
            return leftsearch;
        }

        return node;
    }

    public static void main(String[] args) {

        tree = takeInput();
        Scanner in=new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        Node ans = LCA(tree,n1,n2); 
        if(ans!=null){
            System.out.println(ans.data);  
        }   
        else System.out.println(-1);
    }
    
}