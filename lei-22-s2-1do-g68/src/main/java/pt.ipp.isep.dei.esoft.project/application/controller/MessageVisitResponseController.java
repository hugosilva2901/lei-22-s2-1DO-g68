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

    AuthenticationRepository authenticationRepository = null;

    MessagesOfClientRepository messagesOfClientRepository = null;





    public MessageVisitResponseController() {
        getAuthenticationRepository();
        getMessagesOfClientRepository();

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


    public List<MessageVisit> getMessagesOfVisit() {
        String email = authenticationRepository.getCurrentUserSession().getUserId().getEmail();
        return messagesOfClientRepository.MessageOfVisitByEmail(email);
    }
    public void AcceptVisitRequest(MessageVisit messageVisit, StatusOfMessage status) {
        if (status.equals(StatusOfMessage.ACCEPTED)) {
            messageVisit.putStatusOfMessage(StatusOfMessage.ACCEPTED, "");
        }
    }


    public void RejectVisitRequest(MessageVisit messageVisit, StatusOfMessage status, String reson) {
        if (status.equals(StatusOfMessage.REJECTED)) {
            messageVisit.putStatusOfMessage(StatusOfMessage.REJECTED, reson);
        }
    }



}
