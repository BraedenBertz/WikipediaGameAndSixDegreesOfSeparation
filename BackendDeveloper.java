// --== CS400 File Header Information ==--
// Name: Maicheng Thao
// Email: mthao43@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian
// Notes to Grader: Had to make changes based on changed interfaces of other members
// EXTRA NOTES TO GRADER: Braeden here, to get a final working project I changed a bit of the code Maicheng made so it probably won't work with
// the new interfaces she created. But her log file with the changes she is working before this commit. So if it is broken, after, you can look at her log file
// and see what she did and see that it was working!!! :)

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Backend class for wiki game
 *
 */
public class BackendDeveloper implements IBackendDeveloper {
  // creates a graph from AE's class
  public UnfinishedGraphDijkstras<String> graph;

  // Link object from DW
  public BDLink link;

  // constructor
  public BackendDeveloper() {
    link = new BDLink(); // new Link object
    graph = new UnfinishedGraphDijkstras<>(); // new UnfinishedGraphDijkstras graph
  }

  /**
   * Gets more data for AE so can find shortest paths
   *
   * @param list  list of all vertices
   * @param start start page
   * @param end   end page
   * @return list of all vertices
   * @throws IOException
   */
  private void addLinks(List<String> list, String start, String end) throws IOException {
    // if the list does not contain the end page, search for more links
    if(!list.contains(end)) {
      // for each current link
      for(String s : list) {
        // for each link found on that link
        for(String t : link.link.getEdges(s)) {
          // if the list and graph does not contain that link
          if(!list.contains(t) && !graph.containsVertex(t)) {
            // add link to list and insert it into graph
            list.add(t);
            graph.insertVertex(t);
            graph.insertEdge(s, t, 1);
          }
        }
      }
      addLinks(list, start, end);
    }
    // else if list contains the end page, return
    return;
  }

  /**
   * get shortest paths from AE and return to FD
   * Note: AE throws IOException in method signature but in body of code, NullPointer is thrown
   *
   * @param start the start page
   * @param end   the end page
   * @return list of shortest paths
   * @throws IOException
   */
  @Override
  public List<String> getShortestPaths(String start, String end) {
    if(start == null || end == null) {
      return null;
    }
    graph = new UnfinishedGraphDijkstras<>(); // new UnfinishedGraphDijkstras graph
    // else add the start and end to graph and links on those pages
    graph.insertVertex("/wiki/" + start);

    for(int i = 0; i < 2; i++) {
      System.out.println("i: " + i);
      UnfinishedGraphDijkstras<String> copy = new UnfinishedGraphDijkstras<>();
      graph.vertices.keySet().forEach(s -> {
        copy.insertVertex(s);
        List<String> list = null;
        try {
          list = new ArrayList<>(new LinkLoader().getEdges(s));
        } catch(IOException e) {
          e.printStackTrace();
          System.out.println(s);
        }

        // for each link found on the start page, add it as a vertex to graph
        // and create an edge to connect it to start page
        if(list == null) {
          System.out.println("list is null");
          return;
        }
        for(String q : list) {
          copy.insertVertex(q);
          copy.insertEdge(s, q, 1);
        }
      });
      graph = copy;
    }
    System.out.println("getting shortest paths");
    // return shortest paths
    return graph.allShortestPaths("/wiki/" + start, "/wiki/" + end);
  }

  /**
   * get start and end page from FD and check with DW if they are valid pages
   *
   * @param start the start page
   * @param end   the end page
   * @return true if the pages are valid
   */
  @Override
  public Boolean validatePages(String start, String end) {
    // if start/end is null, return false
    if(link.getURL(start) == null || link.getURL(end) == null) {
      return false;
    }
    // check if pages are valid
    return true;
  }
}
