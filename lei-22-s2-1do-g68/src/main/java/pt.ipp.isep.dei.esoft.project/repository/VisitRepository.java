package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import java.util.ArrayList;

public class VisitRepository {

    public static ArrayList<VisitRequest> visitList = new ArrayList<VisitRequest>();

    public static void addVisit(Announcement announcement, String date, String message, Client client){
        visitList.add(new VisitRequest(announcement, date, message, client));
    }

    public static ArrayList<VisitRequest> getVisitList(){
        return visitList;
    }

}
