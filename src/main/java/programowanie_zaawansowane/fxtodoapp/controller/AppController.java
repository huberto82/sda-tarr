package programowanie_zaawansowane.fxtodoapp.controller;

import programowanie_zaawansowane.fxtodoapp.configuration.AppConfiguration;
import programowanie_zaawansowane.fxtodoapp.jpa.PersistenceTaskService;

public class AppController {
  public final AppConfiguration config;

  private AppController(){
    this.config = new AppConfiguration();
    //this.persistence =

  }
  private static class SingletonHelper{
    private static final AppController INSTANCE = new AppController();
  }

  public static AppController getInstance(){
    return SingletonHelper.INSTANCE;
  }
}
