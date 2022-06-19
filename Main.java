// --== CS400 Project Three File Header ==--
// Name: Braeden Bertz
// CSL Username: bbertz
// Email: bbertz@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader:
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public final class Main extends Application {

  /**
   * Launch the stage that will either start the universe refresh or allow the user to login
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Starts the application
   * @param primaryStage
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception{
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainStage.fxml")));
    primaryStage.setTitle("Wiki Game");
    primaryStage.setScene(new Scene(root, 800, 800));
    primaryStage.show();
  }
}
