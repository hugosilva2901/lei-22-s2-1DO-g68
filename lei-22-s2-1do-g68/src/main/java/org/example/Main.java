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

}