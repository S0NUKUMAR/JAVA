package dataStructure.Graph;

/*
    The question gives us the graph with weight , we need to create the graph adj list of u -> {v,w}

    step 1: calculate the topological sort for the graph to determine the order in which node can reach into the stack
    step 2: now pop out of stack and do the path relaxation (i.e calculating min from u -> v and v->i->v)
    step 3: update the minimum , do 2 and 3 step until stack is empty .
    step 4: if the path has infinity value then the node is not reachable from source .
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class ShortestPathDirectedGraph {
    public static void main(String[] args) {
        DirectedWeightedGraph graph = new DirectedWeightedGraph(7 , 8);
        graph.addEdges(0,1,2);
        graph.addEdges(1,3,1);
        graph.addEdges(2,3,3);
        graph.addEdges(4,0,3);
        graph.addEdges(4,2,1);
        graph.addEdges(5,4,1);
        graph.addEdges(6,4,2);
        graph.addEdges(6,5,3);


        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> vis = new HashSet<>();
        for (int i = 0 ; i < 7 ; i++) {
            if(!vis.contains(i))
                TopologicalSortingFun(graph.adj, i, vis, stack);
        }

        int[] path = new int[7];
        Arrays.fill(path , Integer.MAX_VALUE);

        path[6] = 0;
        pathRelaxation(stack , path , graph);

    }

    private static void pathRelaxation(Stack<Integer> stack, int[] path, DirectedWeightedGraph graph) {
        while (!stack.isEmpty()){
            int node = stack.pop();
            for(WeightNode v : graph.adj.get(node)){
                int vertex = v.v;
                int weight = v.w;

                if(weight + path[node] < path[vertex]){
                    path[vertex] = weight + path[node];
                }
            }
        }

        for (int i = 0 ; i < 7 ; i++){
            System.out.println(path[i]);
        }

    }

    private static void TopologicalSortingFun(ArrayList<ArrayList<WeightNode>> adj, int node, HashSet<Integer> vis, Stack<Integer> stack) {
        vis.add(node);

        for(WeightNode v : adj.get(node)){
            int  vertex = v.v;
            if(!vis.contains(vertex))
               TopologicalSortingFun(adj, vertex , vis , stack);
        }
        stack.add(node);
    }
}
