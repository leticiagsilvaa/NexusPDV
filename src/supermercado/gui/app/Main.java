package supermercado.gui.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    @Override
    public void start(Stage stage){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../telas/login.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {
        launch(args);
    }
}