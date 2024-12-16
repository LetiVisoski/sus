package org.example.sus;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @FXML
    public void start(Stage stage) throws IOException {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("inicio.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage novaJanela = new Stage();
            novaJanela.setScene(scene);
            novaJanela.setTitle("Minha Aplicação JavaFX");
            novaJanela.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }


}
