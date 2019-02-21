package programowanie_zaawansowane.fxtodoapp.configuration;

import programowanie_zaawansowane.fxtodoapp.jpa.PersistenceType;

public class AppConfiguration {

  private static PersistenceType persistanceType;

  public void setPersistanceType(String persistanceType) {
    this.persistanceType = PersistenceType.valueOf(persistanceType);
  }

  public PersistenceType getPersistanceType(){
    return persistanceType;
  }

  @Override
  public String toString() {
    return "AppConfiguration{" +
            "persistanceType=" + persistanceType +
            '}';
  }
}
