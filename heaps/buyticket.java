import java.util.PriorityQueue;
import java.util.Scanner;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

/*Buy the ticket
You want to buy a ticket for a well-known concert which is happening in your city. But the number of tickets available is limited. Hence the sponsors of the concert decided to sell tickets to customers based on some priority.
A queue is maintained for buying the tickets and every person has attached with a priority (an integer, 1 being the lowest priority). The tickets are sold in the following manner -
1. The first person (pi) in the queue asked to comes out.
2. If there is another person present in the queue who has higher priority than pi, then ask pi to move at end of the queue without giving him the ticket.
3. Otherwise, give him the ticket (and don't make him stand in queue again).
Giving a ticket to a person takes exactly 1 minutes and it takes no time for removing and adding a person to the queue. And you can assume that no new person joins the queue.
Given a list of priorities of N persons standing in the queue and the index of your priority (indexing starts from 0). Find and return the time it will take until you get the ticket.
Input Format :
Line 1 : Integer N (Total number of people standing in queue)
Line 2 : Priorities of every person (n space separated integers)
Line 3 : Integer k (index of your priority)
Output Format :
Time required
Sample Input 1 :
3
3 9 4
2
Sample Output 1 :
2
Sample Output 1 Explanation :
Person with priority 3 comes out. But there is a person with higher priority than him. So he goes and then stands in the queue at the end. Queue's status : {9, 4, 3}. Time : 0 secs.
Next, the person with priority 9 comes out. And there is no person with higher priority than him. So he'll get the ticket. Queue's status : {4, 3}. Time : 1 secs.
Next, the person with priority 4 comes out (which is you). And there is no person with higher priority than you. So you'll get the ticket. Time : 2 secs.
Sample Input 2 :
5
2 3 2 2 4
3
Sample Output 2 :
4
*/
import java.util.*;
public class buyticket{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();

        ArrayList<Integer> q = new ArrayList<Integer>();

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5,new Comparator<Integer>(){
        @Override
            public int compare(Integer a, Integer b){
                if(b>a) return 1;
                else return -1;
            }
        });

        for(int i=0;i<n;i++){
            q.add(in.nextInt());
            pq.add(q.get(i));
        } 

        int k = in.nextInt();
        //System.out.println(pq.peek());
        int time = 0;
        
        while(pq.size()!=0){
            int c = q.get(0);

            if(c >= pq.peek()){

                if(k==0){
                    time++;
                    break;
                }
                time++;
                q.remove(0);
                pq.poll();
                k--;
                
            }

            else{
                q.add(q.get(0));
                q.remove(0);
                if(k==0) {
                    k = q.size()-1;
                }
                else{
                    k--;
                }
            }
        }

        System.out.println(time);
    }
}