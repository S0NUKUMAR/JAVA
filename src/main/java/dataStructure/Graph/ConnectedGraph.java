package dataStructure.Graph;
/*
    Check if the graph is connected or not
        step 1: create a boolean array of size vertex + 1
        step 2: for each vertex check if it is not visited then do bfs and mark all the connected vertex as visited
        step 3: if we are able to visit all the vertex then return true
        step 4: else return false

 */

import java.util.ArrayList;

public class ConnectedGraph {
    static int component = 0;
    public static void main(String[] args) {
        Graph graph = new Graph(6 , 6);
        graph.addEdges(1,2);
        graph.addEdges(3,2);
        graph.addEdges(1,3);

        graph.addEdges(4,3);
        graph.addEdges(4,5);
        graph.addEdges(6,5);

        boolean isConnected = checkConnected(graph);
        System.out.println(isConnected);
        System.out.println(component);
    }
    private static boolean checkConnected(Graph graph) {
        boolean[] vis = new boolean[graph.vertex + 1];
        for(int i = 0 ; i <= graph.vertex; i++) {
            for (int j = 0; j < graph.adj.get(i).size(); j++)
                if(!vis[graph.adj.get(i).get(j)]) {
                    bfsCheck(graph.adj.get(i).get(j), vis, graph.adj);
                    component++;
                }
        }
        return  component > 0;
    }

    private static void bfsCheck(int i, boolean[] vis, ArrayList<ArrayList<Integer>>adj) {
        vis[i] = true;
        for (int vertex : adj.get(i)){
            if(!vis[vertex]) {
                bfsCheck(vertex, vis, adj);
            }
        }
    }
}
