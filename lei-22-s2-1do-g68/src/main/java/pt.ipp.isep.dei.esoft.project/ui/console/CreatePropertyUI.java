package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatEmployeeController;
import pt.ipp.isep.dei.esoft.project.application.controller.createPropertyController;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.House;
import pt.ipp.isep.dei.esoft.project.domain.Roles;
import pt.ipp.isep.dei.esoft.project.domain.Store;

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

    private int numberOfRooms;
    private int numberOfBathrooms;
    private int numberOfFloors;
    private int numberOfGarages;
    private List<String> equipments;
    private boolean hasBasement;
    private boolean hasLoft;
    private boolean hasSunExposure;
    private EmployeeProject employeeProject;

    private createPropertyController getController() {
        return controller;
    }


    public void run() {
        System.out.println("Create Property\n");

         employeeProject = displayAndSelectStores();

        System.out.println("choose a type of property");
        System.out.println("1 - House");
        System.out.println("2 - Land");
        System.out.println("3 - Apartment");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();
        if (answer == 1) {
            requestDataHouse();
            submitDataHouse();
        } else if (answer == 2) {

        } else if (answer == 3) {

        } else {
            System.out.println("invalid input");
        }



    }

    private EmployeeProject displayAndSelectStores() {
        //Display the list of task categories

        List<EmployeeProject> Stores = controller.getStoreRepository().listEmployees();

        int listSize = Stores.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayStoresOptions(Stores);
            System.out.println("Select a store:");
            answer = input.nextInt();
        }

        EmployeeProject description = Stores.get(answer - 1);
        return description;

    }
    private void displayStoresOptions(List<EmployeeProject> Stores) {
        //display the task categories as a menu with number options to select
        int i = 1;
        for (EmployeeProject Store : Stores) {
            System.out.println(i + " - " + Stores.toString());
            i++;
        }
    }

    private void submitDataHouse() {
        // Alterar property para conseguir ter um cliente associado
        Optional<House> task = getController().createHouse(name, "house", address, description, isForSale, isForRent, numberOfRooms, numberOfBathrooms, numberOfFloors, numberOfGarages, equipments, hasBasement, hasLoft, hasSunExposure);
        if (task.isPresent()) {
            System.out.println("Employee successfully created!");
        } else {
            System.out.println("Employee not created!");
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
    private String requestName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Name:");
        return input.nextLine();
    }

    private String requestAddress() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Address:");
        return input.nextLine();
    }

    private String requestDescription() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Description:");
        return input.nextLine();
    }

    private boolean requestIsForSale() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Is For Sale:");
        return input.nextBoolean();
    }

    private boolean requestIsForRent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Is For Rent:");
        return input.nextBoolean();
    }

    private int requestNumberOfRooms() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Number Of Rooms:");
        return input.nextInt();
    }

    private int requestNumberOfBathrooms() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Number Of Bathrooms:");
        return input.nextInt();
    }

    private int requestNumberOfFloors() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Number Of Floors:");
        return input.nextInt();
    }

    private int requestNumberOfGarages() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Number Of Garages:");
        return input.nextInt();
    }

    private List<String> requestEquipments() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Equipments:");
        return Collections.singletonList(input.nextLine());
    }

    private boolean requestHasBasement() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Has Basement:");
        return input.nextBoolean();
    }

    private boolean requestHasLoft() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Has Loft:");
        return input.nextBoolean();
    }

    private boolean requestHasSunExposure() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Has Sun Exposure:");
        return input.nextBoolean();
    }






}
