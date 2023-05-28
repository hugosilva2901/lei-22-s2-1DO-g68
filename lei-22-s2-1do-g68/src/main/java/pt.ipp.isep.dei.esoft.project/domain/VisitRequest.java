package pt.ipp.isep.dei.esoft.project.domain;

public class VisitRequest {
    private Announcement announcement;
    private String date;
    private String message;
    private Client client;

    public Announcement getAnnouncement() {return announcement;}
    public String getDate() {return date;}
    public String getMessage() {return message;}
    public Client getClient() {return client;}

    public VisitRequest(Announcement announcement, String date, String message, Client client){
        this.announcement = announcement;
        this.date = date;
        this.message = message;
        this.client = client;
    }

    @Override
    public String toString() {

        return "VisitRequest { \n" + announcement +
                ",\n\n date: " + date  +
                ",\n message: {" + message  + "}" +
                ",\n Client Name: " + client.getName() +
                ",\n Client Phone Number: " + client.getPhone() +
                "\n}\n";
    }
}
