package mainController;


import FirstWindow.FirstWindowController;
import Utils.AlertBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.CrossWord;

import java.io.PrintWriter;
import java.util.List;
import java.util.function.Predicate;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Model;
public class MainWindowController {

    private Stage primaryStage;

    @FXML
    private TableView<CrossWord> mainTableView;
    @FXML
    private TableColumn<CrossWord, String> passwordColumn, descriptionColumn;
    @FXML
    private TextField newCrossWord;
    @FXML
    private TextField newDescription;
    @FXML
    private TextField filterFiled;

    FirstWindowController firstWindowController = new FirstWindowController();
    private ObservableList<CrossWord> crossWordList = FXCollections.observableArrayList();

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        mainTableView.setItems(crossWordList);
    }

    @FXML
    public void initialize() throws IOException {
        passwordColumn.setCellValueFactory(
                new PropertyValueFactory<CrossWord, String>("crossword"));
        descriptionColumn.setCellValueFactory(
                new PropertyValueFactory<CrossWord, String>("description"));

        FilteredList<CrossWord> filteredData = new FilteredList<>(crossWordList, s -> true);
        filterFiled.setOnKeyReleased(e -> {
            filterFiled.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                filteredData.setPredicate((Predicate<? super CrossWord>) cross -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    if (newValue == "5"){
                        return true;
                    }

                    if (cross.getCrossword().toLowerCase().contains(newValue)) {
                        return true;
                    }

                    return false;
                });
            });
            SortedList<CrossWord> sortedList = new SortedList<>(filteredData);
            sortedList.comparatorProperty().bind(mainTableView.comparatorProperty());
            mainTableView.setItems(sortedList);
        });
        firstWindowController.initFirstWindow();
    }

    @FXML
    public void uploadFile() {
        Scanner in = null;

        File file = Model.chooseFile("open", "Wczytaj plik...", primaryStage);
        if (file == null) return;
        try {
            in = new Scanner(file);
            in.useDelimiter("/");
            if (!(file.length() == 0)) {
                while (in.hasNext()) {
                    CrossWord crossWord = new CrossWord(in.next().trim(), in.next().trim());
                    crossWordList.add(crossWord);
                }
            } else {
                AlertBox.alertInfo("Plik", "Plik jest pusty");
            }
        } catch (IOException e) {
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    @FXML
    void saveArrayToFile() {
        saveFile(crossWordList);
    }

    public void saveFile(List<CrossWord> crossWordListSave) {
        if (!mainTableView.getItems().isEmpty()) {
            PrintWriter printWriter = null;
            try {
                File file = Model.chooseFile("save", "Zapisz plik...", primaryStage);
                if (file == null) return;
                printWriter = new PrintWriter(file);
                for (CrossWord crossWord : crossWordListSave) {
                    printWriter.printf("%s/%s/", crossWord.getCrossword(), crossWord.getDescription());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (printWriter != null) {
                    printWriter.close();
                }
            }
        } else {
            AlertBox.alertInfo("Zapis...", "Brak danych do zapisu");
        }
    }

    @FXML
    void addNewCrossWord() {
        if (newCrossWord.getText().isEmpty() || newDescription.getText().isEmpty()) {
            AlertBox.alertInfo("Brak danych", "Uzupełnij dane w polach");
        } else {
            crossWordList.add(new CrossWord(newCrossWord.getText(), newDescription.getText()));
            newCrossWord.clear();
            newDescription.clear();
        }
    }

    @FXML
    public void deleteCroosWord() {
        mainTableView.getItems().removeAll(mainTableView.getSelectionModel().getSelectedItem());
    }

    @FXML
    void cleanTable() {
        if (crossWordList.isEmpty())
            AlertBox.alertInfo("Wyczyść dane", "W tabeli brak danych");
        else
            setAlertConfirmation("Wyczyść dane");
    }

    public void setAlertConfirmation(String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText("Czy napewno chcesz usunąć dane ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
            crossWordList.clear();
    }

    @FXML
    void aboutApp() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/InfoWindow.fxml"));
        Parent root1 = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Informacja o programie");
        stage.setScene(new Scene(root1));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void exitConf() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/ExitWindow.fxml"));
        Parent root1 = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Informacja o programie");
        Scene scene = new Scene(root1);
        scene.getStylesheets().add("/view/app.css");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void closeProgram() {
        primaryStage.close();
    }
}




