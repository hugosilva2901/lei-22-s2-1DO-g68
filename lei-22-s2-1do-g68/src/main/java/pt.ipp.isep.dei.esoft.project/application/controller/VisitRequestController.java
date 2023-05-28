package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.ClientRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VisitRepository;
import java.util.ArrayList;
import java.util.Optional;

public class VisitRequestController {

    private VisitRepository visitRepository = null;
    private AnnouncementRepository announcementRepository = null;
    private ClientRepository clientRepository = null;

    public VisitRequestController() {
        getVisitRepository();
        getAnnouncementRepository();
        getClientRepository();
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

    public ArrayList<Announcement> getAnnouncementList(){
        return this.announcementRepository.getAnnouncementList();
    }



    public boolean registerVisitRequest(String date, String message, AnnouncementDTO announcement, Client client) {
        return this.visitRepository.createVisitRequest(announcement, date, message, client).isPresent();
    }
}

