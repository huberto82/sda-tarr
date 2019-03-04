package programowanie_zaawansowane.exercise3.test;

import java.time.LocalDate;

public class Person {
  private final String nazwisko;
  private String haslo;
  private final LocalDate urodziny;

  private Person(String nazwisko, LocalDate urodziny) {
    this.nazwisko = nazwisko;
    this.urodziny = urodziny;
  }

  static Person utworz(String nazwisko, LocalDate urodziny){
    if (urodziny == null){
      return null;
    }
    if (urodziny.isBefore(LocalDate.now()) || urodziny.isEqual(LocalDate.now())){
       return new Person(nazwisko,urodziny);
    }
    return null;
  }

  public boolean poprawneHaslo(String wpisaneHaslo){
    return haslo.equals(wpisaneHaslo);
  }

  public void setHaslo(String haslo) {
    this.haslo = haslo;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public LocalDate getUrodziny() {
    return urodziny;
  }

  public int wiek() {
    LocalDate burodziny = LocalDate.of(LocalDate.now().getYear(), urodziny.getMonth(), urodziny.getDayOfMonth());
    if (LocalDate.now().isAfter(burodziny)) {
      return LocalDate.now().getYear() - urodziny.getYear();
    } else {
      return LocalDate.now().getYear() - urodziny.getYear() - 1;
    }
  }
}
