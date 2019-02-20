package programowanie_zaawansowane.fxtodoapp.configuration;

public class AppConfiguration {

  public enum PersistenceType{
    FILE,
    JDBC,
  }

  private PersistenceType persistanceType;

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
