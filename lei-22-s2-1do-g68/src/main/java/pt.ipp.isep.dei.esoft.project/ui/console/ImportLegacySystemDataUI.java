package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ImportLegacySystemFileController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.CSVLoader;

import java.util.Scanner;

public class ImportLegacySystemDataUI implements Runnable{
    private ImportLegacySystemFileController controller= new ImportLegacySystemFileController();


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input File Directory:");
        String dir = scanner.nextLine();

        try {
            controller.getData(dir);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

    }
}
