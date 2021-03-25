import java.util.*;

public class LL4 {
    //circular linkedlist

    public static class Node
    {
        int data;
        Node next;
        
        public Node(int data)
        {
            this.data = data;
        }
    }
    static Node head=null;
    static Node tail = null;

    public static void add(Node ll,int n)
    {
        if(ll == null)
        {
            ll=new Node(n);
            ll.next = null;
            head = ll;
            tail = ll;
        }

        else
        {
            Node temp = new Node(n);
            temp.next = null;
            tail.next = temp;
            tail = tail.next;
            tail = temp;
        }

        tail.next = head; //circluar linked list;
    }

    public static void display()
    {
        Node show = head;

        while(show!=tail)
        {
            System.out.println(show.data+" ");
            show = show.next;
        }

    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int n= in.nextInt();
        Node ll=null;

        for(int i=0;i<n;i++)
        {
            add(ll, in.nextInt());
        }
        display();

        System.out.println("tail->"+tail.data);
    }

    
}