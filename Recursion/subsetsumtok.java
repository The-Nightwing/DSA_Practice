/*Return subsets sum to K
Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.
Input format :
Line 1 : Integer n, Size of input array
Line 2 : Array elements separated by space
Line 3 : K 
Constraints :
1 <= n <= 20
Sample Input :
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output :
3 3
5 1

*/
import java.util.*;

public class subsetsumtok{

    static void print(ArrayList<Integer> list,int k){
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum+= list.get(i);
        }
        if(sum==k){
           
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
        }
    }
    static void find(int[] arr,int idx,ArrayList<Integer> list,int k){

      if(idx==arr.length){
         print(list,k);
      }

      else{
        ArrayList<Integer> list2 = (ArrayList)list.clone();

        find(arr,idx+1,list,k); //not including
        list2.add(arr[idx]);
        find(arr,idx+1,list2,k); //including

    }
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        int k = in.nextInt();

        find(arr,0,list,k);
    }
}
