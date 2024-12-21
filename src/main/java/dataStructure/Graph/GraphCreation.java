package dataStructure.Graph;

import java.util.ArrayList;


class WeightNode {
    int v;
    int w;

    WeightNode(int v, int w){
        this.v = v;
        this.w = w;
    }
}

class UnDirectedWeightedGraph {
    int vertex ; int edges ;

    ArrayList<ArrayList<WeightNode>> adj = new ArrayList<>();

    UnDirectedWeightedGraph(int v , int e){
        vertex = v;
        edges = e;

        for (int i = 0 ; i <=v ; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdges(int u , int v , int w) {
        adj.get(u).add(new WeightNode(v,w));
        adj.get(v).add(new WeightNode(u,w));
    }
}
class DirectedWeightedGraph {
    int vertex ; int edges ;

    ArrayList<ArrayList<WeightNode>> adj = new ArrayList<>();

    DirectedWeightedGraph(int v , int e){
        vertex = v;
        edges = e;

        for (int i = 0 ; i <=v ; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdges(int u , int v , int w) {
        adj.get(u).add(new WeightNode(v,w));
    }
}
class Graph{
    int vertex;
    int edges;

    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    Graph(int v , int e){
        vertex = v;
        edges = e;

        for(int i = 0 ; i <= v ; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdges(int u , int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void printGraph(){
        for(int i = 0 ; i <= vertex; i++) {
            System.out.print(i + " ->> ");
            for (int j = 0; j < adj.get(i).size(); j++)
                System.out.print(adj.get(i).get(j) + " ");
            System.out.println();
        }
    }
}
class DirectedGraph {
    int vertex ; int edges ;

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    DirectedGraph(int v , int e){
        vertex = v;
        edges = e;

        for (int i = 0 ; i <=v ; i++){
            adj.add(new ArrayList<>());
        }
    }
    public void addEdges(int u , int v){
        adj.get(u).add(v);
    }
}




public class GraphCreation {
    public static void main(String[] args) {
        Graph graph = new Graph(6 , 5);
        graph.addEdges(1,2);
        graph.addEdges(3,2);
        graph.addEdges(1,3);
        graph.addEdges(4,5);
        graph.addEdges(6,5);

        graph.printGraph();
    }
}
