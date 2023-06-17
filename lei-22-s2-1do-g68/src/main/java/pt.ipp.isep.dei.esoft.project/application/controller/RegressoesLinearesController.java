package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.matcp.MatcpAlgorithms;

public class RegressoesLinearesController {
    private final MatcpAlgorithms matcpAlgorithms=new MatcpAlgorithms();
    public void RegressoesLinearesSimples(int option) {

        if (option==1){
            matcpAlgorithms.PropertyArea();

        }
        if (option==2){
            matcpAlgorithms.DistanceFromCenter();
        }
        if (option==3){
            matcpAlgorithms.numberOfBedroomsP();
        }
        if (option==4){
            matcpAlgorithms.numberOfBathroomsP();
        }
        if (option==5){
            matcpAlgorithms.numberOfGaragesP();
        }
    }
    public void RegressoesLinearesMultiples(int option) {

        if (option==1){
            matcpAlgorithms.AreaAndDistance();
        }
        if (option==2){
            matcpAlgorithms.AreaAndNumberOfBedroomsP();
        }
        if (option==3){
            matcpAlgorithms.AreaAndNumberOfBathroomsP();
        }
        if (option==4){
            matcpAlgorithms.AreaAndNumberOfGaragesP();
        }
        if (option==5){
            matcpAlgorithms.DistanceAndNumberOfRoomsP();
        }
        if (option==6){
            matcpAlgorithms.DistanceAndNumberOfBathroomsP();
        }
        if (option==7){
            matcpAlgorithms.DistanceAndNumberOfGaragesP();
        }
        if (option==8){
            matcpAlgorithms.NumberOfRoomsAndNumberOfBathroomsP();
        }
        if (option==9){
            matcpAlgorithms.NumberOfRoomsAndNumberOfGaragesP();
        }
        if (option==10){
            matcpAlgorithms.NumberOfBathroomsAndNumberOfGaragesP();
        }


    }
}
