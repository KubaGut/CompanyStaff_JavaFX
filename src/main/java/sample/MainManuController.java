package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Comparator;

import sample.Main;
import sample.dataBase.HTML;
import sample.dataBase.JDBC;
import sample.dataBase.JSON;
import sample.dataBase.TextFile;

public class MainManuController {

    @FXML
    TableView<Employee> table;
    @FXML
    TableColumn<Employee, String> tableColumnName;
    @FXML
    TableColumn<Employee, String> tableColumnLastName;
    @FXML
    Label labelName;
    @FXML
    Label labelLastName;
    @FXML
    Label labelGender;
    @FXML
    Label labelDepartment;
    @FXML
    Label labelSalary;
    @FXML
    Label labelAge;
    @FXML
    Label labelChildren;
    @FXML
    Label labelMarital;
    @FXML
    Label labelAvgSalary;
    @FXML
    Label labelAvgProductionSalary;
    @FXML
    Label labelAvgQualitySalary;
    @FXML
    Label labelAvgOfficeSalary;
    @FXML
    Label labelManMaxSalary;
    @FXML
    Label labelWomanMaxSalary;
    @FXML
    Label labelRatio;


    public Main main;

    @FXML
    private void initialize() {
        tableColumnLastName.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        tableColumnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        table.getSelectionModel().selectedItemProperty().addListener((observable,x,y) -> showEmployeeDetails(y));
    }
    @FXML
    private void exportToJSON() throws SQLException, ClassNotFoundException, IOException {
        JSON json = new JSON();
        json.setMain(main.getMain());
        json.exportToJson();
    }


    @FXML
    private void exportToHTML() throws SQLException, ClassNotFoundException, IOException {
        HTML html = new HTML();
        html.setMain(main.getMain());
        html.exportToHTML();
    }

    @FXML
    private void exportToFile() throws SQLException, ClassNotFoundException, IOException {
        main.showEncryptLastName();
    }

    @FXML
    private void saveToJDBC() throws SQLException, ClassNotFoundException {
        JDBC jdbc = new JDBC();
        jdbc.getInstance();
        jdbc.setMain(main.getMain());
        jdbc.getData();
    }
    @FXML
    private void openFromJDBC() throws SQLException, ClassNotFoundException {
        JDBC jdbc = new JDBC();
        jdbc.getInstance();
        jdbc.setMain(main.getMain());
        jdbc.open();
    }

    @FXML
    private void edit() throws IOException {
        int index = main.getList().indexOf(table.getSelectionModel().selectedItemProperty().getValue());
        main.showEditStage(index);
    }
    @FXML
    private void delete() {
        main.getList().remove(main.getList().indexOf(table.getSelectionModel().selectedItemProperty().getValue()));
    }
    private void showEmployeeDetails(Employee employee){
        if (employee != null){
            labelName.setText(employee.getName());
            labelLastName.setText(employee.getLastName());
            labelAge.setText(String.valueOf(employee.getAge()));
            labelDepartment.setText(employee.getDepNumber());
            labelGender.setText(employee.getGender());
            labelSalary.setText(String.valueOf(employee.getSalary()));
            labelChildren.setText(String.valueOf(employee.getChildNumber()));
            labelMarital.setText(employee.getMarital());
        } else {
            labelName.setText("");
            labelLastName.setText("");
            labelAge.setText("");
            labelDepartment.setText("");
            labelGender.setText("");
            labelSalary.setText("");
            labelChildren.setText("");
            labelMarital.setText("");
        }
    }
    @FXML
    private void add() throws IOException {
        main.showAddStage();
    }
    @FXML
    private void bossSection() throws IOException {
        main.showBossSection();
    }
    public void setMain (Main main){
        this.main = main;
        table.setItems(main.getList());
    }
    public void setRatioLabel(){
        float man =  main.getList().stream().filter(s -> s.getGender().equals("Male")).count();
        float woman =  main.getList().stream().filter(s -> s.getGender().equals("Female")).count();
        labelRatio.setText(String.valueOf(man/woman));
    }
    public void setMaxLabel(){
        Comparator<Employee> bySalary = (e1, e2) -> Float.compare(e1.getSalary(), e2.getSalary());
        labelManMaxSalary.setText(String.valueOf(main.getList().stream().filter(s -> s.getGender().equals("Male")).max(bySalary).get().getSalary()));
        labelWomanMaxSalary.setText(String.valueOf(main.getList().stream().filter(s -> s.getGender().equals("Female")).max(bySalary).get().getSalary()));
    }

    public void setSalaryLabels(){
        labelAvgSalary.setText(String.valueOf(Math.round(avarageSalary())));
        labelAvgProductionSalary.setText(String.valueOf(Math.round(avarageProductionSalary())));
        labelAvgQualitySalary.setText(String.valueOf(Math.round(avarageQualitySalary())));
        labelAvgOfficeSalary.setText(String.valueOf(Math.round(avarageOfficeSalary())));

    }
    public float avarageSalary(){
        float srednia; float suma = 0;
            for (Employee p : main.getList()){
                suma += p.getSalary();
            }
        return (suma/ main.getList().size());
    }
    public float avarageProductionSalary(){
        float srednia; float suma = 0; int n = 0;
        for (Employee p : main.getList()){
            if (p.getDepNumber().equals("Produkcja"))
            suma += p.getSalary();
            n++;
        }
        return (suma/ n);
    }
    public float avarageQualitySalary() {
        float srednia;
        float suma = 0;
        int n = 0;
        for (Employee p : main.getList()) {
            if (p.getDepNumber().equals("Jakosc"))
                suma += p.getSalary();
            n++;
        }
        return (suma / n);
    }
    public float avarageOfficeSalary() {
        float srednia;
        float suma = 0;
        int n = 0;
        for (Employee p : main.getList()) {
            if (p.getDepNumber().equals("Biuro"))
                suma += p.getSalary();
            n++;
        }
        return (suma / n);
    }
    public void sotyBySalary(){
        Comparator<Employee> bySalary = (e1, e2) -> Float.compare(e1.getSalary(), e2.getSalary());
        main.getList().sort(bySalary);
    }
    public void longestLastName() throws IOException {
        main.showLongestLastName();
    }
    public void avgParentSalary() throws IOException {
        main.showAvgParentSalary();
    }

}
