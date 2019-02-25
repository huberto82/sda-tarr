package programowanie_zaawansowane.exercise3.json;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.*;

public class Waluty extends Application {
  TextField kwotaWWalucie = new TextField();
  TextField kwotaWZlotowkach = new TextField();
  VBox root = new VBox();
  URL urlWalut = new URL("http://api.nbp.pl/api/exchangerates/tables/A?format=json");
  ComboBox<KursWaluty> walutyCombo = new ComboBox<>();

  public Waluty() throws MalformedURLException {
  }

  List<KursWaluty> pobierzWalutyZJSON() throws IOException {
    JsonReaderFactory readerFactory = Json.createReaderFactory(Collections.emptyMap());
    JsonReader jsonReader = readerFactory.createReader(urlWalut.openStream());
    JsonArray waluty = jsonReader.readArray();
    List<KursWaluty> lista = new ArrayList<>();
    waluty
            .get(0)
            .asJsonObject()
            .getJsonArray("rates")
            .forEach((obj)->{
              String nazwaWaluty = obj.asJsonObject().get("currency").toString();
              String kursWaluty = obj.asJsonObject().get("mid").toString();
              lista.add(new KursWaluty(nazwaWaluty, new BigDecimal(kursWaluty)));
            });
    return lista;
  }

  void przelicz(){
    int indeks = walutyCombo.getSelectionModel().getSelectedIndex();
    KursWaluty waluta = walutyCombo.getItems().get(indeks);
    BigDecimal walutaB = new BigDecimal(kwotaWWalucie.getText());
    BigDecimal wynik = waluta.kurs.multiply(walutaB);
    kwotaWZlotowkach.setText(wynik.toString());
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    root.setPadding(new Insets(10,10,10,10));
    root.setSpacing(10);
    root.getChildren().add(walutyCombo);
    walutyCombo.getItems().addAll(pobierzWalutyZJSON());

    walutyCombo.setOnAction(event->{
      String liczba = kwotaWWalucie.getText();
      try {
        double wynik = Double.parseDouble(liczba);
        przelicz();
      } catch (NumberFormatException e){
        kwotaWWalucie.setText("");
      }
    });

    kwotaWWalucie.setOnAction(event->{
      String liczba = kwotaWWalucie.getText();
      try {
        double wynik = Double.parseDouble(liczba);
        przelicz();
      } catch (NumberFormatException e){
        kwotaWWalucie.setText("");
      }
    });

    root.getChildren().add(kwotaWWalucie);
    root.getChildren().add(kwotaWZlotowkach);
    kwotaWZlotowkach.setEditable(false);
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Waluty");
    primaryStage.show();

  }
}
