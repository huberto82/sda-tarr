package programowanie_zaawansowane.c2_javafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationShapeDemo extends Application {

  @Override
  public void start(Stage stage) {

    Pane canvas = new Pane();
    Scene scene = new Scene(canvas, 300, 300, Color.ALICEBLUE);
    Circle ball = new Circle(10, Color.CADETBLUE);
    ball.relocate(5, 5);

    canvas.getChildren().add(ball);

    stage.setTitle("Animated Ball");
    stage.setScene(scene);
    stage.show();

    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
            new EventHandler<ActionEvent>() {
              double dx = 7; //krok prędkości osi x
              double dy = 3; //krok prędkości osi y

              @Override
              public void handle(ActionEvent t) {
                //przesunięcie piłki
                ball.setLayoutX(ball.getLayoutX() + dx);
                ball.setLayoutY(ball.getLayoutY() + dy);

                Bounds bounds = canvas.getBoundsInLocal();

                //zmiana kierunku, gdy piłka dojdzie do lewej lub prawej krawędzi okna
                if (ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius()) ||
                        ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius())) {
                  dx = -dx;
                }

                //zmiana kierunku, gdy piłka dojdzie do górnej lub dolnje krawędzi okna
                if ((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
                        (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))) {

                  dy = -dy;

                }
              }
            }));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
  }

  public static void main(String[] args) {
    launch();
  }
}
