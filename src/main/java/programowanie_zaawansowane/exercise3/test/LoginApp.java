package programowanie_zaawansowane.exercise3.test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

public class LoginApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws NoSuchAlgorithmException {
    Person user = Person.utworz("admin", LocalDate.of(2000,1,1));
    user.setHaslo(Logowanie.skrot("abcd"));

    GridPane root = new GridPane();
    root.setVgap(10);
    root.setPadding(new Insets(10,10,10,10));
    TextField login = new TextField();
    login.setPromptText("Wpisz login");
    PasswordField password = new PasswordField();
    password.setPromptText("Wpisz hasło");
    Button ok = new Button("Zaloguj");

    root.add(login,0,0);
    root.add(password, 0, 1);
    root.add(ok,0,2);
    ok.setOnAction(event->{
      String nazwa = login.getText();
      String haslo = password.getText();
      String skrot = null;
      try {
        skrot = Logowanie.skrot(haslo);
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }
      if (nazwa.equals(user.getNazwisko()) && user.poprawneHaslo(skrot)){
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setContentText("Zalogowano");
        info.show();
      } else{
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setContentText("Błędna nazwa użytkownika lub błędne hasło");
        info.show();
      }
    });
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
