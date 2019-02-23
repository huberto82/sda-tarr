package programowanie_zaawansowane.exercise3.game;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BattleShipGame extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    AIPlayer ai = new AIPlayer("robot");

    HBox box = new HBox();
    Group left = new Group();
    Group right = new Group();
    box.getChildren().addAll(left, right);

    Board plansza = new Board(40);
    Board planszaAI = new Board(40);
    boolean[][] aiShips = new boolean[10][10];
    aiShips[0][4] = true;
    aiShips[1][6] = true;
    aiShips[4][4] = true;
    aiShips[5][4] = true;
    planszaAI.setShips(aiShips);

    left.getChildren().addAll(plansza.getAll());
    right.getChildren().addAll(planszaAI.getAll());

    Scene scene = new Scene(box, 800, 400);
    left.setOnMouseClicked(event->{
      if (plansza.count() < 5) {
        plansza.setShip(event.getX(), event.getY());
      }
    });

    right.setOnMouseClicked(event->{
      if (plansza.count() == 5) {
        planszaAI.setShot(event.getX(), event.getY());
        Point2D  point = ai.generateShot(400,400);
        plansza.setShot(point.getX(),point.getY());
        if (plansza.isWinner()){
          Alert win = new Alert(Alert.AlertType.INFORMATION);
          win.setContentText("Wygrał gracz AI");
          win.show();
        }
        if (planszaAI.isWinner()){
          Alert win = new Alert(Alert.AlertType.INFORMATION);
          win.setContentText("Wygrałeś z AI");
          win.show();
        }
      }
    });

    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Statki");
    primaryStage.show();
  }
}
