package GUI;

import GameFiles.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by david on 13/01/2018.
 */
public class ReversiController implements Initializable {
    @FXML
    private BorderPane root;
    @FXML
    private HBox topMenu;
    @FXML
    private Pane leftBorder;
    @FXML
    private Pane rightBorder;
    @FXML
    private Pane bottomBorder;
    @FXML
    private Pane boardPane;
    @FXML
    private Button quitButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Label currentPlayer;
    @FXML
    private Label playerScore1;
    @FXML
    private Label playerScore2;

    private GUIBoard GUIBoard;
    private GUIGameInfo gameInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // read from setting text file



        // init board
        this.gameInfo = GUIGameInfo.getInstance();
        this.gameInfo.setGame(Color.BLACK, Color.BLUE);

        //add set color map function according to types
        this.GUIBoard = this.gameInfo.getBoard();
        this.GUIBoard.setPrefWidth(0);
        this.GUIBoard.setPrefHeight(0);
        this.boardPane.getChildren().add(this.GUIBoard);
        this.root.setCenter(this.GUIBoard);


        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            double newRootWidth = newValue.doubleValue();

            bottomBorder.setPrefWidth(newRootWidth);

            topMenu.setPrefWidth(newRootWidth);

            boardPane.setPrefWidth(newRootWidth - leftBorder.getPrefWidth() - rightBorder.getPrefWidth());

            this.GUIBoard.setPrefWidth(newRootWidth - leftBorder.getPrefWidth() - rightBorder.getPrefWidth());

            this.GUIBoard.draw();
        });

        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            double newRootHeight = newValue.doubleValue();

            leftBorder.setPrefHeight(newRootHeight);

            rightBorder.setPrefHeight(newRootHeight);

            boardPane.setPrefHeight(newRootHeight - topMenu.getPrefHeight() - bottomBorder.getPrefHeight());

            this.GUIBoard.setPrefHeight(newRootHeight - topMenu.getPrefHeight() - bottomBorder.getPrefHeight());

            this.GUIBoard.draw();
        });

        this.GUIBoard.draw();

    }



    @FXML
    private void handleSettingsButton(ActionEvent event) throws IOException {
        if(event.getSource() == settingsButton) {
            Stage stage;
            Parent newRoot;
            newRoot = FXMLLoader.load(getClass().getResource("Settings.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(newRoot);
            stage = new Stage();
            stage.setScene(scene);
            // make it a popup
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
    }

    @FXML
    private void handleQuitButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    /*
    private String getPlayerType(Player currentPlayer) {
        if (currentPlayer.getType() == 'X') {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }
    */
}
