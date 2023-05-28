package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.CreateOrderUI;
import pt.ipp.isep.dei.esoft.project.ui.console.CreatePropertyUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ShowTextUI;
import pt.ipp.isep.dei.esoft.project.ui.console.VisitRequestUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ClienteUI implements Runnable {
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register new property", new CreatePropertyUI()));
        options.add(new MenuItem("Place a Order", new CreateOrderUI()));
        options.add(new MenuItem("Visit Requests", new VisitRequestUI()));
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
