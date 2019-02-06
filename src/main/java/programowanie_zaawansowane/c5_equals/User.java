package programowanie_zaawansowane.c5_equals;

public class User {
  final private String name;
  final private String password;

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
            "name='" + name + '\'' +
            ", password='" + password + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return name.toUpperCase().equals(user.name.toUpperCase()) && password.equals(user.password);
  }

  @Override
  public int hashCode() {
    return 31*name.length() + 13*password.length();
  }
}
