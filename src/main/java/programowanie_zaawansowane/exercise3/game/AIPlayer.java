package programowanie_zaawansowane.exercise3.game;
import javafx.geometry.Point2D;

import java.util.Random;

public class AIPlayer extends Player{

  public AIPlayer(String name) {
    super(name);
  }

  public Point2D generateShot(double width, double height){
    Random rand = new Random();
    double x = rand.nextInt((int) width);
    double y = rand.nextInt((int) height);
    Point2D point = new Point2D(x, y);
    addShot(point);
    return point;
  }
}
