package dataStructure.Graph;

import java.util.*;

public class Traversal {
    public static void main(String[] args) {
        // index can be  0 based as well as 1 based
        // level order Traversal
        Graph graph = new Graph(6 , 6);
        graph.addEdges(1,2);
        graph.addEdges(3,2);
        graph.addEdges(1,3);

        graph.addEdges(4,3);
        graph.addEdges(4,5);
        graph.addEdges(6,5);


        BFSTraversal(graph);
        DFSTraversal(graph);
    }
    private static void DFSTraversal(Graph graph) {
        boolean[] vis = new boolean[graph.vertex + 1];
        DFS(1, vis, graph.adj);

    }
    private static void DFS(int i, boolean[] vis, ArrayList<ArrayList<Integer>>adj) {
        vis[i] = true;
        for (int vertex : adj.get(i)){
            if(!vis[vertex]) {
                DFS(vertex, vis, adj);
            }
        }
        System.out.print(i + " ");
    }

    private static void BFSTraversal(Graph graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        queue.add(1);
        vis.add(1);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for(int v : graph.adj.get(vertex)){
                if(!vis.contains(v)){
                    queue.add(v);
                    vis.add(v);
                }
            }
        }
        System.out.println();
    }
}
