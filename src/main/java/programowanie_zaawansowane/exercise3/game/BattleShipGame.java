package programowanie_zaawansowane.exercise3.game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BattleShipGame extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    AIPlayer ai = new AIPlayer("robot");
    GridPane pane = new GridPane();

    HBox top = new HBox();
    top.setAlignment(Pos.CENTER);
    top.setPadding(new Insets(5,5,5,5));
    top.getChildren().add(new RadioButton("Hello"));
    HBox box = new HBox();
    box.setAlignment(Pos.CENTER);
    pane.add(top,0,0);
    pane.add(box,0,1);
    Group left = new Group();
    box.setBorder(new Border(new BorderStroke(Color.BLUEVIOLET,
            BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(5))));
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

    Scene scene = new Scene(pane);
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
    primaryStage.setTitle("Statki");
    primaryStage.show();
  }
}
