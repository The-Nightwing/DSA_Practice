import java.util.Scanner;

public class stack {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next=null;
        }
    }
    static Node top=null;
    static Node last=null;

    static void push(Node ll, int c)
    {
        if(top==null)
        {
            ll=new Node(c);
            top=ll;
            last=ll;
        }

        else{
            Node temp=new Node(c);
            temp.next=top;
            top = top.next;
            top = temp;
        }
    }

    public static void pop()
    {
        Node temp = top;
        top=top.next;
        temp.next=null;
    }

    public static void display()
    {
        Node show=top;

        while(show!=null)
        {
            System.out.print(show.data+" ");
            show=show.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n=in.nextInt();
        Node ll=null;
        for(int i=0;i<n;i++)
        {
            push(ll,in.nextInt());
        }

        display();
        System.out.println("Pop 1");
        pop();
        display();
        System.out.println("Pop 2");
        pop();
        display();
    }
    
}