import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class AlgorithmEngineerTests {

    private UnfinishedGraphDijkstras<String> graph;
    
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new UnfinishedGraphDijkstras<>();
        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        graph.insertVertex("G");
        // insert edges from Week 11. Shortest Path Activity
        graph.insertEdge("A","B",1);
        graph.insertEdge("A","C",1);
        graph.insertEdge("A","D",1);
        graph.insertEdge("B","E",1);
        graph.insertEdge("B","C",1);
        graph.insertEdge("C","B",1);
        graph.insertEdge("C","F",1);
        graph.insertEdge("D","E",1);
        graph.insertEdge("E","A",1);
        graph.insertEdge("F","A",1);
        graph.insertEdge("F","D",1);
       graph.insertEdge("F","G",1);
    }

   
    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    @Test
    public void testPathCostAtoD() {
        assertTrue(graph.getPathCost("A", "D") == 1);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to D.
     */
    @Test
    public void testPathAtoD() {
        assertTrue(graph.shortestPath("A", "D").toString().equals(
            "[A, D]"
        ));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to F.
     */
    @Test
    public void testPathAtoF() {
        assertTrue(graph.shortestPath("A", "F").toString().equals(
            "[A, C, F]"
        ));
    }
    
    /**
     * Should go A -> E with a total path cost of 2
     */
    @Test
    public void test1() {
    	assertTrue(graph.getPathCost("A","E") == 2);
    	
    }    
    
    /**
     * 11
     * Add another test method to confirm the path cost you reported for the question about path cost from last week's activity.
     * This test will go from B -> F where the path cost should be 3
     */
    @Test
    public void test3() {
    	assertTrue(graph.getPathCost("B","F") == 2);

    }
    
    /**
     * 12
     * Add another test method to confirm the predecessor you reported for question about a final node's
     *  predecessor from last week's activity. For simplicities sake, this will test the entire path 
     *  from start to end including the predecessor node to the final node traveling from b -> F
     */
    @Test
    public void test4() {
    	System.out.println(graph.shortestPath("B", "F").toString());
    	assertTrue(graph.shortestPath("B", "F").toString().equals(
                "[B, C, F]"
            ));
    	
    }
    
    /**
     * 13
     * This test will test the "unique" circumstances. Such as a path from A -> A, and cases
     * where a NullPointerExxception should be thrown such as when a null element is 
     * entered as the start or end, or when one of the points start or end DNE.
     */
    @Test
    public void test5() {
    	assertTrue(graph.getPathCost("B","B") == 0);
    	
    	try {
    		graph.getPathCost(null, null);
    		fail("this point should not be reached");
    	}catch(NoSuchElementException e) {}
    	

    }
    
    /**
     * This test will ensure that a path that would require more than 5
     * moves is returned as null as we will not have enough memory to 
     * handle the amount of paths that would be created.
     */
    @Test
    public void test6() {
    	assertTrue(graph.dijkstrasShortestPath("D","G") == null);
    }

    @Test
    public void test7() {
        graph = new UnfinishedGraphDijkstras<>();
        graph.insertVertex("1");
        graph.insertVertex("2");
        graph.insertVertex("3");
        graph.insertVertex("4");
        graph.insertVertex("5");
        graph.insertVertex("0");
        graph.insertEdge("1", "4", 1);
        graph.insertEdge("1", "5", 1);
        graph.insertEdge("2", "4", 1);
        graph.insertEdge("2", "0", 1);
        graph.insertEdge("3", "2", 1);
        graph.insertEdge("4", "0", 1);
        graph.insertEdge("5", "4", 1);
        graph.insertEdge("5", "0", 1);
        graph.insertEdge("0", "5", 1);
        graph.insertEdge("0", "4", 1);
        graph.insertEdge("4", "5", 1);
        //test to see that it returns all paths that are shortest if there are multiple paths
        //that are the same length
        ArrayList<String> paths = graph.allShortestPaths("3", "5");
        assertTrue(paths.size() == 2);
        assertTrue(paths.contains("[3, 2, 4, 5]"));
        assertTrue(paths.contains("[3, 2, 0, 5]"));
    }
}
