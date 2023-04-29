package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatClienteController;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.Optional;
import java.util.Scanner;

public class CreatCLientUI implements Runnable{
    private final CreatClienteController controller = new CreatClienteController();

    private String name;
    private String descptions;
    private int taxNumber;
    private String email;
    private String password;
    private String address;
    private String phone;

    private CreatClienteController getController() {
        return controller;
    }

    public void run() {
        System.out.println("Create Employee\n");

        requestData();

        submitData();
    }



    private void submitData() {
        Optional<Client> task = getController().createClient(name, descptions, taxNumber, email, password, address, phone, Roles.CLIENT);

        if (task.isPresent()) {
            System.out.println("Client successfully created!");
        } else {
            System.out.println("Client not created!");
        }
    }

    private void requestData() {
        name = requestName();
        descptions = requestDescptions();
        taxNumber = requestTaxNumber();
        email = requestEmail();
        password = requestPassword();
        address = requestAddress();
        phone = requestPhone();

    }
    private String requestName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Client Name:");
        return input.nextLine();
    }
    private String requestDescptions() {
        Scanner input = new Scanner(System.in);
        System.out.println("Client Descptions:");
        return input.nextLine();
    }

    private int requestTaxNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Client Tax Number:");
        return input.nextInt();
    }
    private String requestEmail() {
        Scanner input = new Scanner(System.in);
        System.out.println("Client Email:");
        return input.nextLine();
    }
    private String requestPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Client Password:");
        return input.nextLine();
    }
    private String requestAddress() {
        Scanner input = new Scanner(System.in);
        System.out.println("Client Address:");
        return input.nextLine();
    }
    private String requestPhone() {
        Scanner input = new Scanner(System.in);
        System.out.println("Client Phone:");
        return input.nextLine();
    }


}
