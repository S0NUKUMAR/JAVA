package dataStructure.Graph;


/*
    this is the implementation of the Strongly Connected Component
        step 1: create a graph
        step 2: create a visited array and stack
        step 3: iterate over the graph and call the DFS function
        step 4: in DFS function add the node to visited set and iterate over the adj list of the node
        step 5: if the node is not visited then call the DFS function
        step 6: add the node to stack
        step 7: create a reverse graph
        step 8: iterate over the stack and call the DFS function
        step 9: return the count of the SCC

 */
import java.util.Arrays;
import java.util.Stack;

public class StronglyConnectedComponent {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(5, 5);
        graph.addEdges(0,1);
        graph.addEdges(1,2);
        graph.addEdges(2,3);
        graph.addEdges(3,0);
        graph.addEdges(2,4);

        int scc = StronglyConnectedComponentFunc(graph);
        System.out.println(scc);
    }

    static int StronglyConnectedComponentFunc(DirectedGraph graph) {
        int[] visited = new int[graph.vertex];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < graph.vertex ; i++){
            if(visited[i] == 0){
                dfs(i,graph,visited,stack);
            }
        }
        DirectedGraph reverseGraph = reverseGraph(graph);
        Arrays.fill(visited,0);
        int scc = 0;
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(visited[node] == 0){
                scc++;
                dfs(node,reverseGraph,visited);
            }
        }
        return scc;
    }

    private static void dfs(int node, DirectedGraph graph, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;
        for(int curr : graph.adj.get(node)){
            if(visited[curr] == 0){
                dfs(curr,graph,visited,stack);
            }
        }
        stack.push(node);
    }

    private static void dfs(int node, DirectedGraph graph, int[] visited) {
        visited[node] = 1;
        for(int curr : graph.adj.get(node)){
            if(visited[curr] == 0){
                dfs(curr,graph,visited);
            }
        }
    }

    private static DirectedGraph reverseGraph(DirectedGraph graph) {
        DirectedGraph reverseGraph = new DirectedGraph(graph.vertex,graph.edges);
        for(int i = 0 ; i < graph.vertex ; i++){
            for(int curr : graph.adj.get(i)){
                reverseGraph.addEdges(curr,i);
            }
        }
        return reverseGraph;
    }
}