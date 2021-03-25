import java.util.*;

public class codeforces
{
    public static String str="";
    public static String f="";

    public static void encode(int n, String s)
    {
       int idx= (n+1)/2;
       idx-=1;
    //logva 
       if(s.length()!=0)
       {      
           f+=s.substring(0,idx)+s.substring(idx+1);
           System.out.println(f);
           str+=s.charAt(idx);
           encode(f.length(),f);
       }
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        String s=in.next();

        encode(n,s);
        
    }
}