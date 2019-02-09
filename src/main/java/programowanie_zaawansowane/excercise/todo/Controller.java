package programowanie_zaawansowane.excercise.todo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class Controller {
  ObservableList<AbstractTask> todoList = FXCollections.observableArrayList();

  @FXML
  ListView taskListView;

  @FXML
  TextArea taskContent;

  @FXML
  DatePicker taskDateToDo;

  @FXML
  Button addTask;

  public Controller() {

  }

  public void initialize(){
    //odczytać zadania z pliku
    //umieścić z kolekcji todoList
    //połączyć listę z listView
    taskListView.setItems(todoList);
  }
  //TODO Dodać testowanie poprawności dodawanego zadania
  @FXML
  public void addTaskToDo(){
    String task = taskContent.getText()+" "+taskDateToDo.getValue().toString();
    taskListView.getItems().add(task);
  }

  //TODO Dodać testowanie, czy wybrano element do skasowania i czy lista nie jest pusta
  @FXML
  public void deleteTaskFromList(){
    //numer zaznaczonego zadania na liście
    int index = taskListView.getSelectionModel().getSelectedIndex();
    //usunięcie z listy elementu o podanym indeksie
    taskListView.getItems().remove(index);
  }

}
