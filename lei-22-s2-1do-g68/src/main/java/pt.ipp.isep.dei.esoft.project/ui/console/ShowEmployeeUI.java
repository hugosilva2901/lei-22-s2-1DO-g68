package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ShowEmployeeController;

import java.util.Scanner;

public class ShowEmployeeUI implements Runnable{

    private final ShowEmployeeController controller = new ShowEmployeeController();


    public void run() {
        System.out.println("--- List of Stores ---");
        controller.showStoresandEmployes();

    }



}
