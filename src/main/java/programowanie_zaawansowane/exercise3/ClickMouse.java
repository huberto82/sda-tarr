package programowanie_zaawansowane.exercise3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ClickMouse extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Group root = new Group();
    root.getChildren().add(Cross.make(200,200,100));
    Scene scene = new Scene(root,400,400);
    Rectangle rect = new Rectangle(0,0,100,100);
    scene.setOnMouseClicked(event -> {
      double x = event.getSceneX();
      double y = event.getSceneY();
      //dla pierwszej ćwiartki
      if (x < 200 && y < 200){
        Path plus = Cross.make(x,y,30);
        plus.setStroke(Color.RED);
        root.getChildren().add(plus);
      }
      //TODO w każdej ćwiartce inny rodzaj plusa np. o innym kolorze, grubości itd.
    });
    primaryStage.setScene(scene);
    primaryStage.setTitle("Klikanie");
    primaryStage.setResizable(false);
    primaryStage.show();
  }
}
