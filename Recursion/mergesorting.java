
import java.util.*;

public class mergesorting {

    public static void merge(int[] input,int si, int ei)
    {
        int i=si;
        int mid=(si+ei)/2;
        int k=si;
        int output[] = new int[1000];
        int j=mid+1;
          while(i<=mid&&j<=ei)
        {        
          if(input[i]>=input[j])
         {
             output[k++]=input[j++];
         }
         else
             output[k++]=input[i++];
          
           }     
        while(i<=mid)
        {
            
            output[k++]=input[i++];
        }
        while(j<=ei)
        {
            output[k++]=input[j++];
        }
    
        
        for(i=si;i<=ei;i++)
         input[i]=output[i];
    }

    public static void sort(int[] arr, int l,int r)
    {
        if(l>=r) return;

        int mid = (l+r)/2;

        sort(arr,l,mid);
        sort(arr,mid+1,r);

        merge(arr,l,r);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[]{7,1,5,6,3,2,10,9};

        sort(arr,0,arr.length-1);

        for(int i = 0; i < arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
}