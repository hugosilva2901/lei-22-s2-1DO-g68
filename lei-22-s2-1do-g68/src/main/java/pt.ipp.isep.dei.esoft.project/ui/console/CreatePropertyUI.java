package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.createPropertyController;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CreatePropertyUI implements Runnable {
    private final createPropertyController controller = new createPropertyController();
    private String name;
    private String type;
    private String address;
    private String description;
    private boolean isForSale;
    private boolean isForRent;
    private double area;

    private int numberOfRooms;
    private int numberOfBathrooms;
    private int numberOfFloors;
    private int numberOfGarages;
    private List<String> equipments;
    private boolean hasBasement;
    private boolean hasLoft;
    private boolean hasSunExposure;
    private EmployeeProject propertyProject;

    private createPropertyController getController() {
        return controller;
    }


    public void run() {
        System.out.println("Create Property\n");

        propertyProject = displayAndSelectProperties();

        System.out.println("Choose a type of property");
        System.out.println("1 - House");
        System.out.println("2 - Apartment");
        System.out.println("3 - Land");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();
        if (answer == 1) {
            requestDataHouse();
            submitDataHouse();
        } else if (answer == 2) {
            requestDataApartament();
            submitDataApartament();
        } else if (answer == 3) {
            requestDataLand();
            submitDataLand();
        } else {
            System.out.println("Invalid input");
        }



    }

    private EmployeeProject displayAndSelectProperties() {
        //Display the list of task categories

        List<EmployeeProject> Stores = controller.getStoreRepository().listEmployees();

        int listSize = Stores.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayPropertyOptions(Stores);
            System.out.println("Select a agent:");
            answer = input.nextInt();
        }

        EmployeeProject description = Stores.get(answer - 1);
        return description;

    }
    private void displayPropertyOptions(List<EmployeeProject> Stores) {
        //display the task categories as a menu with number options to select
        int i = 1;
        for (EmployeeProject Store : Stores) {
            System.out.println(i + " - " + Stores.toString());
            i++;
        }
    }

    private void submitDataHouse() {
        // Alterar property para conseguir ter um cliente associado
        Optional<House> task = getController().createHouse(name, type, address, description, isForSale, isForRent, numberOfRooms, numberOfBathrooms, numberOfFloors, numberOfGarages, equipments, hasBasement, hasLoft, hasSunExposure);
        if (task.isPresent()) {
            System.out.println("House Property successfully created!");
        } else {
            System.out.println("House Property not created!");
        }
    }

    private void submitDataApartament() {
        // Alterar property para conseguir ter um cliente associado
        Optional<Apartment> task = getController().createApartament(name, type, address, description, isForSale, isForRent, numberOfRooms, numberOfBathrooms, numberOfFloors, numberOfGarages, equipments, hasBasement, hasLoft, hasSunExposure);
        if (task.isPresent()) {
            System.out.println("Apartament Property successfully created!");
        } else {
            System.out.println("Apartament Property not created!");
        }
    }

    private void submitDataLand() {
        // Alterar property para conseguir ter um cliente associado
        Optional<Land> task = getController().createLand(name, type, address, description, isForSale, isForRent, area);
        if (task.isPresent()) {
            System.out.println("Land Property successfully created!");
        } else {
            System.out.println("Land Property not created!");
        }
    }

    private void requestDataHouse() {
        this.name = requestName();
        this.address = requestAddress();
        this.description = requestDescription();
        this.isForSale = requestIsForSale();
        this.isForRent = requestIsForRent();
        this.numberOfRooms = requestNumberOfRooms();
        this.numberOfBathrooms = requestNumberOfBathrooms();
        this.numberOfFloors = requestNumberOfFloors();
        this.numberOfGarages = requestNumberOfGarages();
        this.equipments = requestEquipments();
        this.hasBasement = requestHasBasement();
        this.hasLoft = requestHasLoft();
        this.hasSunExposure = requestHasSunExposure();

    }

    private void requestDataApartament(){
        this.name = requestName();
        this.address = requestAddress();
        this.description = requestDescription();
        this.isForSale = requestIsForSale();
        this.isForRent = requestIsForRent();
        this.numberOfRooms = requestNumberOfRooms();
        this.numberOfBathrooms = requestNumberOfBathrooms();
        this.numberOfFloors = requestNumberOfFloors();
        this.numberOfGarages = requestNumberOfGarages();
        this.equipments = requestEquipments();
    }

    private void requestDataLand(){
        this.name = requestName();
        this.address = requestAddress();
        this.description = requestDescription();
        this.isForSale = requestIsForSale();
        this.isForRent = requestIsForRent();
        this.area = requestArea();
    }

    private String requestName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Name:");
        return input.nextLine();
    }

    private String requestAddress() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Address:");
        return input.nextLine();
    }

    private String requestDescription() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Description:");
        return input.nextLine();
    }

    private boolean requestIsForSale() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Is For Sale:");
        return input.nextBoolean();
    }

    private boolean requestIsForRent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Is For Rent:");
        return input.nextBoolean();
    }

    private int requestNumberOfRooms() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Number Of Rooms:");
        return input.nextInt();
    }

    private int requestNumberOfBathrooms() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Number Of Bathrooms:");
        return input.nextInt();
    }

    private int requestNumberOfFloors() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Number Of Floors:");
        return input.nextInt();
    }

    private int requestNumberOfGarages() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Number Of Garages:");
        return input.nextInt();
    }

    private List<String> requestEquipments() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Equipments:");
        return Collections.singletonList(input.nextLine());
    }

    private boolean requestHasBasement() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Has Basement:");
        return input.nextBoolean();
    }

    private boolean requestHasLoft() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Has Loft:");
        return input.nextBoolean();
    }

    private boolean requestHasSunExposure() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Has Sun Exposure:");
        return input.nextBoolean();
    }

    private int requestArea() {
        Scanner input = new Scanner(System.in);
        System.out.println("Property Area:");
        return input.nextInt();

    }

}