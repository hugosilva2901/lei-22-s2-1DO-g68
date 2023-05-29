package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.domain.mapper.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.mapper.ClientMapper;
import pt.ipp.isep.dei.esoft.project.domain.mapper.VisitRequestMapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class VisitRepository {

    public static ArrayList<VisitRequest> visitList = new ArrayList<VisitRequest>();

    public static void addVisit(Announcement announcement, SimpleDateFormat date, String message, Client client){
        visitList.add(new VisitRequest(announcement, date, message, client));
    }

    public static ArrayList<VisitRequest> getVisitList(){
        return visitList;
    }

    public Optional<VisitRequest> createVisitRequest(AnnouncementDTO announcement, SimpleDateFormat date, String message, ClientDTO client){
        Client client1= ClientMapper.toEntity(client);
        Announcement  announcement1= AnnouncementMapper.toEntity(announcement);
        addVisit(announcement1, date, message, client1);

        return Optional.of(new VisitRequest(announcement1, date, message, client1));
    }

    public List<VisitRequestDTO> getAllVisitRequestsDTO() {
        List<VisitRequestDTO> visitRequestDTOList = new ArrayList<>();
        for (VisitRequest visitRequest : visitList) {
            visitRequestDTOList.add(VisitRequestMapper.toDTO(visitRequest));
        }
        return visitRequestDTOList;
    }

    public List<VisitRequestDTO> getVisitRequests(EmployeeProjectDTO employeeProject) {
        List<VisitRequestDTO> visitRequestDTOList = new ArrayList<>();
        for (VisitRequest visitRequest : visitList) {
            if (visitRequest.getAnnouncement().getEmployeeProject().getTaxNumber()==employeeProject.getTaxNumber()) {
                visitRequestDTOList.add(VisitRequestMapper.toDTO(visitRequest));
            }
        }
        return getAllVisitRequestsDTO();
    }

}
