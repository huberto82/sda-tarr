package programowanie_zaawansowane.c1_json;

import javax.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

public class JsonPReadDemo {
  public static void main(String[] args) {
    try{
      //Adres url z api generującego dane w json
      URL url = new URL("https://api-v3.mojepanstwo.pl/dane/zamowienia_publiczne.json");
      //tworzymy fabrykę readera
      JsonReaderFactory readerFactory = Json.createReaderFactory(Collections.emptyMap());
      //uzyskujemy readera odczytującego dane ze strumienia url-a
      JsonReader jsonReader = readerFactory.createReader(url.openStream());
      //odczytanie danych w json do obiektu klasy JsonObject
      JsonObject jsonObj = jsonReader.readObject();
      //można teraz odczytać dane z obiektu odwołując się do składowych
      /*
        {                                                             obiekt
          "Dataobject":                                               nazwa obiektu
          [                                                           tablica
            {                                                         obiekt bez nazwy, numer 0
              "id": "1767324",                                        klucz: wartość
              "dataset": "zamowienie_publiczne",                      klucz: wartość
              ..
              "data":                                                 klucz: wartość typu obiekt
              {                                                       obiekt
                "zamówienia_publiczne_typy.symbol": "...",            klucz: wartość

              }

            }
          ]
        }
       */
      //Odczyt pierwszego obiektu, którego pole o kluczu "data" jest obiektem
      jsonObj
        .getJsonArray("Dataobject")                   //pobranie tablicy Dataobject
        .get(0).asJsonObject()                            //pobranie elementu o indeksie 0 i jego konwersja do obiektu
        .forEach((key, val)-> {                           //dla każdego klucza key o wartości val
          if (key.equals("data")) {                       //jeśli to pole o kluczu "data" to
              val.asJsonObject()                              //konwersja wartości pola na obiekt
              .forEach((k, v) -> {                            //dla każdego klucza k i wartości v
              System.out.println("\t" + k + " :: " + v);      //wyświetlenie pól zagnieżdżonego obiektu
            });
          } else {
            System.out.println(key + " :: " + val);       //wyświetlenie pól obiektu
          }
        });
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
