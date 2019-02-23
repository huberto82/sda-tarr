package programowanie_zaawansowane.exercise2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UIApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    VBox root = new VBox();
    root.setAlignment(Pos.CENTER);
    root.setSpacing(10);
    root.setPadding(new Insets(10,10,10,10));

    Label nameLabel = new Label("Podaj imię");
    root.getChildren().add(nameLabel);

    TextField name = new TextField("Imię");
    name.setAlignment(Pos.CENTER);
    name.setOnAction(e->{
     name.setText(name.getText().toUpperCase());
    });
    root.getChildren().add(name);

    Label dateLabel = new Label("Podaj datę");
    root.getChildren().add(dateLabel);

    DatePicker date = new DatePicker();
    root.getChildren().add(date);

    Label eyeLabel = new Label("Kolor oczu");
    root.getChildren().add(eyeLabel);
    ComboBox<String> eyeColor = new ComboBox<>();
    eyeColor.getItems().addAll("zielony" , "niebieski" ,"piwny");
    root.getChildren().add(eyeColor);

    ListView<String> list = new ListView<>();
    root.getChildren().add(list);

    Button submit = new Button("Dodaj");
    root.getChildren().add(submit);
    submit.setOnAction(event -> {
      String data = name.getText()+", "+date.getValue()+", "+eyeColor.getValue();
      list.getItems().add(data);
    });

    Button delete = new Button("Usuń");
    root.getChildren().add(delete);
    delete.setOnAction(event -> {
      list.getItems().remove(list.getSelectionModel().getSelectedItem());
    });

    Button save = new Button("Zapisz");
    root.getChildren().add(save);
    save.setOnAction(event -> {
      IOFile.saveToFile(list.getItems(),"dane.txt");
    });

    list.getItems().addAll(IOFile.readFromFile("dane.txt"));

    Scene scene = new Scene(root, 300, 600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("UI Application");
    primaryStage.show();
  }
}
