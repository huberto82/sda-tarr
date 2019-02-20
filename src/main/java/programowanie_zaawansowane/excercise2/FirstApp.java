package programowanie_zaawansowane.excercise2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class FirstApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Scene scene = new Scene(root, 600, 600);
    scene.setFill(Color.SKYBLUE);

    Line line = new Line(50,50,100,100);
    line.setStroke(Color.BLUEVIOLET);
    line.setStrokeWidth(2);
    root.getChildren().add(line);

    double w = root.getWidth();
    double h = root.getHeight();
    Circle circle = new Circle(w/2,h/2,50);
    circle.setFill(Color.BLUE);
    root.getChildren().add(circle);

    //liczba płatków
    int n = 6;
    //środek kwiatka
    double x0 = w/2;
    double y0 = h/2;
    //odległosć od srodka kwiatka do srodkow platków
    double bigRadius = 100;
    //promień płatka
    double smallRadius =  50;
    for (double alfa = 0; alfa < Math.PI*2; alfa += 2*Math.PI/n){
      Circle c = new Circle(x0+ Math.sin(alfa)*bigRadius, y0+Math.cos(alfa)*bigRadius, smallRadius);
      c.setFill(Color.DARKBLUE);
      root.getChildren().add(c);
    }
    primaryStage.setScene(scene);
    primaryStage.setTitle("Pierwsza aplikacja FX");
    primaryStage.setResizable(false);
    primaryStage.show();
  }
}
