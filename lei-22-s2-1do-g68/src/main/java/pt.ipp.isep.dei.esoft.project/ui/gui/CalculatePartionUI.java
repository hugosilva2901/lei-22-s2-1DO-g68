package pt.ipp.isep.dei.esoft.project.ui.gui;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import pt.ipp.isep.dei.esoft.project.application.controller.CalculatePartitionController;
import pt.ipp.isep.dei.esoft.project.application.controller.ImportLegacySystemFileController;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.SubsetPartition;


public class CalculatePartionUI implements  Initializable{

    private MainUI mainUI;
    @FXML
    private Button button;

    @FXML
    private Button back;
    @FXML
    private TextArea infoToDisplay;
    @FXML
    private TextField nNumber;
    private CalculatePartitionController controller;

    private ImportLegacySystemFileController importer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new CalculatePartitionController();
        importer = new ImportLegacySystemFileController();


    }
    public void performCalculation(ActionEvent event){
        try{
            if(Repositories.getInstance().getStoreRepository().getStores().size() < 450) {
                importer.getData("src/main/java/pt.ipp.isep.dei.esoft.project/ui/legacyRealStateUSAMoodle_MATCP_MDISC.csv");
            }
            if(nNumber.getText().isEmpty()){
                SubsetPartition subsetPartition = controller.calculateAll();
                StringBuilder builder = new StringBuilder();
                builder.append("SumSubset1 : ").append(subsetPartition.getSumSubset1()).append("\n").append("SumSubset2 : ").append(subsetPartition.getSumSubset2()).append("\n").append("SumSubsetDifference:").append(subsetPartition.getDifference())
                        .append("\n").append("Minimum Partitions : ");
                for(int i = 0 ; i < subsetPartition.getMinPartition().size();i++){
                    builder.append(subsetPartition.getMinPartition().get(i)).append("\n");
                }
                builder.append("\n");
                infoToDisplay.setText(builder.toString());
            }else {
                int n = Integer.parseInt(nNumber.getText());
                SubsetPartition subsetPartition = controller.calculateWithNstores(n);
                StringBuilder builder = new StringBuilder();
                builder.append("SumSubset1 : ").append(subsetPartition.getSumSubset1()).append("\n").append("SumSubset2 : ").append(subsetPartition.getSumSubset2()).append("\n").append("SumSubsetDifference:").append(subsetPartition.getDifference())
                        .append("\n").append("Minimum Partitions : ");
                for(int i = 0 ; i < subsetPartition.getMinPartition().size();i++){
                    builder.append(subsetPartition.getMinPartition().get(i)).append("\n");
                }
                builder.append("\n");
                infoToDisplay.setText(builder.toString());
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING,"Please select input a number",ButtonType.CLOSE);
            alert.showAndWait();
        }


    }
    public void backToMainMenu(ActionEvent event){
        this.mainUI.toMainUI();
    }

    public void setMainUI(MainUI mainUI) {
        this.mainUI = mainUI;
    }
}
