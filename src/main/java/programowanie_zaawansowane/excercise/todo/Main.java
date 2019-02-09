package programowanie_zaawansowane.excercise.todo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/ui.fxml"));
        primaryStage.setTitle("TodoApp");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

//TODO Dodać przycisk do kasowania zadań deleteTask
//TODO Dodać metodę uruchamianą po naciśnięciu przycisku deleteTask o nazwie deleteTaskFromList
//TODO w metodzie usunąć zaznaczone zadanie z listTaskView