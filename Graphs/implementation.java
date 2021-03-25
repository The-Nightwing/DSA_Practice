import java.util.*;


class Node{
    int u;
    int weight;
    public Node(int u,int weight){
        this.u = u;
        this.weight = weight;
    }
}

public class implementation{

    public static void bfs_search(ArrayList<ArrayList<Node>> graph,int s,boolean[] new_visited){

        boolean visited[] = new boolean[graph.size()+1];
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(s);
        visited[s] = true;

        while(queue.size()!=0){
            int u = queue.poll();
            System.out.println(u+" ");
            for(Node edge:graph.get(u)){
                if(!visited[edge.u]){
                    queue.add(edge.u);
                    visited[edge.u]=true;
                }
            }
        }
    }

    public static void bfs_dis(ArrayList<ArrayList<Node>> graph){ //for disconnected graphs.
        boolean visited[] = new boolean[graph.size()+1];//no. of vertices

        for(int i=0;i<visited.length;i++){
            if(visited[i]==false)
                bfs_search(graph,i,visited);
        }
    }

    public static void addEdge(ArrayList<ArrayList<Node>> graph,int u,int v,int w){
        graph.get(u).add(new Node(v,w));
        graph.get(v).add(new Node(u,w));
    }

    public static void removeEdge(ArrayList<ArrayList<Node>> graph,int u, int v){
        
        for(int i=0;i<graph.get(u).size();i++){
            if(graph.get(u).get(i).u==v){
                graph.get(u).remove(i);
                break;
            }
        }

        for(int i=0;i<graph.get(v).size();i++){
            if(graph.get(v).get(i).u==u){
                graph.get(v).remove(i);
                break;
            }
        }
      
    }

    public static void main(String[] args) {
        Scanner in  =  new Scanner(System.in);

        int edges = in.nextInt();
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for(int i=0;i<edges;i++){
            int u=in.nextInt();
            int v =in.nextInt();
            int w = in.nextInt();

            addEdge(graph,u,v,w);
        }

        in.close();
    }
}