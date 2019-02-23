package programowanie_zaawansowane.exercise3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Shapes extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Group root = new Group();

    Line linia = new Line(0, 100, 299, 100);
    linia.setStroke(Color.BLUEVIOLET);
    linia.setStrokeWidth(4);
    root.getChildren().add(linia);

    Path trojkat = new Path();
    trojkat.getElements().addAll(
            new MoveTo(100, 100),
            new LineTo(200, 100),
            new LineTo(150, 150),
            new LineTo(100, 100)
    );
    root.getChildren().add(trojkat);

    Circle kolo = new Circle(150, 100, 100);
    kolo.setFill(Color.TRANSPARENT);
    kolo.setStroke(Color.DARKBLUE);
    kolo.setStrokeWidth(4);
    root.getChildren().add(kolo);

    Path mojPlus = Cross.make(100, 100, 50);
    mojPlus.setStroke(Color.GREEN);
    mojPlus.setStrokeWidth(10);
    root.getChildren().add(mojPlus);

    root.getChildren().add(Cross.make(200,200,30));

    Scene scene = new Scene(root, 300, 200);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Kształty");

    primaryStage.show();
  }
  //TODO Napisz program wyświetlający plus, dwie skrzyżowane linie po środku okna
  //TODO Napisz metodę wyświetlającą plus o podanych współrzędnych i rozmiarze
  //TODO Path plus(double x, double y, double size){
  //TODO    Path plusik = ...
  //TODO    ...
  //TODO    return plusik;
  //TODO }
  //TODO root.getChildren().add(plus(100,200, 40));
  //TODO Napisz program wyświetlający gwiazdę, kwiatek lub inny kształt
}
