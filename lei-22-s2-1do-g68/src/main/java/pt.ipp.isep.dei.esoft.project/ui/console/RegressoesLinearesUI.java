package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegressoesLinearesController;

import java.util.Scanner;

public class RegressoesLinearesUI implements Runnable{

    RegressoesLinearesController controller = new RegressoesLinearesController();
    @Override
    public void run() {
        System.out.println("Do you want to run a Simple Linear Regression or a Multiple Linear Regression?");
        System.out.println("1 - Simple Linear Regression");
        System.out.println("2 - Multiple Linear Regression");
        System.out.println("0 - Exit");
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 0 || answer > 2) {
            System.out.println("Select an option:");
            answer = input.nextInt();
        }

        switch (answer) {
            case 1:
                runRegressoesLinearesSimples();
                break;
            case 2:
                runRegressoesLinearesMultiples();
                break;
            case 0:
                break;
        }

    }
    private void runRegressoesLinearesSimples() {
        System.out.println("1 - Regressão Linear Simples por Área da Propriedade");
        System.out.println("2 - Regressão Linear Simples por Distância ao Centro");
        System.out.println("3 - Regressão Linear Simples por Número de Quartos");
        System.out.println("4 - Regressão Linear Simples por Número de Casas de Banho");
        System.out.println("5 - Regressão Linear Simples por Número de Garagens");
        System.out.println("0 - Exit");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        while (option < 0 || option > 5) {
            System.out.println("Select an option:");
            option = input.nextInt();
        }
        if (option==1|| option==2 || option==3 || option==4 || option==5){
            controller.RegressoesLinearesSimples(option);
        }
    }
    private void runRegressoesLinearesMultiples() {
        System.out.println("1-Regressão linear múltipla por Área da Propriedade e Distância ao Centro");
        System.out.println("2-Regressão linear múltipla por Área da Propriedade e Número de Quartos");
        System.out.println("3-Regressão linear múltipla por Área da Propriedade e Número de Casas de Banho");
        System.out.println("4-Regressão linear múltipla por Área da Propriedade e Número de Garagens");
        System.out.println("5-Regressão linear múltipla por Distância ao Centro e Número de Quartos");
        System.out.println("6-Regressão linear múltipla por Distância ao Centro e Número de Casas de Banho");
        System.out.println("7-Regressão linear múltipla por Distância ao Centro e Número de Garagens");
        System.out.println("8-Regressão linear múltipla por Número de Quartos e Número de Casas de Banho");
        System.out.println("9-Regressão linear múltipla por Número de Quartos e Número de Garagens");
        System.out.println("10-Regressão linear múltipla por Número de Casas de Banho e Número de Garagens");
        System.out.println("0 - Exit");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        while (option < 0 || option > 10) {
            System.out.println("Select an option:");
            option = input.nextInt();
        }
        controller.RegressoesLinearesMultiples(option);

    }
}
