package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatEmployeeController;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateTaskController;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.Roles;
import pt.ipp.isep.dei.esoft.project.domain.Store;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CreatEmployeeUi implements Runnable{
    private final CreatEmployeeController controller = new CreatEmployeeController();

    private String name;
    private String descptions;
    private int taxNumber;
    private String email;
    private String password;
    private String address;
    private String phone;
    private int salary;
    private Store store;

    private Roles[] roles;

    private CreatEmployeeController getController() {
        return controller;
    }

    public void run() {
        System.out.println("Create Employee\n");

        store = displayAndSelectStores();

        System.out.println("choose a role");
        System.out.println("1 - agent");
        System.out.println("2 - localManger");
        System.out.println("3 - both");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();
        if (answer == 1) {
            roles = new Roles[]{Roles.AGENT};
        } else if (answer == 2) {
            roles = new Roles[]{Roles.STOREMANAGER};
        } else if (answer == 3) {
            roles = new Roles[]{Roles.STOREMANAGER};
            roles = new Roles[]{Roles.AGENT};

        } else {
            System.out.println("invalid input");
        }
        requestData();

        submitData();
    }

    private Store displayAndSelectStores() {
        //Display the list of task categories

        List<Store> Stores = controller.getStores();

        int listSize = Stores.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayStoresOptions(Stores);
            System.out.println("Select a store:");
            answer = input.nextInt();
        }

        Store description = Stores.get(answer - 1);
        return description;

    }
    private void displayStoresOptions(List<Store> Stores) {
        //display the task categories as a menu with number options to select
        int i = 1;
        for (Store Store : Stores) {
            System.out.println(i + " - " + Stores.toString());
            i++;
        }
    }

    private void submitData() {
        Optional<EmployeeProject> task = getController().createEmployee(name, descptions, taxNumber, email, password, address, phone, roles, salary, store);

        if (task.isPresent()) {
            System.out.println("Employee successfully created!");
        } else {
            System.out.println("Employee not created!");
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
        salary = requestSalary();

    }
    private String requestName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Name:");
        return input.nextLine();
    }
    private String requestDescptions() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Descptions:");
        return input.nextLine();
    }

    private int requestTaxNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Tax Number:");
        return input.nextInt();
    }
    private String requestEmail() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Email:");
        return input.nextLine();
    }
    private String requestPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Password:");
        return input.nextLine();
    }
    private String requestAddress() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Address:");
        return input.nextLine();
    }
    private String requestPhone() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Phone:");
        return input.nextLine();
    }
    private int requestSalary() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee Salary:");
        return input.nextInt();
    }


}
