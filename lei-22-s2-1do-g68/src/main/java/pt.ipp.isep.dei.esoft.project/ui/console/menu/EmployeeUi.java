package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUi implements Runnable {
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create Announcement", new CreateAnnouncementUI()));
        options.add(new MenuItem("Accept/Reject Order ", new AcceptOrderUI()));
        options.add(new MenuItem("List Announcement My Announcement Requests", new ListAnnouncementRequestUI()));
        options.add(new MenuItem("List visits requests  ", new ListVisitRequestUI()));
        options.add(new MenuItem("Respond To request", new MessageVisitRequestUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nEmployee Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
    }

