package dataStructure.Graph;

/*
    kruskal uses the disjoint set to create the graph ,
    sort the edges according to the edge weights and
    start adding the edges into the graph
        if u and v having different parents(findParent function is not same)
        if same then avoid adding that because it will create the cycle
 */

import java.util.Comparator;
import java.util.PriorityQueue;

class KrushkalNode{
    int weight ;
    int u ;
    int v;

    KrushkalNode(int _w , int _u , int _v){
        weight = _w;
        u = _u;
        v = _v;
    }
}
public class KruskalAlgorithm {
    public static void main(String[] args) {
        PriorityQueue<KrushkalNode> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.weight));
        pq.add(new KrushkalNode(1,1,4));
        pq.add(new KrushkalNode(2,1,2));
        pq.add(new KrushkalNode(3,2,3));
        pq.add(new KrushkalNode(3,2,4));
        pq.add(new KrushkalNode(4,1,5));
        pq.add(new KrushkalNode(5,3,4));
        pq.add(new KrushkalNode(7,2,6));
        pq.add(new KrushkalNode(8,3,6));
        pq.add(new KrushkalNode(9,4,5));

        kruskalFunction(pq);

    }

    private static void kruskalFunction(PriorityQueue<KrushkalNode> pq) {
        DisjointSet ds = new DisjointSet(pq.size());
        int sum = 0;
        while (!pq.isEmpty()){
            KrushkalNode node = pq.poll();
            if(ds.findUParent(node.u)!=ds.findUParent(node.v)){
                sum+=node.weight;
                ds.unionByRank(node.u,node.v);
            }
        }
        System.out.println(sum);
    }
}
