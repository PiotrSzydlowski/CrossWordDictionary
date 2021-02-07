package mainController;

import Utils.AlertBox;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/MainWindowView.fxml"));
        BorderPane root = loader.load();
        primaryStage.setTitle("Słownik haseł krzyżówkowych");
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(400);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/app.css");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        MainWindowController mainWindowController = loader.getController();
        mainWindowController.setPrimaryStage(primaryStage);

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}