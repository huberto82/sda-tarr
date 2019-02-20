package programowanie_zaawansowane.fxtodoapp.service;

import programowanie_zaawansowane.fxtodoapp.model.AbstractTask;

import java.io.IOException;

public interface PersistenceTaskService {
  void init() throws IOException;
  void save(AbstractTask task) throws IOException;
  void delete(AbstractTask task) throws IOException;
  void update(int id, AbstractTask task) throws IOException;
  AbstractTask read(int id);
}
