package dataStructure.Graph;

/*
    step 1: create a priority queue
    step 2: create a path array and fill with max value
    step 3: add the first node to the queue
    step 4: while queue is not empty
        step 5: get the node from queue
        step 6: get the all adjacent node of the current node
        step 7: if the weight of the adjacent node + path of current node is less than the path of adjacent node then update the path of adjacent node
        step 8: add the adjacent node to the queue
    step 9: print the path array
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        UnDirectedWeightedGraph graph = new UnDirectedWeightedGraph(6,8);
        graph.addEdges(0,1 , 4);
        graph.addEdges(0,2 , 4);
        graph.addEdges(2,1 , 2);
        graph.addEdges(2,3 , 3);
        graph.addEdges(2,5 , 6);
        graph.addEdges(2,4 , 1);
        graph.addEdges(3,5 , 2);
        graph.addEdges(4,5 , 3);

        DijkastrasShortestPath(graph);
    }

    private static void DijkastrasShortestPath(UnDirectedWeightedGraph graph) {
                PriorityQueue<WeightNode> pq = new PriorityQueue<>(Comparator.comparingInt(u -> u.w));

        int[] path = new int[graph.vertex];
        Arrays.fill(path, Integer.MAX_VALUE);

        path[0] = 0 ;

        pq.add(new WeightNode(0,0));

        while(!pq.isEmpty()){
            int ver = pq.peek().v;
            pq.poll();

            for(WeightNode curr : graph.adj.get(ver)){
                int currver = curr.v;
                int currwei  = curr.w;
                if(currwei + path[ver]< path[currver]){
                    path[currver] = currwei + path[ver];
                    pq.add(new WeightNode(currver, path[currver]));
                }
            }
        }

        for (int i = 0 ; i< graph.vertex ; i++) {
            System.out.println(path[i]);
        }
    }
}
