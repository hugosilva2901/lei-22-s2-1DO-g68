package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

public class Apartment extends Property {
    private int numberOfRooms;
    private int numberOfBathrooms;
    private int numberOfFloors;
    private int numberOfGarages;
    private List<String> equipments;

    public Apartment(String name, String type, String address, String description, boolean isForSale, boolean isForRent, int numberOfRooms, int numberOfBathrooms, int numberOfFloors, int numberOfGarages, List<String> equipments) {
        super(name, type, address, description, isForSale, isForRent);
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfFloors = numberOfFloors;
        this.numberOfGarages = numberOfGarages;
        this.equipments = equipments;
    }

    // getters and setters for all fields
    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }
    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }
    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    public int getNumberOfGarages() {
        return numberOfGarages;
    }
    public void setNumberOfGarages(int numberOfGarages) {
        this.numberOfGarages = numberOfGarages;
    }
    public List<String> getEquipments() {
        return equipments;
    }
    public void setEquipments(List<String> equipments) {
        this.equipments = equipments;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "numberOfRooms=" + numberOfRooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", numberOfFloors=" + numberOfFloors +
                ", numberOfGarages=" + numberOfGarages +
                ", equipments=" + equipments +
                '}';
    }
}

