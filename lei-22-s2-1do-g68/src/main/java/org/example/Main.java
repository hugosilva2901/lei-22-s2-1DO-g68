package org.example;

import pt.ipp.isep.dei.esoft.project.domain.LegacySystemData;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.AdminUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.CSVLoader;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.SubsetPartition;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        CSVLoader loader = new CSVLoader("C:\\Users\\a9239\\IdeaProjects\\lei-22-s2-1do-g68\\lei-22-s2-1do-g68\\src\\main\\java\\pt.ipp.isep.dei.esoft.project\\ui\\legacyRealStateUSAMoodle_MATCP_MDISC.csv");
        loader.getData();
        SubsetPartition subsetPartition = new SubsetPartition(Repositories.getInstance().getStoreRepository().getStores());
        System.out.println(subsetPartition.getSumSubset1());
        System.out.println(subsetPartition.getSumSubset2());
        System.out.println(subsetPartition.getDifference());



    }

    private static List<List<LegacySystemData>> calculatePartitions(List<LegacySystemData> stores) {
        int n = stores.size();
        int totalPartitions = 1 << n;
        List<List<LegacySystemData>> partitions = new ArrayList<>();

        for (int i = 1; i < totalPartitions - 1; i++) {
            List<LegacySystemData> subset1 = new ArrayList<>();
            List<LegacySystemData> subset2 = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset1.add(stores.get(j));
                } else {
                    subset2.add(stores.get(j));
                }
            }

            partitions.add(subset1);
            partitions.add(subset2);
        }

        return partitions;
    }

    private static List<LegacySystemData> findMinPartition(List<List<LegacySystemData>> partitions) {
        int minDifference = Integer.MAX_VALUE;
        List<LegacySystemData> minPartition = new ArrayList<>();

        for (List<LegacySystemData> partition : partitions) {
            int sumSubset1 = calculateSum(partition);
            int sumSubset2 = calculateSum(partition, false);
            int difference = Math.abs(sumSubset1 - sumSubset2);
            if (difference < minDifference) {
                minDifference = difference;
                minPartition = partition;
            }
        }

        return minPartition;
    }

    private static int calculateSum(List<LegacySystemData> tuples) {
        return calculateSum(tuples, true);
    }

    private static int calculateSum(List<LegacySystemData> tuples, boolean includePropertyCount) {
        int sum = 0;
        for (LegacySystemData tuple : tuples) {
       //     sum += includePropertyCount ? tuple.getPropertyCount() : 0;
        }
        return sum;
    }

    private static void printPartition(List<LegacySystemData> partition) {
        for (LegacySystemData tuple : partition) {
          //  System.out.println(tuple.getStoreID() + ", " + tuple.getPropertyCount());
        }
    }


}