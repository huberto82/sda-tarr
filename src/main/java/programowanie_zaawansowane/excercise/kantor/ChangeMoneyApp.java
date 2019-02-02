package programowanie_zaawansowane.excercise.kantor;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChangeMoneyApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    GridPane root = new GridPane();
    root.setVgap(10);
    root.setHgap(10);
    root.setAlignment(Pos.CENTER);



    root.add(new Label("Waluta"), 0, 0);
    ComboBox<String> currency = new ComboBox<>();
    root.add(currency,1,0);

    root.add(new Label("Kurs"),0,1);
    TextField kurs = new TextField();
    kurs.setEditable(false);
    root.add(kurs,1,1);

    root.add(new Label("Kwota w zł"),0,2);
    TextField amountZL = new TextField();
    root.add(amountZL, 1,2);

    root.add(new Label("Kwota w walucie"),0,3);
    TextField amountC = new TextField();
    amountC.setEditable(false);
    root.add(amountC,1,3);

    Scene scene = new Scene(root, 300, 200);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Czendżmany.pl");
    primaryStage.show();
  }
}
