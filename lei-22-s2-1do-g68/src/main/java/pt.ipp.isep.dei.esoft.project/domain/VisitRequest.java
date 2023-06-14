package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitRequest {
    private AnnouncementDTO announcement;
    private Date date;
    private String message;
    private Client client;

    public AnnouncementDTO getAnnouncement() {return announcement;}
    public Date getDate() {return date;}
    public String getMessage() {return message;}
    public Client getClient() {return client;}

    public VisitRequest(AnnouncementDTO announcement, Date date, String message, Client client){
        this.announcement = announcement;
        this.date = date;
        this.message = message;
        this.client = client;
    }

    @Override
    public String toString() {

        return "VisitRequest { \n" + announcement +
                ",\n\n date: day: " + date.getDay() + " month: " + date.getMonth() + " year: " + date.getYear() +
                ",\n message: {" + message  + "}" +
                ",\n Client Name: " + client.getName() +
                ",\n Client Phone Number: " + client.getPhone() +
                "\n}\n";
    }
}
