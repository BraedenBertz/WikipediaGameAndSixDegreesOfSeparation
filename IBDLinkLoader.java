// --== CS400 File Header Information ==--
// Name: Maicheng Thao
// Email: mthao43@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian
// Notes to Grader: Backend placholder for DW ILinkLoader, only difference is change in return type
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface IBDLinkLoader {
  boolean ValidLinks(String start);
  
  List<String> getEdges(String node) throws IOException;

  /**
   * Remove all the unrelative links in the given Wiki page
   */
  Set<String> filterLinks(org.jsoup.select.Elements links);

}
