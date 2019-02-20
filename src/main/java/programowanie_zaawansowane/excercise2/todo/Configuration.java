package programowanie_zaawansowane.excercise2.todo;

import java.util.Map;

public class Configuration {
  String version;
  String path;
  Map<String, String> users;

  public Map<String, String> getUsers() {
    return users;
  }

  public void setUsers(Map<String, String> users) {
    this.users = users;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
