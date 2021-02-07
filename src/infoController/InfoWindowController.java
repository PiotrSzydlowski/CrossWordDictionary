package infoController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class InfoWindowController {

    @FXML
    private Button closeButton;

    @FXML
    public void closeWindowButton() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void closeProgram() {
        System.exit(0);
    }
}
