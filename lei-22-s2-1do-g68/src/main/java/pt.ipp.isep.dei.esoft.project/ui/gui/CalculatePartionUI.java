package pt.ipp.isep.dei.esoft.project.ui.gui;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import pt.ipp.isep.dei.esoft.project.application.controller.CalculatePartitionController;


public class CalculatePartionUI implements  Initializable{

    private MainUI mainUI;
    @FXML
    private Button button;
    @FXML
    private TextField infoToDisplay;

    @FXML
    private TextField nNumber;
    private CalculatePartitionController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new CalculatePartitionController();

    }

    public void setMainUI(MainUI mainUI) {
        this.mainUI = mainUI;
    }
}
