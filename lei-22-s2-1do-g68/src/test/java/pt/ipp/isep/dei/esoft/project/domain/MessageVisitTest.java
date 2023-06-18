package  pt.ipp.isep.dei.esoft.project.domain;

import org.testng.annotations.Test;
import pt.ipp.isep.dei.esoft.project.application.controller.MessageVisitResponseController;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.MessageVisit;
import pt.ipp.isep.dei.esoft.project.domain.StatusOfMessage;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;

public class MessageVisitTest {
    Bootstrap boot = new Bootstrap();


    @Test
    void test1(){
        boot.run();
        AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
        AnnouncementDTO announcementDTO = announcementRepository.getAnnouncementsDTO().get(0);
        EmployeeProject employeeProjectDTO = Repositories.getInstance().getStoreRepository().listEmployees().get(0);
        MessageVisit messageVisit = new MessageVisit("teste message",employeeProjectDTO.getName(),employeeProjectDTO.getPhone(),announcementDTO.getProperty().toString());
        MessageVisitResponseController messageVisitResponseController = new MessageVisitResponseController(messageVisit);
        messageVisitResponseController.AcceptVisitRequest(messageVisit, StatusOfMessage.ACCEPTED);
    }

    @Test
    void test2() {
        AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
        AnnouncementDTO announcementDTO = announcementRepository.getAnnouncementsDTO().get(0);
        EmployeeProject employeeProjectDTO = Repositories.getInstance().getStoreRepository().listEmployees().get(1);
        MessageVisit messageVisit = new MessageVisit("teste message",employeeProjectDTO.getName(),employeeProjectDTO.getPhone(),announcementDTO.getProperty().toString());
        MessageVisitResponseController messageVisitResponseController = new MessageVisitResponseController(messageVisit);
        messageVisitResponseController.RejectVisitRequest(messageVisit, StatusOfMessage.REJECTED, "The property is not available at the moment");
    }





}
