// --== CS400 File Header Information ==--
// Name: Maicheng Thao
// Email: mthao43@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian
// Notes to Grader: Backend placeholder for DW LinkLoader
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.jsoup.select.Elements;

public class BDLinkLoader implements IBDLinkLoader {

  @Override
  public boolean ValidLinks(String start) {
    if (start != null && (start.equals("a") || start.equals("b") || start.equals("c") ||
        start.equals("d") || start.equals("e") || start.equals("f"))) {
      return true;
    }
    return false;
  }
  
  @Override
  public List<String> getEdges(String node) throws IOException{
    if (node == null) {
      return null;
    }
    List<String> list = new ArrayList<>();
    if (node.equals("a")) {
      list.add("b");
      list.add("c");
      list.add("d");
    }
    if (node.equals("b")) {
      list.add("e");
      list.add("c");
    }
    if (node.equals("c")) {
      list.add("b");
      list.add("f");
    }
    if (node.equals("d")) {
      list.add("e");
    }
    if (node.equals("e")) {
      list.add("a");
    }
    if (node.equals("f")) {
      list.add("a");
      list.add("d");
    }  
    return list;
  }
  
  @Override
  public Set<String> filterLinks(Elements links) {
    // TODO Auto-generated method stub
    return null;
  }

}