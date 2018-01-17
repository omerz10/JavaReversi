package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by david on 14/01/2018.
 */
public class SettingsController implements Initializable {

    @FXML
    private Button quitButton;

    @FXML
    private MenuButton colorMenu;

    //private TextFile textFile;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // load text file for read/write

        //colorMenu.
        //colorMenu.getItems().addAll(new MenuItem("Yellow"), new MenuItem("Green"));
    }

    @FXML
    private void handleQuitButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }


}
