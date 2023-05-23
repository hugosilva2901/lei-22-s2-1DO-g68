package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.CreatePropertyController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.isep.lei.esoft.auth.UserSession;

public class ListAnnouncementRequestUI implements Runnable{
    CreateAnnouncementController createAnnouncementController = new CreateAnnouncementController();
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();

    @Override
    public void run() {
        System.out.printf("%s", authenticationRepository.getCurrentUserSession().getUserName());
    }
}
