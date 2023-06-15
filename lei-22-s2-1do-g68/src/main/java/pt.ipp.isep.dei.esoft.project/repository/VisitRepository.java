package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.domain.mapper.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.mapper.ClientMapper;
import pt.ipp.isep.dei.esoft.project.domain.mapper.VisitRequestMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class VisitRepository {

    public static ArrayList<VisitRequest> visitList = new ArrayList<VisitRequest>();

    public static void addVisit(AnnouncementDTO announcement, Date date, String message, Client client){
        visitList.add(new VisitRequest(announcement, date, message, client));
    }

    public static ArrayList<VisitRequest> getVisitList(){
        return visitList;
    }

    public Optional<VisitRequest> createVisitRequest(AnnouncementDTO announcement, Date date, String message, ClientDTO client){
        Client client1= ClientMapper.toEntity(client);
        addVisit(announcement, date, message, client1);

        return Optional.of(new VisitRequest(announcement, date, message, client1));
    }

    public void removeVisit(VisitRequestDTO visit){
        VisitRequest vi =VisitRequestMapper.toDomain(visit);
        visitList.remove(vi);
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
        visitRequestDTOList.sort((o1, o2) -> {
            Date date1 = o1.getDate();
            Date date2 = o2.getDate();
            return date1.compareTo(date2);
        });

        return visitRequestDTOList;
    }

    public VisitRequest getVisitRequestById(String id) {
    }
}
