public class quicksort {


    public static int partition(int[] arr,int si,int ei)
    {
        
        int c=0;
        for(int i=si+1;i<arr.length;i++)
        {
            if(arr[si]>arr[i])
                c++;
        }

        int temp1 = arr[si];
        arr[si] = arr[si+c];
        arr[si+c] = temp1;

        int i=si;
        int j=ei;

        while(i<(si+c) && j>(si+c))
        {
            if(arr[i]<arr[si+c])
                i++;
            
            else if (arr[j] >= arr[si+c])
                j--;
            
            else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        return si+c;


    }



    public static void qs(int[] arr,int l,int r)
    {
        if(l>=r)
        {
            return ;
        }

        int c = partition(arr,l,r);
        qs(arr,l,c-1);
        qs(arr,c+1,r);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,3,2,5,10,9,6,7};

        qs(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}