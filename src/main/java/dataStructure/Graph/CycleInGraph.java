package dataStructure.Graph;

/*
    step 1: create a boolean array of size vertex + 1
    step 2: for each vertex check if it is not visited then do bfs and mark all the connected vertex as visited
    step 3: if we are able to visit all the vertex then return true
    step 4: else return false

 */

import java.util.*;

class Node {
    int first;
    int second;

    Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class CycleInGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(6 , 5);

        graph.addEdges(1,2);
        graph.addEdges(3,2);
        graph.addEdges(4,3);
        graph.addEdges(4,5);
        graph.addEdges(6,5);

        Set<Integer> vis = new HashSet<>();

        boolean isCycle = DFScheck(1 , -1 , vis , graph.adj);
        System.out.println(isCycle);

        boolean isCycleBfs = BFScheck(graph.adj);
        System.out.println(isCycleBfs);
    }

    private static boolean BFScheck(ArrayList<ArrayList<Integer>> adj) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();

        queue.add(new Node(1 , -1));
        vis.add(1);

        while(!queue.isEmpty()){
            int node = queue.peek().first;
            int parent = queue.peek().second;

            queue.poll();

            for(Integer v : adj.get(node)){
               if(!vis.contains(v)){
                   vis.add(v);
                   queue.add(new Node(v, node));
               }
               else if(v != parent){
                   return true;
               }
            }
        }
        return false;
    }

    private static boolean DFScheck(int node , int parent , Set<Integer> vis , ArrayList<ArrayList<Integer>> adj) {
       vis.add(node);
       for(Integer v : adj.get(node)){
           /*check if not visited , call for the next nodes and check*/
           if(!vis.contains(v)){
               if(DFScheck(v,node , vis , adj)){
                   return true;
               }
           }
           /*if visited then check if it is not parent then it is cycle */
           else if(v != parent){
               return true;
           }
       }
       return false;
    }
}

