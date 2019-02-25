package programowanie_zaawansowane.exercise3.json;

import java.math.BigDecimal;

public class KursWaluty {
  final String nazwa;
  final BigDecimal kurs;

  public KursWaluty(String nazwa, BigDecimal kurs) {
    this.nazwa = nazwa;
    this.kurs = kurs;
  }

  @Override
  public String toString() {
    return "KursWaluty{" +
            "nazwa='" + nazwa + '\'' +
            ", kurs=" + kurs +
            '}';
  }
}
