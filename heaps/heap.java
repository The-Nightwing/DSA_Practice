import java.util.Scanner;

public class heap {


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

    public static void upheapify(int[] arr,int n,int i){

        int parent  = (i-1)/2;

        if(arr[parent]>0){
            if(arr[i]>arr[parent]){
                int swap = arr[i];
                arr[i] = arr[parent];
                arr[parent] = swap;

                upheapify(arr,n,parent);
            }
        }

    }
    public static void insert(int[] arr,int n,int data){
        n++;
        arr[n-1] = data;
        upheapify(arr,n,n-1);
    }



    static void delete(int[] arr,int n,int data){
        arr[0] = arr[n-1];
        n--;
        heapify(arr,n,0);
    }



    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);   
        int size = in.nextInt();
        int[] arr = new int[10000];

        for(int i=0;i<size;i++){
            arr[i] = in.nextInt();
        }

        buildheap(arr,arr.length);
        insert(arr,size,12);
        insert(arr,size,100);


        delete(arr,size,100);

        System.out.println(arr[0]);
    }
}