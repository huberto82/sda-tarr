package programowanie_zaawansowane.c2_javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class ShapesDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Drawing Lines");
    Group root = new Group();
    Scene scene = new Scene(root, 500, 300, Color.WHITE);

    Line redLine = new Line(50, 50, 350, 50);
    redLine.setStroke(Color.BLUEVIOLET);
    redLine.setStrokeWidth(1);
    redLine.setStrokeLineCap(StrokeLineCap.BUTT);

    Circle circle = new Circle(250, 150, 50);
    circle.setStroke(Color.SKYBLUE);
    circle.setFill(Color.WHITE);

    Rectangle rect = new Rectangle(50, 50, 50, 50);
    rect.setStroke(Color.SKYBLUE);
    rect.setFill(Color.WHITE);

    Path shape = new Path();
    shape.getElements().addAll(
            new MoveTo(50,50),
            new LineTo(150, 150),
            new LineTo(200, 50),
            new LineTo(50,50));

    shape.setStroke(Color.GREENYELLOW);
    root.getChildren().add(shape);
    root.getChildren().add(rect);
    root.getChildren().add(circle);
    root.getChildren().add(redLine);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
