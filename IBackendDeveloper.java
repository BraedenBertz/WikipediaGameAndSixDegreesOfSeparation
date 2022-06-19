import java.io.IOException;
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
   * Receives starting and ending points from FD, pass this information to AE to get the shortest
   * paths 
   * 
   * @param start the start page
   * @param end the end page
   * @return list of all shortest paths 
   */
  List<String> getShortestPaths(String start, String end) throws IOException;

  /**
   * validate start and end pages for FD
   *
   * @param start the start page
   * @return string of url to first page
   */
  Boolean validatePages(String start, String end);
}
