package programowanie_zaawansowane.exercise3.test;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

  @Test
  void wiek() {
    Person ludzik = Person.utworz("Kowal", LocalDate.of(2000,1,1));
    Period wiek;
    if (ludzik != null) {
      wiek = Period.between(LocalDate.of(2000, 1, 1), LocalDate.now());
      assertEquals(wiek.getYears(), ludzik.wiek(), "Urodziny już były");
    }

    ludzik = Person.utworz("Kowal",LocalDate.of(2000,10,10));
    if (ludzik != null) {
      wiek = Period.between(ludzik.getUrodziny(), LocalDate.now());
      assertEquals(wiek.getYears(), ludzik.wiek(), "Urodziny dopiero będą");
    }

    ludzik = Person.utworz("Kowal", LocalDate.of(2019,1,1));
    if (ludzik!= null) {
      wiek = Period.between(ludzik.getUrodziny(), LocalDate.now());
      assertEquals(wiek.getYears(), ludzik.wiek());
    }

    ludzik = Person.utworz("Kowal", LocalDate.of(LocalDate.now().getYear()+1, 1, 1));
    assertEquals(null, ludzik, "Data urodzin w przyszłości");
  }
}