
import java.util.*;

public class subset {

    static void subsetf(int[] arr,int idx,ArrayList<Integer> list,int k){

        print(list,k);

        for(int i=idx;i<arr.length;i++){
            // include the A[i] in subset
            list.add(arr[i]);

            // move onto the next element
            subsetf(arr,i+1,list,k); //backtracking

            // exclude the A[i] from subset and triggers 
            // backtracking. 
            list.remove(list.size()-1);
        }

        return;

    }

    static void print(ArrayList<Integer> list,int k){
        int sum = 0;
        for(int i=0;i<list.size();i++){
           sum+=list.get(i);
        }

        if(sum==k){
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>();

        subsetf(arr,0,list,k);
    }
    
}