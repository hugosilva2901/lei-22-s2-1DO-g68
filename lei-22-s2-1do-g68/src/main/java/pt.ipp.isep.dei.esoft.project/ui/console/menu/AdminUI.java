package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio pam@isep.ipp.pt
 */

public class AdminUI implements Runnable {
    public AdminUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create Employee", new CreatEmployeeUi()));
        options.add(new MenuItem("Create Store ", new CreateStoreUI()));
        options.add(new MenuItem("Import Legacy System Data ", new ImportLegacySystemDataUI()));
        options.add(new MenuItem("List Deals", new ListDealUI()));
        options.add(new MenuItem("Show Employee", new ShowEmployeeUI()));
        options.add(new MenuItem("Perform Subset Analysis", new CalculatePartionUI()));

        int option = 0;

        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
