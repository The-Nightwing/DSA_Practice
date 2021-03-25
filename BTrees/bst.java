import java.util.*;
import java.lang.Math;

public class bst {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    static Node node;
    static Node tree;

    public static Node buildbst(int[] arr, int l,int r)
    {
        if(l>r)
        {
           return null;
        }

        int mid = (r+l)/2;

        Node node = new Node(arr[mid]);


        node.left = buildbst(arr,l,mid-1);
        node.right = buildbst(arr,mid+1,r);

        return node;
    }

    public static void display(Node tree)
    {
        if(tree == null)
        {
            return;
        }

        display(tree.left);
        System.out.print(tree.data+" ");
        display(tree.right);
    
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        tree = buildbst(arr,0,arr.length-1);
        display(tree);
    }
    
}