public class sample {

    public static int fibona(int n)
    {
        if(n==0) 
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }

        int a1 = fibona(n-1);
        int a2 = fibona(n-2);

        return a1+a2;
    }
    public static void main(String[] args) {
        System.out.println(fibona(3));
    }
    
}