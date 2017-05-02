package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Comparator;

public class LongestLastNameController {

    @FXML
    Label labelLongestLastName;

    Main main;

    public void setMain(Main main){
        this.main = main;
    }

    public void longestLastName(){
        Comparator<Employee> byLastName = (e1, e2) -> Integer.compare(e1.getLastName().length(), e2.getLastName().length());
        labelLongestLastName.setText(String.valueOf(main.getList().stream().max(byLastName).get().getLastName()));
    }
}

