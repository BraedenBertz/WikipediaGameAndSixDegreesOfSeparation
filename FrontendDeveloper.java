// --== CS400 Project Three File Header ==--
// Name: Braeden Bertz
// CSL Username: bbertz
// Email: bbertz@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader:

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

public class FrontendDeveloper implements IFrontendDeveloper{

  @FXML
  WebView webView;
  @FXML
  Button startButton;
  @FXML
  TextField startPageTF;
  @FXML
  TextField endPageTF;

  ExecutorService executor = Executors.newSingleThreadExecutor();

  Future<List<String>> shortestPath;

  //synchronized boolean to check if the user is currently crawling
  private transient int counter = -1;

  @FXML
  public void initialize() {
    webView.getEngine().load("https://en.wikipedia.org/wiki/");
    webView.getEngine().locationProperty().addListener((obs, oldState, newState) -> {
      //we only want to increment the counter if the user is playing and clicked a new link
      if (shortestPath != null && !Objects.equals(newState, oldState)) {
        // new page has loaded, process:
        counter++;
        System.out.println("changed to page " + newState);
        System.out.println("Counter: " + counter);
      }
    });
  }

  @Override
  @FXML
  public void handleStartButtonOnClick() {

    if(startPageTF == null || endPageTF == null) {
      return;
    }

    //make sure non-null and non-empty strings are entered
    if (startPageTF.getText().isEmpty() || endPageTF.getText().isEmpty()) {
      startPageTF.setTooltip(new Tooltip("Please enter a start page"));
      endPageTF.setTooltip(new Tooltip("Please enter an end page"));
      return;
    }

    //get the start and end pages
    String startPage = startPageTF.getText();
    String endPage = endPageTF.getText();
    //make sure they are valid pages
    if(!validatePages(startPage, endPage)) {
      startPageTF.setTooltip(new Tooltip("Please enter a valid wikipedia page for both start and end pages"));
      endPageTF.setTooltip(new Tooltip("Please enter a valid wikipedia page for both start and end pages"));
      return;
    }

    //if the text fields are valid, then get rid of their current tooltips
    startPageTF.setTooltip(new Tooltip(""));
    endPageTF.setTooltip(new Tooltip(""));


    //set the webview to the start page
    webView.getEngine().load(getWikiPageFromTitle(startPage));


    //if execution is not currently running, start a new thread
    if (!executor.isShutdown()) {
      Callable<List<String>> callable = () -> {
        //get the shortest paths
        System.out.println("Getting shortest paths from " + startPage + " to " + endPage);
        counter = -1;
        return getShortestPaths(startPage, endPage);
      };
      shortestPath = executor.submit(callable);
    }
  }

  private boolean validatePages(String startPage, String endPage) {
    //try to load the pages in the webview
    //if it fails, then the pages are invalid
    //use DW to see if "Wikipedia does not have an article with this exact name" is in the html
    return true;
  }

  public String getWikiPageFromTitle(String startPage) {
    //get the html from the wikipedia page with a given title
    String url = "https://en.wikipedia.org/wiki/" + startPage;
    return url;
  }

  @Override
  @FXML
  public void handleWebViewMouseClicked(MouseEvent mouseEvent) {
    if(mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
      return;
    }
  }

  @Override
  public void setWebView(WebView webView) {
    this.webView = webView;
  }

  @Override
  public void setTextField(String text1, String text2) {
    endPageTF.setText(text1);
    startPageTF.setText(text2);
  }

  @Override
  public void createVisualGraph(List<String> shortestPaths) {
    System.out.println("users clicks was " + counter);
    System.out.println("Creating Visual Graph");
    //create a new force directed graph using the shortest paths

  }

  @Override
  public synchronized List<String> getShortestPaths(String startPage, String endPage) {
    //get the shortest paths from the start page to the end page from backend developer
    return new ArrayList<>();
  }


  @FXML
  public synchronized void handleEndButtonOnClick() throws ExecutionException, InterruptedException {
    if(shortestPath == null) {
      return;
    }
    //user asked to end the game, and they didn't get to the end page
    //see if the shortest path is still running, if it is, cancel it
    if(!shortestPath.isDone()) {
      shortestPath.cancel(true);
    }
    //shortest path is done running, so we can tell the user the path it took
    else {
      createVisualGraph(shortestPath.get());

      //set the webview to the end page
      webView.getEngine().load(getWikiPageFromTitle(endPageTF.getText()));
      counter = 0;
    }
  }
}
