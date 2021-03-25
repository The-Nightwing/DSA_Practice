
import java.util.*;

public class samplecn{

    static String s="";
    public static void index(int[] arr,int n,int x,int s1)
    {

       if(n==0) return;
       
       if(arr[s1]==x) 
       {
           s+=Integer.toString(s1)+" ";
       }
       s1+=1;

       index(arr,n-1,x,s1);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int[] arr=new int[size];
        for(int i = 0; i < size; i++)
        {
            arr[i]=in.nextInt();
        }
        int x = in.nextInt();
        
        index(arr,size,x,0);

        System.out.println(s);
    }
}