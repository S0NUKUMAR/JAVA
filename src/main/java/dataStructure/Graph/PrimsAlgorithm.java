package dataStructure.Graph;

/*
    start building the graph from zero node and add one by one the edges in ascending order
    we have to use priority queue for the graph , which will store the (weight , node , parent) and in ascending order
    use a visited array to keep track of the added nodes , to avoid cycles

    step 1: create a priority queue
    step 2: create a visited set
    step 3: create a edges array
    step 4: add the first node to the queue
    step 5: while queue is not empty
        step 6: get the node from queue
        step 7: get the all adjacent node of the current node
        step 8: if the node is not visited then add the node to the queue
        step 9: add the weight of the node to the sum
        step 10: add the node to the edges array
    step 11: print the sum
    step 12: print the edges array

 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

class PrimsNode {
    int weight ;
    int node ;
    int parent;

    PrimsNode(int w , int v , int u){
        this.weight = w;
        this.node = v;
        this.parent = u;
    }
}
public class PrimsAlgorithm {
    public static void main(String[] args) {
        UnDirectedWeightedGraph graph = new UnDirectedWeightedGraph(5,6);
        graph.addEdges(0,1,2);
        graph.addEdges(0,2,1);
        graph.addEdges(2,1,1);
        graph.addEdges(2,4,2);
        graph.addEdges(4,3,1);
        graph.addEdges(2,3,2);

        primsFunction(graph);
    }

    private static void primsFunction(UnDirectedWeightedGraph graph) {

        PriorityQueue<PrimsNode> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.weight));
        HashSet<Integer> vis = new HashSet<>();

        ArrayList<Node> edges = new ArrayList<>();
        pq.add(new PrimsNode(0,0 ,-1));
        int sum = 0;
        while (!pq.isEmpty()){
            PrimsNode primsnode = pq.poll();
            int node = primsnode.node;
            int parent = primsnode.parent;
            int weight = primsnode.weight;


            if(vis.contains(node)) continue;
            vis.add(node);

            sum+=weight;
            if(parent!=-1) edges.add(new Node(node,parent));

            for(WeightNode wn : graph.adj.get(node)){
                if(!vis.contains(wn.v)){
                    pq.add(new PrimsNode(wn.w , wn.v , node));
                }
            }
        }
        System.out.println(sum);
        for(Node n  : edges){
            System.out.println(n.first + " "+  n.second);
        }
    }
}
