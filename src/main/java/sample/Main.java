package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private ObservableList<Employee> list = FXCollections.observableArrayList();
    private static Stage primaryStage;
    private static BorderPane rootLayout;

    public Main(){
    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Company Staff");

        initRootLayout();
        initMainMenu();

    }
    @FXML
    public void showEditStage(int index) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("EditEmployee.fxml"));
        BorderPane editEmployee =  loader.load();
        Stage editDialogStage = new Stage();
        editDialogStage.setTitle("Edit Employee");
        editDialogStage.initModality(Modality.WINDOW_MODAL);
        editDialogStage.initOwner(primaryStage);

        Scene scene = new Scene (editEmployee);
        editDialogStage.setScene(scene);

        EditEmployeeController controller2 = loader.getController();
        controller2.setMain(this);
        controller2.setIndex(index);
        controller2.setFields();


        editDialogStage.showAndWait();

    }

    @FXML
    public void showAddStage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("AddNewEmployee.fxml"));
        BorderPane addNewEmployee =  loader.load();
        Stage addDialogStage = new Stage();
        addDialogStage.setTitle("Add mew Employee");
        addDialogStage.initModality(Modality.WINDOW_MODAL);
        addDialogStage.initOwner(primaryStage);

        Scene scene = new Scene (addNewEmployee);
        addDialogStage.setScene(scene);
        AddNewEmploeeController controller = loader.getController();
        controller.setMain(this);


        addDialogStage.showAndWait();

    }

    @FXML
    public void showAvgParentSalary() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("AvgParentSalary.fxml"));
        Pane longestLastName=  loader.load();
        Stage avgParentSalary = new Stage();

        avgParentSalary.initModality(Modality.WINDOW_MODAL);
        avgParentSalary.initOwner(primaryStage);

        Scene scene = new Scene (longestLastName);
        avgParentSalary.setScene(scene);
        AvarageParentSalaryController controller = loader.getController();
        controller.setMain(this);
        controller.setLabelAavgParentSalary();

        avgParentSalary.showAndWait();
    }
    @FXML
    public void showEncryptLastName() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("EncryptLastName.fxml"));
        Pane crypt =  loader.load();
        Stage addEncryptLastName = new Stage();

        addEncryptLastName.initModality(Modality.WINDOW_MODAL);
        addEncryptLastName.initOwner(primaryStage);

        Scene scene = new Scene (crypt);
        addEncryptLastName.setScene(scene);
        EncryptLastNameController controller = loader.getController();
        controller.setMain(this);

        addEncryptLastName.showAndWait();
    }
    @FXML
    public void showLongestLastName() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("LongestLastName.fxml"));
        Pane longestLastName=  loader.load();
        Stage addLongestLastName = new Stage();

        addLongestLastName.initModality(Modality.WINDOW_MODAL);
        addLongestLastName.initOwner(primaryStage);

        Scene scene = new Scene (longestLastName);
        addLongestLastName.setScene(scene);
        LongestLastNameController controller = loader.getController();
        controller.setMain(this);
        controller.longestLastName();


        addLongestLastName.showAndWait();
    }
    @FXML
    public void initMainMenu() throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("MainManu.fxml"));
            BorderPane mainMenu =  loader.load();

            rootLayout.setCenter(mainMenu);

           MainManuController controller = loader.getController();
           controller.setMain(this);

    }
    @FXML
    public void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("RootLayout.fxml"));
        rootLayout = loader.load();

        Scene ramka = new Scene(rootLayout);
        primaryStage.setScene(ramka);
        primaryStage.show();
    }

    public ObservableList<Employee> getList() {
        return list;
    }

    public Main getMain(){
        return this;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

