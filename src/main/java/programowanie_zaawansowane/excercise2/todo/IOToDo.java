package programowanie_zaawansowane.excercise2.todo;
import javafx.collections.ObservableList;
import java.io.*;
public class IOToDo {

  static public void read(ObservableList<AbstractTask> todoList, String path) throws IOException {
    File file = new File(path);
    if (!file.exists()){
      return;
    }

    FileInputStream stream = new FileInputStream(path);
    ObjectInputStream istream = new ObjectInputStream(stream);

    while(true){
      try {
        Object obj = istream.readObject();
        AbstractTask task = (AbstractTask) obj;
        todoList.add(task);
      } catch (IOException e) {
        istream.close();
        break;
      } catch (ClassNotFoundException e) {
        istream.close();
        break;
      }
    }
  }

  static public void write(ObservableList<AbstractTask> todoList, String path) throws IOException {
    FileOutputStream file = new FileOutputStream(path);
    ObjectOutputStream ostream = new ObjectOutputStream(file);
    for (int i = 0; i < todoList.size(); i++){
        AbstractTask task = todoList.get(i);
        ostream.writeObject(task);
    }
    ostream.close();
    file.close();
  }
}
