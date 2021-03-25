import java.util.*;


public class cb
{
    public static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data=data;
            next=null;
        }

        public Node()
        {

        }
    }
    static Node head;
    static Node tail;
    static int size=0;

    public static void insert(Node ll,int data)
    {
        Node temp=new Node(data);

        if(size==0)
        {
            head=temp;
            tail=temp;
            size++;
        }
        else
        {
            tail.next=temp;
            tail=temp;
            size++;
        }
    }

    public static void display(Node ll)
    {
        Node s=head;

        while(s!=null)
        {
            System.out.print(s.data+" ");
            s=s.next;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        Node ll=new Node();

        insert(ll,10);
        insert(ll,20);
        insert(ll,30);
        insert(ll,40);

        display(ll);

    
    }
}