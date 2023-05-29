package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class VisitRequestController {

    private VisitRepository visitRepository = null;
    private AnnouncementRepository announcementRepository = null;
    private ClientRepository clientRepository = null;

    private AuthenticationRepository authenticationRepository = null;

    public VisitRequestController() {
        getVisitRepository();
        getAnnouncementRepository();
        getClientRepository();
        getAuthenticationRepository();
    }

    public VisitRepository getVisitRepository(){
        if (visitRepository == null) {
            Repositories repositories = Repositories.getInstance();
            visitRepository = repositories.getVisitRepository();
        }
        return visitRepository;
    }

    public AnnouncementRepository getAnnouncementRepository(){
        if (announcementRepository == null) {
            Repositories repositories = Repositories.getInstance();
            announcementRepository = repositories.getAnnouncementRepository();
        }
        return announcementRepository;
    }

    public ClientRepository getClientRepository(){
        if (clientRepository == null) {
            Repositories repositories = Repositories.getInstance();
            clientRepository = repositories.getClientRepository();
        }
        return clientRepository;
    }

    public AuthenticationRepository getAuthenticationRepository(){
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public ArrayList<Announcement> getAnnouncementList(){
        return this.announcementRepository.getAnnouncementList();
    }

    private ClientDTO getClientByUserEmail(String userName){
        return clientRepository.getClientByEmail(userName);
    }


    public boolean registerVisitRequest(SimpleDateFormat date, String message, AnnouncementDTO announcement, Client client) {
        ClientDTO client1 = getClientByUserEmail(authenticationRepository.getCurrentUserSession().getUserId().getEmail());
        return this.visitRepository.createVisitRequest(announcement, date, message, client1).isPresent();
    }
    public boolean registerVisitRequestBootstrap(SimpleDateFormat date, String message, AnnouncementDTO announcement, ClientDTO client) {
        return this.visitRepository.createVisitRequest(announcement, date, message, client).isPresent();
    }
}

