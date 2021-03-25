import java.util.*;

public class LL1
{

    public static class Node
    {
        int data;
        Node next;

        public Node()
        {

        }
    }
    static Node head=null;
    static Node tail=null;
    static Node ll=null;
    public static void add(int n)
    {
        if(ll==null)
        {
            ll=new Node();
            ll.data = n;
            ll.next = null;
            head = ll;
            tail=ll;
        }

        else
        {
            Node temp = new Node();
            temp.data=n;
            temp.next=null;
            tail.next = temp;
            tail = tail.next;
            temp=tail;
            
        }

    }

    public static void display(Node show)
    {
       if(show!=null)
       {
           System.out.print(show.data+" ");
           display(show.next);
       }

    }

    public static void delf()
    {
        Node temp = head;
        head=head.next;
        temp.next=null;
    }

    public static void delLast()
    {
        Node last = tail;
        Node secondlast = head;

        while(secondlast.next!=last)
        {
            secondlast = secondlast.next;
        }

        secondlast.next=null;
        secondlast = tail;
    }

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);

        int n=in.nextInt();
        
        for(int i=0;i<n;i++)
        {
            add(in.nextInt());
        }

        delLast();
        display(head);
    }
}