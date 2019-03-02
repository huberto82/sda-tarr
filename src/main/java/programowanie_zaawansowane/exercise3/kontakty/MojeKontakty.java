package programowanie_zaawansowane.exercise3.kontakty;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

public class MojeKontakty extends Application {
  final String sciezka = "kontakty.txt";
  ImageView obrazek = new ImageView();
  OperacjePlikowe operacjePlikowe = new OperacjePlikowe(sciezka);
  GridPane root = new GridPane();
  TextField imie = new TextField("");
  Label imieEtykieta = new Label("Imię");
  TextField nazwisko = new TextField("");
  Label nazwiskoEtykieta = new Label("Nazwisko");
  TextField telefon = new TextField("");
  Label telefonEtykieta = new Label("Nr telefonu");
  DatePicker dataUrodzin = new DatePicker(LocalDate.now());
  Label dataEtykieta = new Label("Data urodzin");
  Button dodaj = new Button("Dodaj");
  Button usun = new Button("Usuń");
  Button czysc = new Button("Wyczyść");
  Scene scene = new Scene(root);
  HBox przyciski = new HBox();
  ListView<String> listaKontaktow = new ListView<>();

  void wyczyscFormularz(){
    imie.setText("");
    imie.clear();
    nazwisko.setText("");
    nazwisko.clear();
    telefon.setText("");
    dataUrodzin.setValue(null);
  }

  boolean poprawneDane(){
    if (imie.getText() == null || imie.getText().length() < 2){
      return false;
    }
    if (nazwisko.getText() == null || nazwisko.getText().length() < 4){
      return false;
    }
    if (telefon.getText() == null || telefon.getText().length() < 10){
      return false;
    }
    if (dataUrodzin.getValue() == null){
      return false;
    }
    return true;
  }


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    listaKontaktow.getItems().addAll(operacjePlikowe.odczytaj());

    root.setVgap(10);
    root.setHgap(10);
    root.setPadding(new Insets(10, 10, 10, 10));
    root.setAlignment(Pos.CENTER_LEFT);

    root.add(imieEtykieta, 0, 0);
    root.add(imie, 1, 0);

    root.add(nazwiskoEtykieta, 0, 1);
    root.add(nazwisko, 1, 1);

    root.add(telefonEtykieta, 0, 2);
    root.add(telefon, 1, 2);

    root.add(dataEtykieta, 0, 3);
    root.add(dataUrodzin, 1, 3);

    przyciski.setAlignment(Pos.CENTER);
    przyciski.setSpacing(10);
    root.add(przyciski, 0, 4,2,1);

    przyciski.getChildren().add(dodaj);
    przyciski.getChildren().add(usun);
    przyciski.getChildren().add(czysc);
    czysc.setOnAction(event->{
      wyczyscFormularz();
    });

    root.add(listaKontaktow,0,5,2,1);
    root.add(obrazek, 0, 6, 2, 1);

    try {
      URL urlObrazka = new URL("https://media.etuistudio.pl/49181/etui-na-telefon-iphone-6-plus-baseus-aurora-czarny.jpg");

      Image obraz = new Image(urlObrazka.openStream());
      //Image obraz = new Image(new FileInputStream("c:\\temp\\a.jpg"));
      obrazek.setImage(obraz);
      obrazek.setPreserveRatio(true);
      obrazek.setFitWidth(200);
    } catch (MalformedURLException e) {
      System.err.println("Bład w URL zasobu");
    } catch (IOException e) {
      System.err.println("Bład pobrania obrazka");
    }

    dodaj.setOnAction(event->{
      if (poprawneDane()) {
        String dane = "";
        dane += imie.getText() + " ";
        dane += nazwisko.getText() + " ";
        dane += telefon.getText() + " ";
        dane += dataUrodzin.getValue().toString();
        listaKontaktow.getItems().add(dane);
        wyczyscFormularz();
        operacjePlikowe.zapisz(listaKontaktow.getItems());
      }
    });

    usun.setOnAction(event->{
      Alert okno = new Alert(Alert.AlertType.CONFIRMATION);
      okno.setContentText("Czy na pewno usunąć ten kontakt?");
      okno.showAndWait();
      if (okno.getResult() == ButtonType.OK) {
        int indeks = listaKontaktow.getSelectionModel().getSelectedIndex();
        if (indeks > -1) {
          listaKontaktow.getItems().remove(indeks);
          operacjePlikowe.zapisz(listaKontaktow.getItems());
        }
      }
    });

    primaryStage.setScene(scene);
    primaryStage.setTitle("Moje kontakty");
    primaryStage.show();
  }
}
