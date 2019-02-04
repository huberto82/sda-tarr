package programowanie_zaawansowane.fxtodoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class Controller {
  @FXML
  TextArea taskContent;

  @FXML
  DatePicker taskDateToDo;

  @FXML
  Button addTask;

  public Controller() {
  }


  public void initialize(){

  }

  @FXML
  public void addTaskToDo(){
    //Dodanie zadania do kolekcji
    Alert info = new Alert(Alert.AlertType.INFORMATION);
    info.setContentText("Zadziałał przycisk addTask "+taskContent.getText());
    info.show();
  }

}
