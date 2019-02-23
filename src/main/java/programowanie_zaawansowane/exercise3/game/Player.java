package programowanie_zaawansowane.exercise3.game;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private String name;
  private List<Point2D> shots;

  public Player(String name) {
    this.name = name;
    shots = new ArrayList<>();
  }

  public void addShot(Point2D shot){
    shots.add(shot);
  }

  public Point2D getLast(){
    return shots.get(shots.size()-1);
  }
}
