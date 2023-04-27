package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatEmployeeController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.CreatGuestController;

public class CreatGuestUI implements Runnable {

    private final CreatGuestController controller = new CreatGuestController();

    public void run(){
        showProperties();
    }

    private void showProperties() {
        System.out.println("Properties:");
        controller.getProperties();
    }
}
