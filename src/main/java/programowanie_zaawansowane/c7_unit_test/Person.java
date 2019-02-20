package programowanie_zaawansowane.c7_unit_test;

import java.time.LocalDate;

/**
 * Klasa, w której należy przetestować metodę getAge()
 * Utwórz test metody
 * 1. kliknij na nazwę klasy
 * 2. wybierz poleceni Generate... następnie Test...
 * 3. W oknie:
 *  a. wybierz Testing Library -> JUnit5
 *  b. zaznacz metodę getAge()
 */
public class Person {
  final private String firstName;
  final private String lasName;
  final private LocalDate birthDate;

  public Person(String firstName, String lasName, LocalDate birthDate) {
    this.firstName = firstName;
    this.lasName = lasName;
    this.birthDate = birthDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLasName() {
    return lasName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public int getAge(){
    return LocalDate.now().getYear() - birthDate.getYear();
  }
}
