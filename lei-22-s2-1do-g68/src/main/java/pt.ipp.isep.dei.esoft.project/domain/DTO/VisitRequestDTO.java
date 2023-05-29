package pt.ipp.isep.dei.esoft.project.domain.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitRequestDTO {
    private AnnouncementDTO announcement;
    private Date date;
    private String message;
    private ClientDTO client;

    public VisitRequestDTO(AnnouncementDTO announcement, Date date, String message, ClientDTO client){
        this.announcement = announcement;
        this.date = date;
        this.message = message;
        this.client = client;
    }

    public AnnouncementDTO getAnnouncement() {return announcement;}
    public void setAnnouncement(AnnouncementDTO announcement) {this.announcement = announcement;}
    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public ClientDTO getClient() {return client;}
    public void setClient(ClientDTO client) {this.client = client;}

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