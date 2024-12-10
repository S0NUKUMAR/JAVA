package dataStructure.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
       In Question , we have given that the weight is unit

       step 1: we will be using the BFS technique to solve this
       step 2: maintain the Queue
       step 3: do path relaxation on the queue elements
 */
public class ShortestPathUndirectedGraph {
    public static void main(String[] args) {
        Graph graph  = new Graph(9,10);
        graph.addEdges(0,1);
        graph.addEdges(0,3);
        graph.addEdges(2,1);
        graph.addEdges(3,1);
        graph.addEdges(2,6);
        graph.addEdges(4,3);
        graph.addEdges(4,5);
        graph.addEdges(6,5);
        graph.addEdges(7,8);
        graph.addEdges(7,6);
        graph.addEdges(8,6);

        BFSshortestDistance(graph);
    }

    private static void BFSshortestDistance(Graph graph) {
        Queue<Integer> queue = new LinkedList<>();

        int[] path = new int[graph.vertex];
        Arrays.fill(path , Integer.MAX_VALUE);

        path[0] = 0;
        queue.add(0);

        while (!queue.isEmpty()){
            int vertex = queue.poll();
            for (int v : graph.adj.get(vertex)){
                if(path[vertex]+1 < path[v]){
                    path[v] = path[vertex]+1;
                    queue.add(v);
                }
            }
        }
        for(int i=0 ; i< path.length ; i++){
            System.out.println(path[i]) ;
        }

    }
}
