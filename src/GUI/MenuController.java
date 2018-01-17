package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by david on 13/01/2018.
 */
public class MenuController implements Initializable {
    @FXML
    private Button startButton, settingsButton, quitButton;
    @FXML
    private ImageView wallpaperImage;
    @FXML
    private Pane root;
    @FXML
    private BorderPane borderPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            double boardNewWidth = newValue.doubleValue();
            borderPane.setPrefWidth(boardNewWidth);
            wallpaperImage.setFitWidth(boardNewWidth);
        });
        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            double boardNewHeight = newValue.doubleValue();
            borderPane.setPrefHeight(boardNewHeight);
            wallpaperImage.setFitHeight(boardNewHeight);
        });

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        if(event.getSource() == startButton){
            Stage stage;
            Parent root;
            //get reference to the button's stage
            stage = (Stage) startButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("Reversi.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource() == settingsButton){
            Stage stage;
            Parent newRoot;
            newRoot = FXMLLoader.load(getClass().getResource("Settings.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(newRoot);
            stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } else if (event.getSource() == quitButton) {
            Stage stage = (Stage) quitButton.getScene().getWindow();
            stage.close();
        }
    }
}
