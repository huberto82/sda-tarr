package programowanie_zaawansowane.c7_unit_test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

  @org.junit.jupiter.api.Test
  void getAge() {
    Person p = new Person("Adam", "Kowalski", LocalDate.of(2000, 10, 10));
    assertEquals(p.getAge(), 18, "Wiek powinien wynosić 18");
    p = new Person("Adam", "Kowalski", LocalDate.of(2001, 2, 11));
    assertEquals(p.getAge(), 18, "Wiek powinien wynosić 17");

  }
}