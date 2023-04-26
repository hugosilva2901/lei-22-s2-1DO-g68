package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateStoreController;

import java.util.Scanner;

public class CreateStoreUI {
    private static CreateStoreController controller = new CreateStoreController();
    //  private String name;
    //    private String phone;
    //    private String email;
    //    private String vatNumber;
    //    private String address;
    //    private int branchNumber;
    public  static void runUI() {
        Scanner input = new Scanner(System.in);


        System.out.println("Please Input following Data:");

        boolean success = false;
        while (!success) {
            System.out.println("Name: ");
            String name = input.nextLine();

            System.out.println("Phone Number: ");
            String phone = input.nextLine();

            System.out.println("Email: ");
            String email = input.nextLine();

            System.out.println("Vat Number: ");
            String vatNumber = input.nextLine();

            System.out.println("Address: ");
            String address = input.nextLine();

            System.out.println("Branch Number: ");
            int branchNumber = input.nextInt();

// Confirmation display
            System.out.println("--------------------------");
            System.out.println("Please confirm the following details:");
            System.out.println("--------------------------");
            System.out.println("Name: " + name);
            System.out.println("Phone Number: " + phone);
            System.out.println("Email: " + email);
            System.out.println("VAT Number: " + vatNumber);
            System.out.println("Address: " + address);
            System.out.println("Branch Number: " + branchNumber);
            System.out.println("--------------------------");
            System.out.println("Is the above information correct? (Y/N)");

// Read user confirmation
            char confirmation = input.next().charAt(0);
            if (confirmation == 'Y' || confirmation == 'y') {
                controller.createStore(name, phone, email, vatNumber, address, branchNumber);
                System.out.println("Store successfully created");
                success = true;
            }
        }
    }



}
