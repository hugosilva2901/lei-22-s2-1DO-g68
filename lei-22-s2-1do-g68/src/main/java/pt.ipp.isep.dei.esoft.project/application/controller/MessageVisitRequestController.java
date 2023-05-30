package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

public class MessageVisitRequestController {

    MessagesOfClientRepository messagesOfClientRepository = null;

    StoreRepository storeRepository = null;

    AuthenticationRepository authenticationRepository = null;

    VisitRepository visitRepository = null;

    public MessageVisitRequestController() {
        getMessagesOfClientRepository();
        getStoreRepository();
        getAuthenticationRepository();
        getVisitRepository();
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
    private EmployeeProjectDTO getEmployeeProject(String email) {
        return this.storeRepository.getEmployeeByEmail(email);
    }
    public List<VisitRequestDTO> getAllVisitRequests() {
        EmployeeProjectDTO employeeProjectDTO = getEmployeeProject(authenticationRepository.getCurrentUserSession().getUserId().getEmail());
        return this.visitRepository.getVisitRequests(employeeProjectDTO);
    }

    public String ResponseOfRequest( String message,VisitRequestDTO visitRequestDTO) {
        EmployeeProjectDTO employeeProjectDTO = getEmployeeProject(authenticationRepository.getCurrentUserSession().getUserId().getEmail());
        String MessageFinal= ""+message+"\n"+employeeProjectDTO.getName()+" "+ employeeProjectDTO.getPhone()+"\n"+visitRequestDTO.getAnnouncement().getProperty().toString();
        this.messagesOfClientRepository.addMessageOfVisit(visitRequestDTO.getClient().getEmail(),MessageFinal);
        return MessageFinal;
    }

}
