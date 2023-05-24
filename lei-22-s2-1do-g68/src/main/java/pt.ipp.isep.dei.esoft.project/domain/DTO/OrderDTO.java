package pt.ipp.isep.dei.esoft.project.domain.DTO;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.StatusOfOrder;
public class OrderDTO {
    private AnnouncementDTO announcement;
    private int value;
    private ClientDTO client;
    private StatusOfOrder statusOfOrder;

    public OrderDTO(AnnouncementDTO announcement, int value, ClientDTO client, StatusOfOrder statusOfOrder) {
        this.announcement = announcement;
        this.value = value;
        this.client = client;
        this.statusOfOrder = statusOfOrder;
    }

    public AnnouncementDTO getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(AnnouncementDTO announcement) {
        this.announcement = announcement;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public StatusOfOrder getStatusOfOrder() {
        return statusOfOrder;
    }

    public void setStatusOfOrder(StatusOfOrder statusOfOrder) {
        this.statusOfOrder = statusOfOrder;
    }
}