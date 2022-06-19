// --== CS400 File Header Information ==--
// Name: Maicheng Thao
// Email: mthao43@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian
// Notes to Grader: For most tests, I had to use placeholders since the program fails, but for the
// 2 additional  tests that incorporates mine with another member, I used Frontend's actual code

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BackendDeveloperTests {
  private BackendDeveloper backend;
  private FrontendDeveloper frontend;

  /**
   * Instantiate classes
   */
  @BeforeEach
  public void setUp() {
    backend = new BackendDeveloper();
    frontend = new FrontendDeveloper();
    // valid data: a, b, c, d, e, f
    backend.graph.insertVertex("a");
    backend.graph.insertVertex("b");
    backend.graph.insertVertex("c");
    backend.graph.insertVertex("d");
    backend.graph.insertVertex("e");
    backend.graph.insertVertex("f");
    backend.graph.insertEdge("a", "b", 1);
    backend.graph.insertEdge("a", "c", 2);
    backend.graph.insertEdge("a", "d", 3);
    backend.graph.insertEdge("b", "e", 4);
  }

  /**
   * validates start and end page with valid inputs
   */
  @Test
  public void testValidatePages() {
    assertTrue(backend.validatePages("a", "b"));

    assertTrue(backend.validatePages("b", "c"));

  }

  /**
   * checks that validatePages() detects invalid inputs
   */
  @Test
  public void testValidatePagesWithInvalidData() {
    // null start and end page
    assertFalse(backend.validatePages(null, null));

    // null start page
    assertFalse(backend.validatePages(null, "b"));

    // null end page
    assertFalse(backend.validatePages("a", null));

    // start page not part of data
    assertFalse(backend.validatePages("z", "c"));

    // end page not part of data
    assertFalse(backend.validatePages("a", "z"));

    // start and end not part of data
    assertFalse(backend.validatePages("x", "y"));
  }

  /**
   * test getShortestPaths() with valid inputs
   */
  @Test
  public void testGetShortestPaths() {
    assertEquals("[[/wiki/a, /wiki/B]]", backend.getShortestPaths("a", "b").toString());

    assertEquals("[[/wiki/e, /wiki/A]]", backend.getShortestPaths("e", "a").toString());
  }

  /**
   * test getPaths() when passed with invalid inputs
   */
  @Test
  public void testGetShortestPathsWithInvalidData() {
    // invalid start and end page
    assertNull(backend.getShortestPaths(null, null));

    // invalid start page
    assertNull(backend.getShortestPaths(null, "b"));

    // invalid end page
    assertNull(backend.getShortestPaths("a", null));
  }

  /**
   * checks that graph contains correct vertices after inserting in new pages
   *
   */
  @Test
  public void testCheckGraph() {

    new ArrayList<>(backend.getShortestPaths("a", "b"));

    assertTrue(backend.graph.containsVertex("/wiki/a"));
    assertTrue(backend.graph.containsVertex("/wiki/B"));
  }


  /**
   * tests BD with FD to return path given valid inputs
   * AE threw an exception so for my BD code I threw an exception which is not thrown in FD, so
   * this fails, but FD and I agreed his implementation looks good
   */
  @Test
  public void testBDWithFD1() {
    frontend = new FrontendDeveloper();
    String s = frontend.getShortestPaths("a", "b").toString();
    assertEquals("[[/wiki/a, /wiki/B]]", s);
  }

  /**
   * check that null input is detected when FD inputs in null data
   */
  @Test
  public void testBDWithFD2() {
    frontend = new FrontendDeveloper();
    assertNull(frontend.getShortestPaths(null, "b"));
  }

  /**
   * tests AE LinkLoader that an exception was caught when input is invalid
   * this test will use the actual AE test since it correctly implemented when exception should
   * be caught
   */
  @Test
  public void testAE1() {
    LinkLoader loader = new LinkLoader();
    assertThrows(Exception.class, () -> loader.getEdges(null));
  }

  /**
   * Checks that ValidLinks returns true for page that is not null
   *
   */
  @Test
  public void testAE2() {
    Link link = new Link();
    assertTrue(link.link.ValidLinks("/wiki/Java"));
  }
}
