package dataStructure.Graph;
/*
    single source shortest path to all other vertices
        step 1: initialize the path array with the max value
        step 2: relax the path for all the edges
        step 3: repeat the step 2 for v-1 times
        step 4: if we are able to relax the path in the vth iteration then there is a negative cycle

 */

import java.util.Arrays;
public class BellmanFord {
    public static void main(String[] args) {
        DirectedWeightedGraph graph = new DirectedWeightedGraph(6, 7);
        graph.addEdges(3,2,6);
        graph.addEdges(5,3,1);
        graph.addEdges(0,1,5);
        graph.addEdges(1,5,-3);
        graph.addEdges(1,2,-2);
        graph.addEdges(3,4,-2);
        graph.addEdges(2,4,3);

        BellmanFordFunc(graph);
    }

    private static void BellmanFordFunc(DirectedWeightedGraph graph) {
        int[] path = new int[graph.vertex];
        Arrays.fill(path,Integer.MAX_VALUE);
        path[0] = 0;
        for(int j=0 ; j < graph.vertex -1   ; j++){
            for(int i=0 ; i < graph.vertex ; i++){
                for(WeightNode v : graph.adj.get(i)){
                    if(path[v.v]==Integer.MAX_VALUE && v.w + path[i] < path[v.v]){
                        path[v.v] = v.w + path[i];
                    }
                }
            }
        }

        for(int i=0 ; i < graph.vertex ; i++){
            System.out.println(path[i]);
        }
    }
}
