// --== CS400 Project Three File Header ==--
// Name: Braeden Bertz
// CSL Username: bbertz
// Email: bbertz@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader:
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

import java.util.List;

/**
 * Interface for the frontend developer.
 */
public interface IFrontendDeveloper {
  /**
   * Initializes the controller class. This method is automatically called
   * after the fxml file has been loaded. We setup the event handlers here.
   * We also initialize the webview here and load the wikipedia page using
   * DataWrangler's methods.
   */
  @FXML
  void initialize();

  /**
   * Handles the event of the user clicking the "Search" button.
   * We will initialize the BackendDeveloper here with the start page and end page
   * and then call the getShortestPaths method on another thread.
   */
  @FXML
  void handleStartButtonOnClick();

  /**
   * Loads the wiki page for the given page name.
   * @param startPage The title of the page to load.
   * @return The html content of the page.
   */
  String getWikiPageFromTitle(String startPage);

  /**
   * Called when the user clicks on the WebView. Increment one to the counter
   * if the user clicked on a link.
   * Loads the wiki page that the user clicked on.
   */
  @FXML
  void handleWebViewMouseClicked(MouseEvent mouseEvent);

  /**
   * Sets the webview to the given html content.
   * @param webView The webview to set.
   */
  void setWebView(WebView webView);

  /**
   * Sets the start page.
   * @param text1 The start page to set.
   * @param text2 The end page to set.
   * @return The start page.
   */
  void setTextField(String text1, String text2);

  /**
   * Use the paths to display the shortest paths on the frontend.
   * Would be cool to make this like MIT OCW style but not necessary.
   * @param shortestPaths A list of the shortest paths to display.
   */
  void createVisualGraph(List<String> shortestPaths);

  /**
   * Send the backend developer the start and end page that will be used in
   * the dijkstra algorithm. Then, once that is done, we will receive the
   * shortest paths from the backend developer
   * @param startPage
   * @param endPage
   * @return
   */
  List<String> getShortestPaths(String startPage, String endPage);

  //scopeup
  //void getAllWikiPageTitlesForPredictiveSearch();

}
