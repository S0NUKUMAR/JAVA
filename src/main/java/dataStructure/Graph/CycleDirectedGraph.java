package dataStructure.Graph;

import java.util.*;

/*
    this is the DFS version of the DAG cycle check , for BFS based solution we have kahn algo modified
    if the elements returns of the sout printed there is not equal to the no of vertices then the cycle is there

    step 1: create a vis set and pathVis set
    step 2: for each node check if it is not visited then do the dfs check
    step 3: if the node is not visited then add to vis and pathVis
    step 4: for each adjacent node check if it is not visited then do the dfs check
    step 5: if the adjacent node is visited then check if it is in pathVis then return true
    step 6: if the adjacent node is not visited then do the dfs check
    step 7: remove the node from pathVis
    step 8: return false

 */
public class CycleDirectedGraph {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6 , 6);
        graph.addEdges(1,2);
        graph.addEdges(2,3);
        graph.addEdges(3,1);

        graph.addEdges(4,3);
        graph.addEdges(4,5);
        graph.addEdges(6,5);
        /* vis alone is not enough as we can come from other path and will see the vis true which is not right */
        Set<Integer> vis = new HashSet<>(), PathVis = new HashSet<>();
        boolean isCycle = DirectedDFScheck(1 , -1 , vis , PathVis , graph.adj);
        boolean isCycleBfs = DirectedBFScheck(graph.adj);
        System.out.println(isCycle);
    }

    private static boolean DirectedDFScheck(int node , int parent, Set<Integer> vis, Set<Integer> pathVis, ArrayList<ArrayList<Integer>> adj) {
        /* vis is marked so that , we will not go in loop */
        vis.add(node);
        pathVis.add(node);

        for(Integer v : adj.get(node)){
            if(!vis.contains(v)){
                if(DirectedDFScheck(v,node , vis , pathVis , adj))
                    return true;
            }
            else if(pathVis.contains(v)){
                return true;
            }
        }
        /* path visited is unmarked for the other path to explore , if it is true then we can confirm cycle*/
        pathVis.remove(node);
        return false;

    }

    private static boolean DirectedBFScheck(ArrayList<ArrayList<Integer>> adj) {

        /* this is modified Kahn algo */

        ArrayList<Integer> indegree = new ArrayList<>(6);
        for(int i = 0; i < 6 ; i++){
            for(int v : adj.get(i)){
                indegree.set(v , indegree.get(v) + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < 6 ; i++){
            if(indegree.get(i) == 0)
                queue.add(i);
        }

        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(int v : adj.get(node)){
                indegree.set(v , indegree.get(v) - 1);
                if(indegree.get(v) == 0)
                    queue.add(v);
            }
        }
        return count != 6;
    }
}
