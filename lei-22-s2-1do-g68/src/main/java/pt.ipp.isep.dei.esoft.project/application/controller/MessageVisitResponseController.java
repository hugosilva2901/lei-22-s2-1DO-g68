package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.MessageVisit;
import pt.ipp.isep.dei.esoft.project.domain.StatusOfMessage;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.domain.mapper.ClientMapper;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

public class MessageVisitResponseController {

    AuthenticationRepository authenticationRepository = null;

    MessagesOfClientRepository messagesOfClientRepository = null;

    MessageVisit messageVisit = null;

    StoreRepository storeRepository = null;



    public MessageVisitResponseController() {
        getAuthenticationRepository();
        getMessagesOfClientRepository();
        getStoreRepository();
    }

    //test only
    protected MessageVisitResponseController(MessageVisit messageVisit){
        this.messageVisit = messageVisit;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }
    private MessagesOfClientRepository getMessagesOfClientRepository() {
        if (messagesOfClientRepository == null) {
            Repositories repositories = Repositories.getInstance();
            messagesOfClientRepository = repositories.getMessagesOfClientRepository();
        }
        return messagesOfClientRepository;
    }

    private StoreRepository getStoreRepository() {
        if (storeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            storeRepository = repositories.getStoreRepository();
        }
        return storeRepository;
    }


    public List<MessageVisit> getMessagesOfVisit() {
        String email = authenticationRepository.getCurrentUserSession().getUserId().getEmail();
        return messagesOfClientRepository.MessageOfVisitByEmail(email);
    }
    private String getEmailOfEmployee(String name) {
      EmployeeProjectDTO em= storeRepository.getEmployeeByName(name);
        return em.getEmail();
    }
    public void AcceptVisitRequest(MessageVisit messageVisit, StatusOfMessage status) {
        if (status.equals(StatusOfMessage.ACCEPTED)) {
            messageVisit.putStatusOfMessage(StatusOfMessage.ACCEPTED, "");
            messagesOfClientRepository.addMessageOfEmployee(getEmailOfEmployee(messageVisit.getNameEmployee()),messageVisit);
        }
    }

    public void RejectVisitRequest(MessageVisit messageVisit, StatusOfMessage status, String reson) {
        if (status.equals(StatusOfMessage.REJECTED)) {
            messageVisit.putStatusOfMessage(StatusOfMessage.REJECTED, reson);
            messagesOfClientRepository.addMessageOfEmployee(getEmailOfEmployee(messageVisit.getNameEmployee()),messageVisit);
        }
    }



}
