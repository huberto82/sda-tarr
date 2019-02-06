package programowanie_zaawansowane.excercise.todo;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
  @FXML
  TextArea taskContent;

  @FXML
  DatePicker taskDateToDo;

  @FXML
  Button addTask;

  @FXML
  Spinner<Double> salary;

  public Controller() {
  }


  public void initialize(){
    salary = new Spinner<Double>();
    SpinnerValueFactory<Double> factory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,5000, 0);
    salary.setValueFactory(factory);
  }

  @FXML
  public void addTaskToDo(){
    //Dodanie zadania do kolekcji
    Alert info = new Alert(Alert.AlertType.INFORMATION);
    info.setContentText("Zadziałał przycisk addTask "+taskContent.getText());
    info.show();
  }

}
