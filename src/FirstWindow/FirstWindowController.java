package FirstWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;

public class FirstWindowController {

    @FXML
    private Button openMainApp;
    @FXML
    private TextField passwordTextFiled;
    @FXML
    private TextField userTextFiled;


    public void initFirstWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/FirstWindow.fxml"));
        Parent root1 = loader.load();
        Stage stage = new Stage();
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Witamy");
        Scene scene = new Scene(root1);
        scene.getStylesheets().add("/view/app.css");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.isAlwaysOnTop();
        stage.showAndWait();
    }


    public void exit() {
        System.exit(0);
    }

    public void openMainApp() {
        Stage stage = (Stage) openMainApp.getScene().getWindow();
        stage.close();
    }
}

