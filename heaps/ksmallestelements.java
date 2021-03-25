
import java.util.*;

public class ksmallestelements {

    public static void main(String[] args) {
        
    
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5,new Comparator<Integer>(){
    @Override
        public int compare(Integer a, Integer b){
            if(b>a) return 1;
            else return -1;
        }
    });

    int[] arr = new int[]{1,10,2,11,9,8,110,20};
    Scanner in = new Scanner(System.in);
    int k = in.nextInt();
    int n = arr.length;

    for(int i=0;i<k;i++){
        pq.add(arr[i]);
    }

    for(int i=k;i<n;i++){
        pq.add(arr[i]);
        pq.poll();
    }

    for(int i=0;i<k;i++){
        arr[i] = pq.poll();
    }

    for(int i=k-1;i>=0;i--){
        System.out.print(arr[i]+" ");
    }
}
}