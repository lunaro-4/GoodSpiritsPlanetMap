package ipap.training.goodspiritsplanetmap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MapApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MapApp.class.getResource("map-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ivanushka's path");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}