package programowanie_zaawansowane.exercise2.kantor;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ChangeMoneyApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    GridPane root = new GridPane();
    root.setVgap(10);
    root.setHgap(10);
    root.setAlignment(Pos.CENTER);

    Scene scene = new Scene(root, 400, 500);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Czendżmany.pl");
    primaryStage.show();

    List<CurrencyJsonReader.CurrencyRate> list;
    List<CurrencyJsonReader.CurrencyRate> temp = new ArrayList<>(); // dodane
    root.add(new Label("Waluta"), 0, 0);
    ComboBox<String> currency = new ComboBox<>();
    try {                                                           //dodane
      CurrencyJsonReader reader = new CurrencyJsonReader();
      temp = reader.getCurrencies();                                //zmienione
      for (CurrencyJsonReader.CurrencyRate item : temp) {           //zmienione list na temp
        currency.getItems().add(item.name);
      }
      currency.getSelectionModel().select(0);
    } catch (MalformedURLException e) {                             //dodane
      Alert info = new Alert(Alert.AlertType.ERROR);
      info.setHeaderText("Niepoprawny format url do API!");
      info.setContentText("Nie można pobrać kursów walut.");
      info.show();
    } catch (IOException e) {                                       //dodane
      Alert info = new Alert(Alert.AlertType.ERROR);
      info.setHeaderText("Błąd sieci!");
      info.setContentText("Nie można pobrać kursów walut.");
      info.show();
    } finally {                                                     //dodane
      list = temp;
    }
    root.add(currency,1,0);

    root.add(new Label("Kurs"),0,1);
    TextField kurs = new TextField();
    kurs.setEditable(false);
    root.add(kurs,1,1);

    root.add(new Label("Kwota w zł"),0,2);
    TextField amountZL = new TextField();
    root.add(amountZL, 1,2);

    root.add(new Label("Kwota w walucie"),0,3);
    TextField amountC = new TextField();
    amountC.setEditable(false);
    root.add(amountC,1,3);

    currency.setOnAction(event -> {
      if (!amountZL.getText().equals("") && currency.getSelectionModel().getSelectedIndex() > -1) {
        //pobranie indeksu pozycji wybranej z listy walut
        int index = currency.getSelectionModel().getSelectedIndex();
        //pobranie rekordu z listy kursów
        CurrencyJsonReader.CurrencyRate rate = list.get(index);
        //konwersja pola teksowego z kwotą w złotowkach na typ double
        double kwota = Double.parseDouble(amountZL.getText());
        //obliczenie kwoty w walucie i umieszczenie jej w kontrolce kwoty w walucie
        amountC.setText((kwota / rate.rate) + "");
      }
    });

    amountZL.setOnAction(event -> {
      if (!amountZL.getText().equals("") && currency.getSelectionModel().getSelectedIndex() > -1) {
        //pobranie indeksu pozycji wybranej z listy walut
        int index = currency.getSelectionModel().getSelectedIndex();
        //pobranie rekordu z listy kursów
        CurrencyJsonReader.CurrencyRate rate = list.get(index);
        //konwersja pola teksowego z kwotą w złotowkach na typ double
        double kwota = Double.parseDouble(amountZL.getText());
        //obliczenie kwoty w walucie i umieszczenie jej w kontrolce kwoty w walucie
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMaximumFractionDigits(2);
        amountC.setText(format.format(kwota/rate.rate));
      }
    });

    amountZL.setOnKeyReleased(event -> {
      String str = amountZL.getText();
      try {
        double kwota = Double.parseDouble(amountZL.getText());
      }catch(NumberFormatException e){
        amountZL.setText("");
      }
    });

  }
}
