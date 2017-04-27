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
        loader.setLocation(Main.class.getResource("EditEmployee.fxml"));
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
        loader.setLocation(Main.class.getResource("AddNewEmployee.fxml"));
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
    public void initMainMenu() throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("MainManu.fxml"));
            BorderPane mainMenu =  loader.load();

            rootLayout.setCenter(mainMenu);

           MainManuController controller = loader.getController();
           controller.setMain(this);

    }
    @FXML
    public static void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("RootLayout.fxml"));
        rootLayout = loader.load();

        Scene ramka = new Scene(rootLayout);
        primaryStage.setScene(ramka);
        primaryStage.show();
    }

    public ObservableList<Employee> getList() {
        return list;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

