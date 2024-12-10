package dataStructure.Graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StronglyConnectedComponentTest {
        @Test
        public void testStronglyConnectedComponentFunc() {
            DirectedGraph graph1 = new DirectedGraph(5, 5);
            graph1.addEdges(0,1);
            graph1.addEdges(1,2);
            graph1.addEdges(2,3);
            graph1.addEdges(3,0);
            graph1.addEdges(2,4);
            assertEquals(2, StronglyConnectedComponent.StronglyConnectedComponentFunc(graph1));

            DirectedGraph graph2 = new DirectedGraph(3, 3);
            graph2.addEdges(0,1);
            graph2.addEdges(1,2);
            graph2.addEdges(2,0);
            assertEquals(1, StronglyConnectedComponent.StronglyConnectedComponentFunc(graph2));

            DirectedGraph graph3 = new DirectedGraph(3, 2);
            graph3.addEdges(0,1);
            graph3.addEdges(1,2);
            assertEquals(3, StronglyConnectedComponent.StronglyConnectedComponentFunc(graph3));
        }
}