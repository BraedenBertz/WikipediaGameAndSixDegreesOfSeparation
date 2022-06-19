// --== CS400 File Header Information ==--
// Name: Maicheng Thao
// Email: mthao43@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian
// Notes to Grader: Backend placeholder for AE 
import java.util.ArrayList;
import java.util.Arrays;

public class BDUnfinishedGraphDijkstras<T extends Comparable<T>> extends CS400Graph<T> implements IBDUnfinishedGraphDijkstras{

  @Override
  public ArrayList<String> allShortestPaths(String start, String end) {
    if (start.equals("a") && end.equals("b")) {
      return new ArrayList<>(Arrays.asList("a", "b"));
    }
    if (start.equals("e") && end.equals("a")) {
        return new ArrayList<>(Arrays.asList("e", "a"));
    }
    return null;
  }
}
