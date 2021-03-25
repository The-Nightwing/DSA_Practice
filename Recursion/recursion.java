
public class recursion 
{
    public static int digits(int x)
    {
        if(x/10==0)
        {
            return 1;
        }

        int ans = digits(x/10);

        return ans+1;
    }
    public static void main(String[] args) {
        int c = digits(15611);
        System.out.println(c);
    }
    
}

/*pow(3,0)
    pow(3,3)-->pow(3,2)-->pow(3,1)-->;
*/
