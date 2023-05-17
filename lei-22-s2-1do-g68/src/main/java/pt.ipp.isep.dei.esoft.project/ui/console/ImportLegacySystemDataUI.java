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
            CSVLoader loader = new CSVLoader("C:\\Users\\a9239\\IdeaProjects\\lei-22-s2-1do-g68\\lei-22-s2-1do-g68\\src\\main\\java\\pt.ipp.isep.dei.esoft.project\\ui\\legacyRealStateUSAMoodle.csv");



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
