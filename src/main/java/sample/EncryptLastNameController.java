package sample;


import javafx.fxml.FXML;
import javafx.stage.Stage;
import sample.dataBase.TextFile;

import java.io.IOException;

public class EncryptLastNameController {

    @FXML
    private javafx.scene.control.Button yesButton;
    @FXML
    private javafx.scene.control.Button noButton;

    Main main;

    public void no() throws IOException {
        TextFile textFile = new TextFile();
        textFile.setMain(main.getMain());
        textFile.exportToFile();
        Stage stage = (Stage) noButton.getScene().getWindow();
        stage.close();
    }

    public void yes() throws IOException {
        TextFile textFile = new TextFile();
        textFile.setMain(main.getMain());
        textFile.exportToFileEncrypted();
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
    }
    public void setMain (Main main){
        this.main = main;
    }
}
