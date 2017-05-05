package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.dataBase.TextFile;

import java.util.List;
import java.util.stream.Collectors;

public class SectionForBossController {

    @FXML
    TableView<Employee> table;
    @FXML
    TableColumn<Employee, String> tableColumnName;
    @FXML
    TableColumn<Employee, String> tableColumnLastName;
    @FXML
    TableColumn<Employee, String> tableColumnSalary;
    @FXML
    TextField textFieldSalary;
    @FXML
    TextField textFieldRise;

    Main main;

    public void showEmployeeWithSalaryAbove(){
        float salary = Float.parseFloat(textFieldSalary.getText());
        ObservableList<Employee> lista = FXCollections.observableArrayList();

            for(Employee p : main.getList()){
                if (p.getSalary() > salary) {
                    lista.add(p);
                }
            }

        table.setItems(lista);
        tableColumnLastName.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        tableColumnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableColumnSalary.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asString());

    }

    public void setMain (Main main){
        this.main = main;
    }

    public void riseForAll(){
        for(int i = 0; i < main.getList().size(); i++){
            float salary = (float) (main.getList().get(i).getSalary() * (1.1)) ;
            main.getList().get(i).setSalary(salary);
        }
    }
    public void rise(){
        int index = main.getList().indexOf(table.getSelectionModel().selectedItemProperty().getValue());
        float rise = Float.parseFloat(textFieldRise.getText());
        main.getList().get(index).setSalary(main.getList().get(index).getSalary() + rise);
    }

}
