

import java.util.*;

public class heapsort {
    public static void heapify(int[] arr, int n,int i){

        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left < n && arr[left] > arr[largest])
            largest = left;
        
        if(right < n && arr[right] > arr[largest])
            largest = right;

        if(largest!=i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr,n,largest);
        }

    }

    static void buildheap(int[] arr,int n){

        int lastnonleafnode = (n/2)-1;

        for(int i = lastnonleafnode;i>=0;i--){
            heapify(arr,n,i);
        }
    }

    static void sort(int[] arr,int n){
        
        for(int i=n-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,i,0);
        }
    }


    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        int[] arr = new int[]{2,11,6,8,5,4,3};

        int  n = arr.length;
        int f = n;

        buildheap(arr,n);

        for(int i =0; i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
       
        sort(arr,n);

        for(int i=0;i<f;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
}