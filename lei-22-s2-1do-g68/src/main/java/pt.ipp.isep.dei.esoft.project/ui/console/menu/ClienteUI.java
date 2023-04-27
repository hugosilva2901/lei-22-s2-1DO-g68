package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.CreatEmployeeUi;
import pt.ipp.isep.dei.esoft.project.ui.console.CreateAnnouncementUI;
import pt.ipp.isep.dei.esoft.project.ui.console.CreateTaskUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ShowTextUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ClienteUI implements Runnable {
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("buy", new ShowTextUI("Not implemented yet.")));
        options.add(new MenuItem("Sell ", new ShowTextUI("You have chosen Option A.")));
        options.add(new MenuItem("Option 2 ", new ShowTextUI("You have chosen Option B.")));
        options.add(new MenuItem("Option 3 ", new ShowTextUI("You have chosen Option C.")));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nEmployee Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}