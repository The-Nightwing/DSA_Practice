public class fibo {

    public static int fibona(int n)
    {
        if(n==0) 
        {
            return 1;
        }
        if(n==1)
        {
            return 1;
        }

        return fibona(n-2)+fibona(n-1);
    }
    public static void main(String[] args) {
        int k = fibona(2);
        System.out.println(k);
    }
    
}