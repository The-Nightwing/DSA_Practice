
import java.util.*;

public class strinlen{

    static String peek = "";
    static String ans = "";

    public static String duplicates(String str)
    {
        if(str.length()<=1)
        {
            return str;
        }

        if(str.substring(0,1).equals(str.substring(1,2))){

            return duplicates(str.substring(1));

        }

        else{
            return str.charAt(0)+duplicates(str.substring(1));
        }

    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        
       
        System.out.println(duplicates(s));

        in.close();

    }
}