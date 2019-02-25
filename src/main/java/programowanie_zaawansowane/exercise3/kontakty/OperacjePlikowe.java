package programowanie_zaawansowane.exercise3.kontakty;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;

public class OperacjePlikowe {
  String sciezkaPliku;

  public OperacjePlikowe(String sciezkaPliku) {
    this.sciezkaPliku = sciezkaPliku;
  }

  public void zapisz(Collection<String> listaKontaktow){
    File plik = new File(sciezkaPliku);
    try (FileOutputStream strumien = new FileOutputStream(plik)){
      PrintWriter zapisywacz = new PrintWriter(strumien);
      for(String kontakt: listaKontaktow){
        zapisywacz.println(kontakt);
      }
      zapisywacz.close();
    } catch (FileNotFoundException e) {
      System.err.println("Nie znaleziono takiego pliku");
    } catch (IOException e) {
      System.err.println("Błąd podczas zapisu");
    }
  }

  public Collection<String> odczytaj(){
    Path plik = Paths.get(sciezkaPliku);
    try {
      return Files.readAllLines(plik);
    } catch (IOException e) {
      System.err.println("Błąd podczas odczytu");
      return Collections.EMPTY_LIST;
    }
  }
}
