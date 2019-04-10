package programowanie_zaawansowane.exercise3.game;

import java.util.Random;
import javafx.geometry.Point2D;

public class AIPlayer extends Player {

  public AIPlayer(String name) {
    super(name);
  }

  /**
   * Generates random shot.
   * @param width - width of the board
   * @param height - height of the board
   * @return coordinates of shot
   */
  public Point2D generateShot(double width, double height) {
    Random rand = new Random();
    double x = rand.nextInt((int) width);
    double y = rand.nextInt((int) height);
    Point2D point = new Point2D(x, y);
    addShot(point);
    return point;
  }
}
