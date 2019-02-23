package programowanie_zaawansowane.exercise2.todo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Controller {
  ObservableList<AbstractTask> todoList = FXCollections.observableArrayList();
  String filePath = "todolist.ser";

  @FXML
  ListView taskListView;

  @FXML
  TextArea taskContent;

  @FXML
  DatePicker taskDateToDo;

  @FXML
  Button addTask;

  @FXML
  PasswordField passwordField;

  Configuration config;

  @FXML
  public void checkPassword() throws NoSuchAlgorithmException {
    String pass = config.getUsers().get("admin");

    String userPass = passwordField.getText();
    MessageDigest digest = MessageDigest.getInstance("SHA-256");

    String encodeUserPass = bytesToHex(digest.digest(userPass.getBytes(StandardCharsets.UTF_8)));

    if (encodeUserPass.equals(pass)){
      Alert info = new Alert(Alert.AlertType.INFORMATION);
      info.setContentText("Hasło poprawne");
      info.show();
    }
  }

  private String bytesToHex(byte[] hash) {
    StringBuffer hexString = new StringBuffer();
    for (int i = 0; i < hash.length; i++) {
      String hex = Integer.toHexString(0xff & hash[i]);
      if(hex.length() == 1) hexString.append('0');
      hexString.append(hex);
    }
    return hexString.toString();
  }


  public Controller() {

  }

  public void initialize() throws IOException {
    config = loadConfig();
    if (config == null){
      config = new Configuration();
      config.setPath(filePath);
    }

    IOToDo.read(todoList, config.getPath());
    taskListView.setItems(todoList);
  }
  //TODO Dodać testowanie poprawności dodawanego zadania
  @FXML
  public void addTaskToDo() throws IOException {
    AbstractTask task = new TextTask(taskDateToDo.getValue(),taskContent.getText());
    todoList.add(task);
    IOToDo.write(todoList, config.getPath());
  }

  @FXML
  public void deleteTaskFromList() throws IOException {
    int index = taskListView.getSelectionModel().getSelectedIndex();
    if (index >= 0) {
      todoList.remove(index);
      IOToDo.write(todoList, config.getPath());
    }
  }

  private Configuration loadConfig(){
    String pathStr = "configuration.yaml";
    Yaml yaml = new Yaml();
    try(InputStream in = Files.newInputStream(Paths.get(pathStr))) {
      return yaml.loadAs(in, Configuration.class);
    } catch (IOException e) {
      return null;
    }
  }

}
