package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import org.example.Main;
import pt.ipp.isep.dei.esoft.project.domain.Store;

import java.util.ArrayList;
import java.util.List;

public class SubsetPartition {
    private List<Tuplet> tupletList;
    private List<Tuplet> minPartition;
    private int sumSubset1;
    private int sumSubset2;
    private int difference;
    private class Tuplet{
        private String storeId;
        private int propertyCount;

        public Tuplet (String storeId , int propertyCount){
            this.storeId = storeId;
            this.propertyCount = propertyCount;
        }

        public int getPropertyCount() {
            return propertyCount;
        }

        public String getStoreId() {
            return storeId;
        }

        @Override
        public String toString() {
            return "Tuplet{" +
                    "storeId='" + storeId + '\'' +
                    ", propertyCount=" + propertyCount +
                    '}';
        }
    }

    public SubsetPartition(List<Store> storeList){
        this.tupletList = loadTuplet(storeList);
        this.sumSubset1 = calculateSum(findMinPartition());
        this.sumSubset2 = calculateSum(tupletList) - sumSubset1;
        this.difference = Math.abs(sumSubset1 - sumSubset2);
    }

    public SubsetPartition(int[][] infos){
        this.tupletList = loadTuplet(infos);
        this.sumSubset1 = calculateSum(findMinPartition());
        this.sumSubset2 = calculateSum(tupletList) - sumSubset1;
        this.difference = Math.abs(sumSubset1 - sumSubset2);
    }
    private  List<Tuplet> loadTuplet(List<Store> storeList){
        List<Tuplet> tuplets = new ArrayList<>();
        for(Store store : storeList){
            Tuplet tuplet = new Tuplet(store.getVatNumber(),store.getProperties().size());
            tuplets.add(tuplet);
        }
        return tuplets;
    }
    private  List<Tuplet> loadTuplet(int [][] info){
        List<Tuplet> tuplets = new ArrayList<>();
        for (int[] ints : info) {
            Tuplet tuplet = new Tuplet(Integer.toString(ints[0]), ints[1]);
            tuplets.add(tuplet);
        }
        return tuplets;
    }
    private  List<List<Tuplet>> calculatePartitions(List<Tuplet> stores) {
        int n = stores.size();
        int totalPartitions = 1 << n;
        List<List<Tuplet>> partitions = new ArrayList<>();

        for (int i = 1; i < totalPartitions - 1; i++) {
            List<Tuplet> subset1 = new ArrayList<>();
            List<Tuplet> subset2 = new ArrayList<>();

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
    private   List<Tuplet> findMinPartition() {
        List<List<Tuplet>> partitions = calculatePartitions(tupletList);
        int minDifference = Integer.MAX_VALUE;
        List<Tuplet> minPartition = new ArrayList<>();

        for (List<Tuplet> partition : partitions) {
            int sumSubset1 = calculateSum(partition);
            int sumSubset2 = calculateSum(partition, false);
            int difference = Math.abs(sumSubset1 - sumSubset2);
            if (difference < minDifference) {
                minDifference = difference;
                minPartition = partition;
            }
        }
        this.minPartition = minPartition;

        return minPartition;
    }
    public List<Tuplet> getMinPartition() {
        return minPartition;
    }

    private  int calculateSum(List<Tuplet> tuples) {
        return calculateSum(tuples, true);
    }
    private  int calculateSum(List<Tuplet> tuples, boolean includePropertyCount) {
        int sum = 0;
        for (Tuplet tuple : tuples) {
            sum += includePropertyCount ? tuple.getPropertyCount() : 0;
        }
        return sum;
    }

    public int getDifference() {
        return difference;
    }

    public int getSumSubset1() {
        return sumSubset1;
    }

    public int getSumSubset2() {
        return sumSubset2;
    }
}
