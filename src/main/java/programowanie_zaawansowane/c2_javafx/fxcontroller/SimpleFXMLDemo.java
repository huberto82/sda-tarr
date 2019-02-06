package programowanie_zaawansowane.c2_javafx.fxcontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class SimpleFXMLDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    GridPane root = FXMLLoader.load(getClass().getResource("/form.fxml"));
    Scene scene = new Scene(root, 400, 240);
    primaryStage.setTitle("FXML Welcome");
    primaryStage.setResizable(false);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
