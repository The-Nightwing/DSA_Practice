import java.util.*;

/*Pair sum in a BST
Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space only O(log n).
Assume BST contains all unique elements.
Note: In a pair, print the smaller element first.
Input format:

Line 1: Elements in the level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Line 2: S

Output format: Each pair in a different line (pair elements separated by space)

Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output
2 10
5 7

*/

public class pairsumBST {

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

    static ArrayList<Integer> sorted = new ArrayList<Integer>();

    static void sort(Node node){
        if(node==null){
            return;
        }

        sort(node.left);
        sorted.add(node.data);
        sort(node.right);
    }

    static void printPair(ArrayList<Integer> list,int s){

        int i =0;
        int j = list.size()-1;
        while(i<j){

            if(list.get(i)+list.get(j) > s){
                j--;
            }
            else if(list.get(i)+list.get(j) < s){
                i++;
            }
            else{
              System.out.println(list.get(i)+" "+list.get(j));
              i++;
              j--;
            }
        }

    }

    public static void main(String[] args) {

        Node tree = null;
        tree = takeInput(tree);
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        sort(tree);
        printPair(sorted,s);
        
    }
    
}