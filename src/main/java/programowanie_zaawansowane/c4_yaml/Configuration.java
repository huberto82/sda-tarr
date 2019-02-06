package programowanie_zaawansowane.c4_yaml;
import java.util.Map;

public final class Configuration {
  private String version;
  private String released;
  private String filename;
  private Map<String, String> users;

  public String getVersion() {
    return version;
  }

  public String getReleased() {
    return released;
  }

  public String getFilename() {
    return filename;
  }

  public Map<String, String> getUsers() {
    return users;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public void setReleased(String released) {
    this.released = released;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public void setUsers(Map<String, String> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "Configuration{" +
            "version='" + version + '\'' +
            ", released='" + released + '\'' +
            ", filename='" + filename + '\'' +
            ", users=" + users +
            '}';
  }
}
