package exitController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExitWindowController {

    @FXML
    private Button closeButton;

    @FXML
    void closeWindow() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void exitApp() {
        System.exit(0);
    }
}
