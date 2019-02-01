package programowanie_zaawansowane.c2_javafx.fxcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    // The reference of inputText will be injected by the FXML loader
    private TextField firstName;

    // The reference of outputText will be injected by the FXML loader
    @FXML
    private TextField lastName;

    // location and resources will be automatically injected by the FXML loader
    @FXML
    private DatePicker birthDate;

    @FXML
    private ComboBox eyeColor;

    // Add a public no-args constructor
    public Controller()
    {
    }

    @FXML
    private void initialize()
    {
      eyeColor.getItems().add("zielone");
      eyeColor.getItems().add("niebieskie");
      eyeColor.getItems().add("piwne");
    }

    @FXML
    public void submitButton(){
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Tytuł alertu");
      alert.setHeaderText("Nagłówek");
      String s ="Tekst okna dialogowego... ";
      alert.setContentText(s);
      alert.show();
    }

}
