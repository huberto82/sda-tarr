package programowanie_zaawansowane.exercise3.net;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProstySerwerTest {

  @Test
  void dodaj() {
    ProstySerwer.dodaj(10);
    assertEquals(10, ProstySerwer.suma());
    ProstySerwer.dodaj(100_000);
    assertEquals(100_010, ProstySerwer.suma());

  }

  @Test
  void suma() {
    assertEquals(0, ProstySerwer.suma());
  }
}