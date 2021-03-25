import java.util.*;

public class LL2 {

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
 //  1-->2-->3-->4-->5 
    public static void reverse(int n)
    {
        Node prev = head;
        Node current  = head.next;
        head=head.next;
        current = head;
        prev.next=null;

        while(head!=null)
        {
            head = head.next;
            current.next = prev;
            prev = current;
            current = head;
        }

        head  = prev;
    }

    public static void add(int n)
    {
        if(ll==null)
        {
            ll=new Node();
            ll.data = n;
            ll.next = null;
            head = ll;
            tail = ll;
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
    public static void display()
    {
        Node show = head;

        while(show!=null)
        {
            System.out.print(show.data+" ");
            show=show.next;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n=in.nextInt();
        
        for(int i=0;i<n;i++)
        {
            add(in.nextInt());
        }

        reverse(n);
        display();
    }
    
}