
/*Return Permutations - String
Given a string S, find and return all the possible permutations of the input string.
Note 1 : The order of permutations is not important.
Note 2 : If original string contains duplicate characters, permutations will also be duplicates.
Input Format :
String S
Output Format :
All permutations (in different lines)
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba
 */
import java.util.*;

public class permutations {

    static void subs(String s,int l,int r){
        if(l==r){
            System.out.println(s);
            return;
        }

        for(int i=0;i<s.length();i++){
            s = interchange(s,l,i);
            subs(s,l+1,r);
            s = interchange(s,l,i);
        }
    }

    static String interchange(String s,int a ,int b){
        char[] str = s.toCharArray();

        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;

        return String.valueOf(str);
    }


    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String s = in.next();
        subs(s,0,s.length()-1);in.close();
    }
    
}