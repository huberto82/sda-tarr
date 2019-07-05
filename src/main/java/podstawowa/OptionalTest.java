package podstawowa;

import java.util.Optional;

class User{
  private final String name;

  public User(String name) {
    this.name = name;
  }

  public Optional<String> getName() {
    return Optional.ofNullable(name);
  }
}

public class OptionalTest {
  public static void main(String[] args) {
    User user = new User(null);
    System.out.println(user.getName().orElse("Brak nazwiska").toUpperCase());
  }
}
