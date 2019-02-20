package programowanie_zaawansowane.c5_equals;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
  final private String firstName;
  final private String lastName;
  final private LocalDate birthDate;

  public Person(String firstName, String lastName, LocalDate birthDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  @Override
  public String toString() {
    return "Person{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", birthDate=" + birthDate +
            '}';
  }
  /**
   * Kontrakt equals
   * 1. zwrotność       - obj.qeuals(obj) powinno zwrócić true
   * 2. symetryczność   - a.equals(b) == b.equals(a)
   * 3. przechodniość   - jeśli a.equals(b) == true i b.equals(c) == true to a.equals(c) == true
   * 4. spójność        - dla nie zmienionego obiektu obj wartość equals musi być zawsze taka sama
   */
  /**
   * Warunki równości obiektów
   *     1. Obiekt jest sam sobie równy
   *     2. Obiekty różnych typów nie są sobie równe
   *     3. Obiekty są sobie równe, jeśli pola każdej pary są identyczne
   */
  @Override
  public boolean equals(Object o) {
    if (this == o)                                              // 1
      return true;
    if (!(o instanceof Person))                                 // 2
      return false;
    Person person = (Person) o;
    return  getFirstName().equals(person.getFirstName()) &&     //3
            getLastName().equals(person.getLastName()) &&
            getBirthDate().equals(person.getBirthDate());
  }

  /**
   * Kontrakt między equals i hashCode
   * 1. Jeśli a.equals(b) == true to a.hashCode() == b.hasCode()
   * 2. Jeśli a.hashCode() == b.hasCode() to nie oznacza, że a.equals(b) == true
   */

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName(), getBirthDate());
  }
}
