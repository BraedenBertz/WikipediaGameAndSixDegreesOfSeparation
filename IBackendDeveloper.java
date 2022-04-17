import java.util.List;
//--== CS400 Project One File Header ==--
//Name: Maicheng Thao
//CSL Username: maicheng
//Email: mthao43@wisc.edu
//Lecture #: 004 @4:00pm
//Notes to Grader: <any optional extra notes to your grader>

/**
 * Interface for Backend Developer
 * 
 * @author Maicheng Thao
 *
 */
public interface IBackendDeveloper {
  
  /**
   * Adds the page and all links on that page into the graph
   * 
   * @param page the page to put into the graph
   */
  public void addPage(String page);
  
  /**
   * Receives starting and ending points from FD, pass this information to AE to get the shortest
   * paths 
   * 
   * @param start the start page
   * @param end the end page
   * @return list of all shortest paths
   */
  List<String> getPaths(String start, String end);

}
