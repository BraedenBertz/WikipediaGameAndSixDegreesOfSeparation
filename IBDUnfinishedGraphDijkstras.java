// --== CS400 File Header Information ==--
// Name: Maicheng Thao
// Email: mthao43@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian
// Notes to Grader: Backend placeholder for AE interface, difference is return type and parameters

import java.util.ArrayList;

public interface IBDUnfinishedGraphDijkstras {
  /**
   * This method takes in the starting node and ending node and finds 
   * all paths that are the the shortest path. Since each edge weight is 
   * 1, we are more likely to have several shortest paths.
   * @param start
   * @param end
   * @return
   */
  public ArrayList<String> allShortestPaths(String start, String end);
}
