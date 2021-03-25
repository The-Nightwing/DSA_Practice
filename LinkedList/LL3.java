import java.util.Scanner;


public class LL3 {

    public static class Node
    {
        int data;
        Node prev;
        Node next;

        public Node(int data)
        {
            this.data = data;
        }
    }
    static Node head=null;
    static Node tail=null;

    public static void add(Node ll,int c)
    {
        if(head == null)
        {
            ll=new Node(c);
            head=tail=ll;
            head.prev=null;
            tail.next = null;
            
        }

        else
        {
            Node temp = new Node(c);
            tail.next = temp;
            temp.prev = head;
            tail = tail.next;
            tail = temp;
            temp.next = null;
        }
    }

    public static void display(Node ll)
    {
        Node show=head;

        while(show!=null)
        {
            System.out.print(show.data+" ");
            show = show.next;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Node ll=null;
        for(int i=0;i<n;i++)
        {
            add(ll,in.nextInt());
        }

        display(ll);
    }
    
}