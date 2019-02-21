package programowanie_zaawansowane.fxtodoapp.jpa;

import programowanie_zaawansowane.fxtodoapp.configuration.AppConfiguration;
import programowanie_zaawansowane.fxtodoapp.controller.AppController;

public enum PersistenceType{
  FILE(),
  JDBC();

  private PersistenceTaskService persistenceTaskService;

  PersistenceType(PersistenceTaskService service) {
    this.persistenceTaskService = service;
  }
}