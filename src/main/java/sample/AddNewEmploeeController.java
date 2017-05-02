package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Calendar;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class AddNewEmploeeController {

    ObservableList<String> departemntNumber = FXCollections.observableArrayList("Produkcja", "Biuro", "Jakosc");

    @FXML
    private TextField nameFIeld;
    @FXML
    private TextField lastNameFIeld;
    @FXML
    private TextField salaryFIeld;
    @FXML
    private DatePicker dateOfBirht;
    @FXML
    private TextField ageField;
    @FXML
    private TextField childrenNumber;
    @FXML
    private ChoiceBox departmentChoiceBox;
    @FXML
    private RadioButton maleButton;
    @FXML
    private RadioButton femaleButton;
    @FXML
    private RadioButton singleButton;
    @FXML
    private RadioButton marriedButton;
    @FXML
    private javafx.scene.control.Button okButton;
    @FXML
    private javafx.scene.control.Button cancelButton;

    public Main main;

    @FXML
    private void initialize() {
      departmentChoiceBox.setValue("Produkcja");
      departmentChoiceBox.setItems(departemntNumber);
    }

    @FXML
    private void showAge(){
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int birthYear = (dateOfBirht.getValue().getYear());
        int age = year - birthYear;
        ageField.setText(Integer.toString(age));
    }
    @FXML
    private void okButton() throws IOException {
        String gender;
        Integer children = 0;
        String married = "Single";
        if (femaleButton.isSelected()){
            gender = "Female";
        }
        else {
            gender = "Male";
        }
        if (!(childrenNumber.getText().isEmpty())){
            children = parseInt(childrenNumber.getText());
        }
        if (marriedButton.isSelected()){
            married = "Married";
        }

        Employee employee = new Employee(new Employee.Builder(nameFIeld.getText(), lastNameFIeld.getText(), gender,
                departmentChoiceBox.getValue().toString(),parseFloat(salaryFIeld.getText()), parseInt(ageField.getText()))
                .childNumber(children).marital(married));
        main.getList().add(employee);
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void cancelButton() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void setMain (Main main){
        this.main = main;
    }

}
