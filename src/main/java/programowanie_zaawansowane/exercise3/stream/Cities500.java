package programowanie_zaawansowane.exercise3.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Cities500 {
  static final int ID = 0;
  static final int NAZWA = 1;
  static final int SZER_GEO = 4;
  static final int DLUG_GEO = 5;
  static final int KOD = 8;
  static final int POPULACJA = 14;
  static final int STREFA = 17;
  static final Logger log = Logger.getLogger("cities500");

  public static void main(String[] args) throws IOException {
    //ustawienie ściezki do pliku loga
    log.addHandler(new FileHandler("cities_log.log"));
    Path plik = Paths.get("c:\\temp\\cities500.txt");
    Stream<String> st = Files.lines(plik);
    //wszystkie miasta
    log.log(Level.INFO,"Zapytanie wyświetlające wszystkie miasta w pliku");
    st.forEach(linia->System.out.println(linia.split("\t")[NAZWA] + " " + linia.split("\t")[SZER_GEO] +" " +linia.split("\t")[DLUG_GEO]));
    //miasta polskie
    Files.lines(plik).filter(linia -> linia.split("\t")[KOD].equals("PL")).forEach(linia -> System.out.println(linia));
    //liczba polskich miast
    long n = Files.lines(plik).filter(linia -> linia.split("\t")[KOD].equals("PL")).count();
    System.out.println("Liczba polskich miast " + n);
    //liczba miast ze strefy czasowej Europe/Andorra
    long k = Files.lines(plik).filter(linia -> linia.split("\t")[STREFA].equals("Europe/Andorra")).count();
    System.out.println("Liczba miast Europe/Andorra " + k);
    //najmniejsza populacja miasta ze strefy Europa/Androrra
    Files.lines(plik)
            .filter(linia -> linia.split("\t")[STREFA].equals("Europe/Andorra"))
            .map(linia->Integer.parseInt(linia.split("\t")[POPULACJA]))
            .min((a, b)->{
                if (a < b) {
                  return -1;
                }
                if (a > b) {
                  return 1;
                }
                return 0;
              }).ifPresent(val->System.out.println(val));
    //nazyw miast zaczynających się literami En
    Files.lines(plik)
            .filter(linia -> linia.split("\t")[NAZWA].charAt(0) == 'E')
            .filter(linia -> linia.split("\t")[NAZWA].charAt(1) == 'n')
            .forEach(linia -> System.out.println(linia.split("\t")[NAZWA]));
    //suma populacji wszyskich miast
    Files.lines(plik)
            .map(linia -> linia.split("\t")[POPULACJA])
            .map(lancuch -> Long.parseLong(lancuch))
            .reduce((liczba, suma) -> suma = suma + liczba)
            .ifPresent(val -> System.out.println(NumberFormat.getInstance().format(val)));

    Optional wynik = Files.lines(plik)
            .map(linia -> linia.split("\t")[POPULACJA])
            .map(lancuch -> Long.parseLong(lancuch))
            .reduce((liczba, suma) -> suma = suma + liczba);

    //średnia populacja miast w Polsce
    //suma populacji polskich miast przez liczbe polskich miast
    Optional sumaPL = Files.lines(plik)
            .filter(linia->linia.split("\t")[KOD].equals("PL"))
            .map(linia-> linia.split("\t")[POPULACJA])
            .map(liczba-> Long.parseLong(liczba))
            .reduce((liczba, suma)-> suma+=liczba);
    n = Files.lines(plik)
            .filter(linia->linia.split("\t")[KOD].equals("PL"))
            .count();
    long suma = (long) sumaPL.get();
    System.out.println("Srednia " + suma/n);

    //posortowana wg długości nazw lista polskich miast
    Files.lines(plik)
            .filter(linia->linia.split("\t")[KOD].equals("PL"))
            .map(linia -> linia.split("\t")[NAZWA])
            .sorted((a, b)->{
              if (a.length() > b.length()){
                return 1;
              }
              if (a.length() < b.length()){
                return -1;
              }
              return 0;
            }).forEach(v->System.out.println(v));
    //posortowana wg populacji lista polskich miast
    log.log(Level.INFO,"Posortowana lista polskich miast wg populacji.");
    Files.lines(plik)
            .filter(linia->linia.split("\t")[KOD].equals("PL"))
            .sorted((a,b)->{
              long pa = Long.parseLong(a.split("\t")[POPULACJA]);
              long pb = Long.parseLong(b.split("\t")[POPULACJA]);
              /*
              if(pa > pb)
                return 1;
               else if (pa < pb)
                return -1;
               else
                return 0;
               */
              return pa > pb ? 1 : pa < pb ? -1 : 0;
            })
            .forEach(v->System.out.println(v.split("\t")[NAZWA]+ " "+
                    v.split("\t")[POPULACJA]));
  }
}
