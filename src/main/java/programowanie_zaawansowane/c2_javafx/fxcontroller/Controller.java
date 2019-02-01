package programowanie_zaawansowane.c2_javafx.fxcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private DatePicker birthDate;

    @FXML
    private ComboBox eyeColor;

    @FXML
    private Button submitButton;

    public Controller(){
    }

    @FXML
    private void initialize(){
      eyeColor.getItems().add("zielone");
      eyeColor.getItems().add("niebieskie");
      eyeColor.getItems().add("piwne");
    }

    @FXML
    public void add(){
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Tytuł alertu");
      alert.setHeaderText("Nagłówek");
      String s ="Tekst okna dialogowego... ";
      alert.setContentText(s);
      alert.show();
    }

}
