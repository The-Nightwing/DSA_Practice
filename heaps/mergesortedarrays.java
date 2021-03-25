/*Merge K sorted arrays
Given k different arrays, which are sorted individually (in ascending order). You need to merge all the given arrays such that output array should be sorted (in ascending order).
Hint : Use Heaps.
Input Format :
Line 1 : Integer K
Line 2 : Arrays 1 size (n1)
Line 3 : Array 1 elements (separated by space)
Line 4 : Array 2 size (n2)
and so on for next arrays
Sample Input 1 :
4
3
1 5 9
2
45 90
5
2 6 78 100 234
1
0
Sample Output 1 :
0 1 2 5 6 9 45 78 90 100 234

*/



import java.util.*;

public class mergesortedarrays{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5,new Comparator<Integer>(){
    @Override
        public int compare(Integer a, Integer b){
            if(b>a) return -1;
            else return 1;
        }
    });

    for(int i=0;i<k;i++){
        int n=in.nextInt();

        for(int j=0;j<n;j++){
            pq.add(in.nextInt());
        }
    }

    while(pq.size()!=0){
        System.out.print(pq.poll()+" ");
    }
    }
}