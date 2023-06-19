package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.matcp.MatcpAlgorithms;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;

public class MactpTest {
    @Test
    public void test1(){
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();
        MatcpAlgorithms matcpAlgorithms = new MatcpAlgorithms();
        System.out.println("1 - Regressão Linear Simples por Área da Propriedade");
        matcpAlgorithms.PropertyArea();
        System.out.println();
        System.out.println();
        System.out.println("2 - Regressão Linear Simples por Distância ao Centro");
        matcpAlgorithms.DistanceFromCenter();
        System.out.println();
        System.out.println();
        System.out.println("3 - Regressão Linear Simples por Número de Quartos");
        matcpAlgorithms.numberOfBedroomsP();
        System.out.println();
        System.out.println();
        System.out.println("4 - Regressão Linear Simples por Número de Casas de Banho");
        matcpAlgorithms.numberOfBathroomsP();
        System.out.println();
        System.out.println();
        System.out.println("5 - Regressão Linear Simples por Número de Garagens");
        matcpAlgorithms.numberOfGaragesP();

    }
    @Test
    public void test(){
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();
        MatcpAlgorithms matcpAlgorithms = new MatcpAlgorithms();
        matcpAlgorithms.mult();
    }
}
