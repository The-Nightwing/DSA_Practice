public class sorted {

    int pointer = 0;

    public static boolean isSorted(int[] arr, int n)
    {
        if(n==0 || n==1)
        {
            return true;
        }

        if(arr[n-2]>arr[n-1]) return false;

        boolean ans = isSorted(arr,n-1);
    
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};

        System.out.println(isSorted(arr,arr.length));
    }
    
}