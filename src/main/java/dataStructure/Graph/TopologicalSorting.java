package dataStructure.Graph;

import java.util.HashSet;
import java.util.Stack;


/*
    step 1: create a graph
    step 2: create a stack and visited set
    step 3: iterate over the graph and call the DFS function
    step 4: in DFS function add the node to visited set and iterate over the adj list of the node
    step 5: if the node is not visited then call the DFS function
    step 6: add the node to stack
    step 7: print the stack

 */
public class TopologicalSorting {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6,6);

        graph.addEdges(5,0);
        graph.addEdges(4,0);
        graph.addEdges(5,2);
        graph.addEdges(2,3);
        graph.addEdges(3,1);
        graph.addEdges(4,1);

        HashSet<Integer> vis = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < 6 ; i++)
            if(!vis.contains(i))
                DFSCheck(graph,i,vis,stack);

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }


    private static void DFSCheck(DirectedGraph graph,int node, HashSet<Integer> vis, Stack<Integer> stack) {
        vis.add(node);
        for(Integer v : graph.adj.get(node)) {
           if(!vis.contains(v)){
               DFSCheck(graph,v,vis,stack);
           }
        }
        stack.add(node);
    }


    /*
         the BFS version is known as Kahn's algorithm , which uses the indegree of the node
            and the queue for the BFS
     */
}
