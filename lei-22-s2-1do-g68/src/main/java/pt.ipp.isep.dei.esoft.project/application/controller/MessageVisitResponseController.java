package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.MessageVisit;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

public class MessageVisitResponseController {

    AnnouncementRepository  announcementRepository = null;
    VisitRepository visitRepository = null;
    AuthenticationRepository authenticationRepository = null;
    StoreRepository storeRepository = null;





    public MessageVisitResponseController() {
        getAnnouncementRepository();
        getVisitRepository();
        getAuthenticationRepository();
        getStoreRepository();
    }

    private StoreRepository getStoreRepository() {
        if (storeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            storeRepository = repositories.getStoreRepository();
        }
        return storeRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }
    private VisitRepository getVisitRepository() {
        if (visitRepository == null) {
            Repositories repositories = Repositories.getInstance();
            visitRepository = repositories.getVisitRepository();
        }
        return visitRepository;
    }

    private AnnouncementRepository getAnnouncementRepository() {
        if (announcementRepository == null) {
            Repositories repositories = Repositories.getInstance();
            announcementRepository = repositories.getAnnouncementRepository();
        }
        return announcementRepository;
    }

    public List<AnnouncementDTO> getAnnouncement() {
        return this.getAnnouncementRepository().getAnnouncementsByEmployee(storeRepository.getEmployeeByEmail(authenticationRepository.getEmail()));
    }

    public VisitRequest getVisitRequest(String id) {
        return this.getVisitRepository().getVisitRequestById(id);
    }

    public void acceptorRejectVisitRequest(String id, String status, String reson) {
        VisitRequest visitRequest = this.getVisitRequest(id);
        if (status.equals("ACCEPTED")) {
            MessageVisit.putStatusOfMessage(MessageVisit.statusOfMessage.ACCEPTED);
        } else if (status.equals("REJECTED")) {
            MessageVisit.putStatusOfMessage(MessageVisit.statusOfMessage.REJECTED, reson);
        }
    }




}
