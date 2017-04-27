package sample;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLMessage;
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

public class EditEmployeeController {

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
    public int index;

    public void setIndex(int index){
        this.index = index;
    }

    @FXML
    private void initialize() {
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
        main.getList().remove(index);
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
                departmentChoiceBox.getValue().toString(),
                parseFloat(salaryFIeld.getText()),
                parseInt(ageField.getText()))
                .childNumber(children).marital(married));
        //System.out.println(employee.toString());
        main.getList().add(index, employee);
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void cancelButton() throws IOException {
       Stage stage = (Stage) cancelButton.getScene().getWindow();
       stage.close();
    }
    public void setFields(){
        nameFIeld.setText(main.getList().get(index).getName().toString());
        lastNameFIeld.setText(main.getList().get(index).getLastName().toString());
        salaryFIeld.setText(String.valueOf(main.getList().get(index).getSalary()));
        ageField.setText(String.valueOf(main.getList().get(index).getAge()));
        childrenNumber.setText(String.valueOf(main.getList().get(index).getChildNumber()));
        departmentChoiceBox.setValue(main.getList().get(index).getDepNumber());

        if (main.getList().get(index).getGender().equals("Male")){
            maleButton.fire();
        } else {
            femaleButton.fire();
        }

        if (main.getList().get(index).getMarital().equals("Single")){
            singleButton.fire();
        } else {
            marriedButton.fire();
        }

    }

    public void setMain (Main main){
        this.main = main;
    }

}



