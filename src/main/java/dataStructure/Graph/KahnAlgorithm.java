package dataStructure.Graph;

/*
    kahn is for topological sorting using BFS
    modified BFS , storing in-degree of the node
    Queue is used for the BFS
*/

import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgorithm {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6,6);

        graph.addEdges(5,0);
        graph.addEdges(4,0);
        graph.addEdges(5,2);
        graph.addEdges(2,3);
        graph.addEdges(3,1);
        graph.addEdges(4,1);

        int[] indegree = new int[6];
        Queue<Integer> queue = new LinkedList<>();

        //step 1: calculating the indegree of the graph
        for(int i = 0; i < 6 ; i++){
            for(int v : graph.adj.get(i)){
                indegree[v]++;
            }
        }
        //step 2 : add to queue which have 0 indegree
        for(int i = 0 ; i< 6 ;i++)
            if(indegree[i] == 0)
                queue.add(i);


        while (!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node);
            for (int v : graph.adj.get(node)){
                //step 3: decrease the indegree
                indegree[v]--;
                if(indegree[v]==0)
                    queue.add(v);
            }
        }
    }
}
