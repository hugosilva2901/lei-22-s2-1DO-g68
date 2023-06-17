package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.domain.MessageVisit;
import pt.ipp.isep.dei.esoft.project.domain.StatusOfMessage;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.domain.mapper.ClientMapper;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

public class MessageVisitResponseController {

    AnnouncementRepository  announcementRepository = null;
    VisitRepository visitRepository = null;
    AuthenticationRepository authenticationRepository = null;
    StoreRepository storeRepository = null;

    MessagesOfClientRepository messagesOfClientRepository = null;

    ClientRepository clientRepository = null;




    public MessageVisitResponseController() {
        getAnnouncementRepository();
        getVisitRepository();
        getAuthenticationRepository();
        getStoreRepository();
        getMessagesOfClientRepository();
        getClientRepository();
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

    private MessagesOfClientRepository getMessagesOfClientRepository() {
        if (messagesOfClientRepository == null) {
            Repositories repositories = Repositories.getInstance();
            messagesOfClientRepository = repositories.getMessagesOfClientRepository();
        }
        return messagesOfClientRepository;
    }

    private ClientRepository getClientRepository() {
        if (clientRepository == null) {
            Repositories repositories = Repositories.getInstance();
            clientRepository = repositories.getClientRepository();
        }
        return clientRepository;
    }

    private AnnouncementRepository getAnnouncementRepository() {
        if (announcementRepository == null) {
            Repositories repositories = Repositories.getInstance();
            announcementRepository = repositories.getAnnouncementRepository();
        }
        return announcementRepository;
    }
/*
    public List<AnnouncementDTO> getAnnouncement() {
        return this.getAnnouncementRepository().getAnnouncementsByEmployee(storeRepository.getEmployeeByEmail(authenticationRepository.getEmail()));
    }

 */
/*
    public VisitRequest getVisitRequest(String id) {
        return this.getVisitRepository().getVisitRequestById(id);
    }



    public void acceptorRejectVisitRequest(String email, String status, String reson) {
     MessageVisit messageVisit=  messagesOfClientRepository.getMessage(email);
        if (status.equals("ACCEPTED")) {
            messageVisit.putStatusOfMessage(StatusOfMessage.ACCEPTED);
        } else if (status.equals("REJECTED")) {
            messageVisit.putStatusOfMessage(StatusOfMessage.REJECTED, reson);
        }
    }


 */

}
