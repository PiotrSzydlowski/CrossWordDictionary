package model;


import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class Model {

    public static File chooseFile(String action, String windowTitle, Stage primaryStage) {
        File selectedFile;

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(windowTitle);

        String currentDir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "files";
        File file = new File(currentDir);
        fileChooser.setInitialDirectory(file);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plik tekstowy", "*.txt"));
        if (action.equals("open")) {
            selectedFile = fileChooser.showOpenDialog(primaryStage);
        } else if (action.equals("save")) {
            selectedFile = fileChooser.showSaveDialog(primaryStage);
        } else {
            selectedFile = null;
        }
        return selectedFile;
    }
}