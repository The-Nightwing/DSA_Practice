import java.lang.Math;
import java.util.*;

public class subsequence {


    public static int subs(String str,String[] output)
    {
        if(str.length()==0)
        {
            output[0]="";
            return 1;
        }

        int smalloutputsize = subs(str.substring(1),output);

        for(int i = 0; i<smalloutputsize; i++)
        {
            output[smalloutputsize+i] = str.charAt(0)+output[i];
        }
    return 2*smalloutputsize;
    }
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        String str = in.nextLine();

        String[] output = new String[(int)Math.pow(2,str.length())];

        int c = subs(str,output);

        for(int i=1;i<c;i++)
        {
            System.out.println(output[i]+" ");
        }
        in.close();
    }
}