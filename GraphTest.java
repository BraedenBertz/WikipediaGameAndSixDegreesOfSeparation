// --== CS400 File Header Information ==--
// Name: Braeden Bertz
// Email: bbertz@wisc.edu
// Team: DE_blue
// TA: APRIL
// Lecturer: Florian
// Notes to Grader: <optional extra notes>
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

  private CS400Graph<String> graph;

  /**
   * Instantiate graph from last week's shortest path activity.
   */
  @BeforeEach
  public void createGraph() {
    graph = new CS400Graph<>();
    // insert vertices A-F
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertVertex("C");
    graph.insertVertex("D");
    graph.insertVertex("E");
    graph.insertVertex("F");
    // insert edges from Week 11. Shortest Path Activity
    graph.insertEdge("A","B",6);
    graph.insertEdge("A","C",2);
    graph.insertEdge("A","D",5);
    graph.insertEdge("B","E",1);
    graph.insertEdge("B","C",2);
    graph.insertEdge("C","B",3);
    graph.insertEdge("C","F",1);
    graph.insertEdge("D","E",3);
    graph.insertEdge("E","A",4);
    graph.insertEdge("F","A",1);
    graph.insertEdge("F","D",1);
  }

  /**
   * Checks the distance/total weight cost from the vertex A to F.
   */
  @Test
  public void testPathCostAtoF() {
    assertTrue(graph.getPathCost("A", "F") == 3);
  }

  /**
   * Checks the distance/total weight cost from the vertex A to D.
   */
  @Test
  public void testPathCostAtoD() {
    assertTrue(graph.getPathCost("A", "D") == 4);
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex
   * A to D.
   */
  @Test
  public void testPathAtoD() {
    assertTrue(graph.shortestPath("A", "D").toString().equals(
        "[A, C, F, D]"
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
   * checks the distance/total weight cost from the vertex B to F
   *
   */
  @Test
  public void testPathCostBtoF() {
    assertTrue(graph.getPathCost("B", "F") == 3);
  }

  /**
   * checks the path from the vertex D to F
   */
  @Test
  public void testPathDtoF() {
    assertTrue(graph.shortestPath("D", "F").toString().equals(
        "[D, E, A, C, F]"
    ));
  }

  /**
   * checks the total weight cost from the vertex C to E
   */
  @Test
  public void testPathCostCtoE() {
    assertTrue(graph.getPathCost("C", "E") == 4);
  }

  /**
   * checks the predecessor of vertex C to E is B
   */
  @Test
  public void testPredecessorCtoE() {
    assertTrue(graph.shortestPath("C", "E").indexOf("B") == 1);
  }

  /**
   * test for correcnet path cost from A to B, A to C, A to D, A to E, A to F
   */
  @Test
  public void testPathCosts() {
    assertTrue(graph.getPathCost("A", "B") == 5);
    //A to C
    assertTrue(graph.getPathCost("A", "C") == 2);
    //A to D
    assertTrue(graph.getPathCost("A", "D") == 4);
    //A to E
    assertTrue(graph.getPathCost("A", "E") == 6);
    //A to F
    assertTrue(graph.getPathCost("A", "F") == 3);
  }

  /**
   * test for a path which has no end vertex
   */
  @Test
  public void testPathNoEnd() {
    assertThrows(NoSuchElementException.class, () -> {
      graph.shortestPath("A", "Z");
    });
  }

  /**
   * test for a path which has no start vertex
   */
  @Test
  public void testPathNoStart() {
    assertThrows(NoSuchElementException.class, () -> {
      graph.shortestPath("Z", "A");
    });
  }

  /**
   * test for a path which has no start and end vertex
   */
  @Test
  public void testPathNoStartNoEnd() {
    assertThrows(NoSuchElementException.class, () -> {
      graph.shortestPath("Z", "Z");
    });
  }
}
