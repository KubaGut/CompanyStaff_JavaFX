package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Comparator;

public class AvarageParentSalaryController {

    @FXML
    Label labelAavgParentSalary;

    Main main;

    public void setMain(Main main){
        this.main = main;
    }

    public void setLabelAavgParentSalary(){
        float suma = 0; int n = 0;
        for(Employee p : main.getList()){
            if (p.getChildNumber() > 0){
                suma += p.getSalary();
                n++;
            }
        }
        labelAavgParentSalary.setText(String.valueOf(suma / n));
    }

}
