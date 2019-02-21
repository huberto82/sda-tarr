package programowanie_zaawansowane.fxtodoapp.jpa;

import javafx.collections.ObservableList;
import programowanie_zaawansowane.fxtodoapp.configuration.AppConfiguration;
import programowanie_zaawansowane.fxtodoapp.model.AbstractTask;

import java.io.*;

public class PersistanceTaskFileService implements PersistenceTaskService{

  private final String filePath;
  private final ObservableList<AbstractTask> list;
  private static PersistenceTaskService instance;

  private static class PersistanceTaskFileServiceHelper{
    private static final PersistenceTaskService INSTANCE = new PersistanceTaskFileService();
  }

  private PersistanceTaskFileService() {
   filePath ="";
   list = null;
   instance = null;
   //TODO fill later
  }

  public PersistenceTaskService getInstance(){
    return PersistanceTaskFileServiceHelper.INSTANCE;
  }

  private void read(ObservableList<AbstractTask> todoList, String path) throws IOException {
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

  private void write(ObservableList<AbstractTask> todoList, String path) throws IOException {
    FileOutputStream file = new FileOutputStream(path);
    ObjectOutputStream ostream = new ObjectOutputStream(file);
    for (int i = 0; i < todoList.size(); i++){
      AbstractTask task = todoList.get(i);
      ostream.writeObject(task);
    }
    ostream.close();
    file.close();
  }

  @Override
  public void init() throws IOException {
    read(list, filePath);
  }

  @Override
  public void save(AbstractTask task) throws IOException {
    list.add(task);
    write(list,filePath);
  }

  @Override
  public void delete(AbstractTask task) throws IOException {
    list.remove(task);
    write(list,filePath);
  }

  @Override
  public void update(int id, AbstractTask task) throws IOException {
    list.set(id, task);
    write(list,filePath);
  }

  @Override
  public AbstractTask read(int id) {
      return list.get(id);
  }
}
