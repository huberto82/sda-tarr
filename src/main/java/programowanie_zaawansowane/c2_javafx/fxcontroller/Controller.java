package programowanie_zaawansowane.c2_javafx.fxcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.function.UnaryOperator;

public class Controller {
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private DatePicker birthDate;

    @FXML
    private ComboBox eyeColor;

    @FXML
    private Button submitButton;

    @FXML
    private Spinner<Double> salary;

    public Controller(){
    }

    @FXML
    private void initialize(){
      eyeColor.getItems().add("zielone");
      eyeColor.getItems().add("niebieskie");
      eyeColor.getItems().add("piwne");
      SpinnerValueFactory<Double> factory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,10000,0);
      salary.setValueFactory(factory);

      UnaryOperator<TextFormatter.Change> filter = c -> {
        if (c.isContentChange() && c.getControlNewText().length() > 0) {
          try {
            Double.parseDouble(c.getControlNewText());
            return c;
          } catch (NumberFormatException e){
            return null;
          }
        }
        return c;
      };
      TextFormatter<Double> priceFormatter = new TextFormatter<Double>(
              new DoubleStringConverter(), 0.0, filter);
      salary.getEditor().setTextFormatter(priceFormatter);
    }

    @FXML
    public void add(){
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Tytuł alertu");
      alert.setHeaderText("Nagłówek");
      String s ="Tekst okna dialogowego... ";
      alert.setContentText(s);
      alert.show();
    }

}
