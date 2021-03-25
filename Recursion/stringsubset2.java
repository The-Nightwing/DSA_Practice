
//same for array
import java.util.*;

public class stringsubset2 {

    static void sub(String s,String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }

        sub(s.substring(1),ans); //not including
        sub(s.substring(1),s.substring(0,1)+ans); //including
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        String s = in.next();
        String ans = "";
        sub(s,ans);
    }
}