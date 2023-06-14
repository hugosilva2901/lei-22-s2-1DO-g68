package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegressoesLinearesController;

import java.util.Scanner;

public class RegressoesLinearesUI implements Runnable{

    RegressoesLinearesController controller = new RegressoesLinearesController();
    @Override
    public void run() {
        System.out.println("1 - Regressão Linear Simples por Área da Propriedade");
        System.out.println("2 - Regressão Linear Simples por Distância ao Centro");
        System.out.println("0 - Exit");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        while (option < 0 || option > 2) {
            System.out.println("Select an option:");
            option = input.nextInt();
        }
        if (option==1|| option==2 ){
            controller.RegressoesLinearesSimples(option);
        }
    }
}
