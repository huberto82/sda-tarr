package programowanie_zaawansowane.exercise3.miasta;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class Controller {

  @FXML
  TableView tabela;

  @FXML
  TableColumn nazwa;

  @FXML
  TableColumn kod;

  @FXML
  TableColumn populacja;

  @FXML
  TextField filtrKodu;

  @FXML
  TextField filtrMiasta;

  ObservableList<Miasto> listaOryginalna;

  ObservableList<Miasto> listaTabeli;

  public Controller() {

  }

  public void initialize(){
     //ustawienie dla kolumny z nazwą miasta powiązania z polem nazwa w klasie Miasto
     nazwa.setCellValueFactory(new PropertyValueFactory<Miasto, String>("nazwa"));
     kod.setCellValueFactory(new PropertyValueFactory<Miasto,String>("kod"));
     populacja.setCellValueFactory(new PropertyValueFactory<Miasto, Integer>("populacja"));
    try {
      listaOryginalna = wczytaj();
      tabela.setItems(listaOryginalna);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ObservableList<Miasto> wczytaj() throws IOException {
    Path plik = Paths.get("C:\\temp\\cities500.txt");
    List<Miasto> lista = Files.lines(plik).map(linia ->{
      String nazwa = linia.split("\t")[1];
      String kod = linia.split("\t")[8];
      String pop = linia.split("\t")[14];
      int populacja = Integer.parseInt(pop);
      return new Miasto(nazwa, kod, populacja);
    }).collect(Collectors.toList());
    return FXCollections.observableArrayList(lista);
  }

  @FXML
  public void filtrujWgKodu(){
    String kod = filtrKodu.getText();
    listaTabeli = FXCollections.observableArrayList();
    if (kod.length()==0){
      tabela.setItems(listaOryginalna);
      return;
    }
    Iterator iterator = listaOryginalna.iterator();
    while(iterator.hasNext()){
      Miasto miasto = (Miasto) iterator.next();
      if (miasto.getKod().equals(kod)) {
        listaTabeli.add(miasto);
      }
    }
    tabela.setItems(listaTabeli);
  }

  @FXML
  public void filtrujWgMiasta(){
    String nazwaMiasta = filtrMiasta.getText();
    int wiersz = 0;
    for(int i = 0; i < listaOryginalna.size(); i++){
      Miasto miasto = listaOryginalna.get(i);
      if (miasto.getNazwa().equals(nazwaMiasta)){
        wiersz = i;
        break;
      }
    }

    tabela.getSelectionModel().select(wiersz, nazwa);
    tabela.scrollTo(wiersz);
  }
}
