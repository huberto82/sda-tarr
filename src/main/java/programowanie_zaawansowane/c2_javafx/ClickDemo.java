package programowanie_zaawansowane.c2_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ClickDemo extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 300,300);
    root.setOnMouseClicked(event->{
      Circle circ = new Circle(event.getSceneX(), event.getSceneY(),20);
      circ.setStroke(Color.SKYBLUE);
      circ.setFill(Color.GREEN);
      root.getChildren().add(circ);
      System.out.println("Click");
    });
    primaryStage.setScene(scene);
    primaryStage.setTitle("Click Demo");
    primaryStage.show();
  }
}
