package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainUI extends Application {
    private Stage stage;

    private final double MINIMUM_WINDOW_WIDTH = 400.0;
    private final double MINIMUM_WINDOW_HEIGHT = 300.0;
    private final double SCENE_WIDTH = 450.0;
    private final double SCENE_HEIGHT = 350.0;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);

        toCalculatePartionUI();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void toCalculatePartionUI()  {
        try{
            CalculatePartionUI calculatePartionUI =  (CalculatePartionUI) replaceSceneContent("/fxml/CalculatePartionUI.fxml");
            calculatePartionUI.setMainUI(this);
            this.stage.setResizable(false);
        }catch (Exception e){
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE,null,e);
        }

    }


    public Initializable replaceSceneContent(String fxml) throws Exception{

        FXMLLoader loader = new FXMLLoader(MainUI.class.getResource(fxml));

        Parent rootNode = loader.load();
        Scene scene = new Scene(rootNode);
        this.stage.setScene(scene);
        this.stage.sizeToScene();
        return (Initializable)loader.getController();
    }


}
