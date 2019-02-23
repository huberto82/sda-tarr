package programowanie_zaawansowane.exercise3.game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Board {
  private double fieldSize;
  //tablica widoków
  private Rectangle board[][];
  //tablica statków
  private boolean ships[][];
  //tablica strzałów
  private boolean hits[][];

  public void setShips(boolean[][] set){
    ships = set;
  }

  public Board(double size) {
    this.board = new Rectangle[10][10];
    this.ships = new boolean[10][10];
    this.hits = new boolean[10][10];
    fieldSize = size;
    build();
  }

  private void build(){
    for (int col = 0; col < 10; col++){
      for (int row = 0; row < 10; row++){
        Rectangle r = new Rectangle(col*fieldSize, row*fieldSize, fieldSize, fieldSize);
        r.setFill(Color.BLUE);
        r.setStroke(Color.WHITE);
        board[col][row] = r;
      }
    }
  }

  public Collection<Rectangle> getAll(){
    List<Rectangle> list = new ArrayList<>();
    for (int col = 0; col < 10; col++){
      for (int row = 0; row < 10; row++) {
        list.add(board[col][row]);
      }
    }
    return list;
  }

  public void setShip(double x, double y){
    int col = (int) Math.floor(x/fieldSize);
    int row = (int) Math.floor(y/fieldSize);
    board[col][row].setFill(Color.GREEN);
    ships[col][row] = true;
  }

  public void setShot(double x, double y){
    int col = (int) Math.floor(x/fieldSize);
    int row = (int) Math.floor(y/fieldSize);
    if (ships[col][row]) {
      hits[col][row] = true;
      board[col][row].setFill(Color.RED);
    } else{
      board[col][row].setFill(Color.ORANGE);
    }
  }

  public int count(){
    int counter = 0;
    for (int col = 0; col < 10; col++){
      for (int row = 0; row < 10; row++) {
          if (ships[col][row]){
            counter++;
          }
      }
    }
    return counter;
  }

  public boolean isWinner(){
    for (int col = 0; col < 10; col++){
      for (int row = 0; row < 10; row++) {
        if (ships[col][row] != hits[col][row]){
          return false;
        }
      }
    }
    return true;
  }

}
