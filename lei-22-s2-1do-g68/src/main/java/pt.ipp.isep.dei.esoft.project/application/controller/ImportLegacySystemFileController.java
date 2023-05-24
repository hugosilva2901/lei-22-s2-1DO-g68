package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.CSVLoader;

public class ImportLegacySystemFileController {

    public ImportLegacySystemFileController(){
    }

    public void getData(String data) throws Exception {
        CSVLoader csvLoader = new CSVLoader(data);
        csvLoader.getData();
    }
}
