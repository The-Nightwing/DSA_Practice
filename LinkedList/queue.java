import java.util.*;

public class queue
{
    static class Node {

        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            next = null;
        }

    }

    static Node front=null;
    static Node last=null;

    static void add(Node ll,int c)
    {
        if(front==null)
        {
            ll = new Node(c);
            front = ll;
            last =  ll;
        }

        else{
            Node temp = new Node(c);
            last.next = temp;
            last = last.next;
            last = temp;
        }
    }

    static void enqueue(int c)
    {

        Node temp = new Node(c);
        last.next=temp;
        last=last.next;
        last = temp;

    }
    public static void display()
    {
        Node show=front;

        while(show!=null)
        {
            System.out.print(show.data+" ");
            show = show.next;
        }

        System.out.println();
    }

    public static void dequeue()
    {
        Node temp = front;
        front = front.next;
        temp.next = null;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Node ll=null;
        for(int i=0;i<n;i++)
        {
            add(ll,in.nextInt());
        }

        display();
        
        System.out.println("For enqueue");

        int c=in.nextInt();
        enqueue(c);

        dequeue();
        dequeue();
        dequeue();

        display();
    }
}