package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CalculatePartitionController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.SubsetPartition;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;
import java.util.Scanner;

public class CalculatePartionUI implements Runnable {
    CalculatePartitionController controller = new CalculatePartitionController();

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<String> options = List.of("Calculate All","Calculate with input N");
        int index;
        do {
             index = Utils.showAndSelectIndex(options,"Select Option");
             switch (index){
                 case 0:
                     SubsetPartition subsetPartition = controller.calculateAll();
                     System.out.println("Sum Subset 1: "+ subsetPartition.getSumSubset1());
                     System.out.println("Sum Subset 2: "+ subsetPartition.getSumSubset2());
                     System.out.println("Subset difference: "+ subsetPartition.getDifference());
                     System.out.println("Minimum Subset Partition: "+ subsetPartition.getMinPartition());
                     break;

                 case 1:
                     int n = -1;
                     try{
                         System.out.println("Input N:");
                         n = scanner.nextInt();
                     }catch (Exception e){
                         System.out.println(e.getMessage());
                     }
                     if(n > 0){
                         SubsetPartition subsetPartitionWithN = controller.calculateWithNstores(n);
                         System.out.println("n = "+n);
                         System.out.println("Sum Subset 1: "+ subsetPartitionWithN.getSumSubset1());
                         System.out.println("Sum Subset 2: "+ subsetPartitionWithN.getSumSubset2());
                         System.out.println("Subset difference: "+ subsetPartitionWithN.getDifference());
                         System.out.println("Minimum Subset Partition: "+ subsetPartitionWithN.getMinPartition());
                     }
                     break;
             }


        }while(index >=0);

    }
}
