package programowanie_zaawansowane.excercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ClickApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 500, 500);
    Random rand = new Random();

    Circle circle = new Circle(rand.nextInt((int) scene.getWidth()), rand.nextInt((int) scene.getHeight()),50);
    root.getChildren().add(circle);
    AtomicInteger scorePoints = new AtomicInteger();

    Text score = new Text(20, 40, "Score: 0");
    root.getChildren().add(score);

    //wątek obsługi znikającego kółka
    new Thread(()->{
      while(true){
        circle.setVisible(false);
        try {
          Thread.sleep(100);
          circle.setCenterX(rand.nextInt((int) scene.getWidth()));
          circle.setCenterY(rand.nextInt((int) scene.getHeight()));
          circle.setVisible(true);
          Thread.sleep(1000);

        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    }).start();


    root.setOnMouseClicked(event -> {
      double x = event.getSceneX();
      double y = event.getSceneY();
      double xc = circle.getCenterX();
      double yc = circle.getCenterY();
      double rc = circle.getRadius();
      if (x > xc - rc && x < xc + rc && y > yc - rc && y < yc + rc) {
        int points = scorePoints.addAndGet(1);
        score.setText("Score: " + points);
      }
    });
    primaryStage.setScene(scene);
    primaryStage.setTitle("Click Me");
    primaryStage.show();
  }
}
