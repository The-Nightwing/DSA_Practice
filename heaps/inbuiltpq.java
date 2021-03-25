
import java.util.*;

public class inbuiltpq {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        PriorityQueue<Integer> pqmax = new PriorityQueue<Integer>(n,new Comparator<Integer>(){
            @Override 
            public int compare(Integer a, Integer b){
                if(b>a) return 1;
                else return -1;
            }
        });
        for(int i=0;i<n;i++){
            pqmax.add(in.nextInt());
        }

       while(pqmax.size()!=0){
           System.out.print(pqmax.poll()+" ");
       }
    }
}