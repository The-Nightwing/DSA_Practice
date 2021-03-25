
import java.util.*;

public class keypad {

    static String[] arr =new String[]{" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static ArrayList<String> list = new ArrayList<>();

    public static void key(String n, String output)
    {
        
       if(n.length()==0)
       {
           list.add(output);
           return;
       }
       int f  = Integer.parseInt(n.substring(0,1));
       for(int i=0;i<arr[f].length();i++)
       {
            key(n.substring(1),output+arr[f].charAt(i));
       }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        if(n==0 || n==1)
        {
            System.out.println("");
            System.exit(0);
        }
        String n1 = Integer.toString(n);

        key(n1,"");

    for(int i=0;i<list.size();i++)
    {
        System.out.println(list.get(i));
    }

    in.close();

}
    
}