package dataStructure.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 bipartite graph is if we can color all graph with 2 color only and not two adjacent have same color
       1. all non-cyclic(linear) graph is bipartite
       2. if graph is having even no of edges in cycle then bipartite

    step 1: create a visited array and fill with -1 , REASON: we have to color the node with 2 color so we can use 0 and 1
    step 2: create a queue and add the first node
    step 3: while queue is not empty
        step 4: get the node from queue
        step 5: get the all adjacent node of the current node
        step 6: if the adjacent node is not visited then add to queue and color it with different color
        step 7: if the adjacent node is visited and the color is same then return false
        step 8: if the adjacent node is visited and the color is different then continue
    step 9: return true
*/
public class BipartiteGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(6 , 6);
        graph.addEdges(1,2);
        graph.addEdges(3,2);
        graph.addEdges(1,3);

        graph.addEdges(4,3);
        graph.addEdges(4,5);
        graph.addEdges(6,5);

        boolean isBipartite = BFSPartiteCheck(graph.adj);
        System.out.println(isBipartite);

        int[] vis = new int[graph.adj.size()] ;
        Arrays.fill(vis , -1);
        boolean isBipartiteDFS = DFSPartiteCheck(1 , 0 , vis , graph.adj);
        System.out.println(isBipartiteDFS);
    }

    private static boolean DFSPartiteCheck(int node , int color , int[] vis , ArrayList<ArrayList<Integer>> adj) {
       vis[node] = color == 0 ? 1 : 0;

        for(Integer v : adj.get(node)){
            if(vis[v]==-1){
                vis[v] = vis[node] == 1 ? 0 : 1 ;
                if(DFSPartiteCheck(v , vis[v] , vis , adj)){
                    return true;
                }
            }
            else if(vis[v] == vis[node]){
                return true;
            }
        }
        return  false;
    }
    private static boolean BFSPartiteCheck(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        int[] vis = new int[adj.size()] ;
        Arrays.fill(vis , -1);
        queue.add(1);
        vis[1] = 0;

        while (!queue.isEmpty()){
            int node =  queue.peek();
            queue.poll();

            for(Integer v : adj.get(node)){
                if(vis[v]==-1){
                    queue.add(v);
                    vis[v] = vis[node] == 1 ? 0 : 1 ;
                }
                else if(vis[v] == vis[node]){
                    return true;
                }
            }

        }
        return  false;
    }
}
