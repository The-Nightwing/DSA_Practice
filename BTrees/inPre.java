
import java.util.*;

public class inPre{

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
    public static int findlinE(int[] in,int rootData)
    {
        for(int i=0;i<in.length;i++)
        {
            if(in[i]==rootData)
            {
                return i;
            }
        }
        return 0;
    }

    public static Node buildtree(int[] in,int[] pre,int inS,int inE,int preS,int preE) {

        if(inS>inE)
        {
            return null;
        }

        int rootData = pre[preS];
        int lPreS = preS+1;
        int rPreE = preE;
        int linS = inS;
        int linE = findlinE(in,rootData)-1; //rootindex-1
        int rinE = inE;

        int leftlen = findlinE(in,rootData)-linS;
        int rPreS = leftlen+2;
        int lPreE = leftlen+1;
        int rinS = findlinE(in,rootData)+2;

        Node tree = new Node(rootData);
        tree.left = buildtree(in,pre,linS,linE,lPreS,lPreE);
        tree.right = buildtree(in,pre,rinS,rinE,rPreS,rPreE);


        return tree;
    }
    public static void display(Node root)
    {
        if(root == null)
        {
            return;
        }

        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }

    //1-->



    public static void main(String[] args) {
        int[] in=new int[]{4,2,5,1,3};
        int[] pre = new int[]{1,2,4,5,3};
        int size = in.length;
        Node tree = null;

        tree = buildtree(in,pre,0,size-1,0,size-1);
        System.out.println(tree.data);
        display(tree);
    }
}