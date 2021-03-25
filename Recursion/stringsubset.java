
import java.util.*;

public class stringsubset {

    static void sub(char[] s,int idx,String ans){

       System.out.println(ans);

        for(int i=idx;i<s.length;i++){
            ans+=Character.toString(s[i]);
            sub(s,idx+1,ans);
            ans = ans.substring(0,ans.length()-1); //not including last.
        }

    }

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        char[] string = s.toCharArray();
        String ans = ""; 

        sub(string,0,ans);
    }
    
}