package programowanie_zaawansowane.c2_javafx;

import com.sun.javaws.jnl.JavaFXRuntimeDesc;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ImageDemo extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    GridPane root = new GridPane();
    Scene scene = new Scene(root, 400, 500);
    root.setAlignment(Pos.CENTER);
    root.setVgap(10);
    String remoteUrl = "https://ss7.vzw.com/is/image/VerizonWireless/iphone6s-plus-gld-front?$png8alpha256$&hei=410";
    Image remoteImage = new Image(remoteUrl, true);
    TextField urlField = new TextField();
    Button downloadButton = new Button("Pobierz obraz");
    ImageView imageView = new ImageView(remoteImage);
    ProgressIndicator progress = new ProgressIndicator();
    progress.setVisible(false);
    downloadButton.setOnAction(event->{
      Image img = new Image(urlField.getText(), true);
      progress.setVisible(true);
      imageView.setImage(img);
      new Thread(()->{
        while(img.getProgress() < 1.0){
          try {
            Thread.sleep(1);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        progress.setVisible(false);
      }).start();
    });
    //Nie blokujące UI pobieranie obrazu z podnego url
    root.add(imageView,0,0);
    root.add(urlField,0, 1);
    root.add(downloadButton, 0, 2);
    root.add(progress, 0, 0);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Image Demo");
    primaryStage.setResizable(true);
    primaryStage.show();
  }
}
