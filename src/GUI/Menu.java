package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by david on 10/01/2018.
 */
public class Menu extends Application {
    public static final int HEIGHT = 480;
    public static final int WIDTH = 640;
    public static final int BOARD_SIZE = 4;

    @Override
    public void start(Stage primaryStage) {
        Scene menuScene;

        try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource("Menu.fxml"));

            menuScene = new Scene(root,WIDTH, HEIGHT);
            menuScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            primaryStage.setTitle("Reversi");
            primaryStage.setScene(menuScene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
