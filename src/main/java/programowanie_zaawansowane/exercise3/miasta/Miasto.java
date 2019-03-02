package programowanie_zaawansowane.exercise3.miasta;

public class Miasto {
  private final String nazwa;
  private final String kod;
  private final int populacja;

  public Miasto(String nazwa, String kod, int populacja) {
    this.nazwa = nazwa;
    this.kod = kod;
    this.populacja = populacja;
  }

  public String getNazwa() {
    return nazwa;
  }

  public String getKod() {
    return kod;
  }

  public int getPopulacja() {
    return populacja;
  }
}
