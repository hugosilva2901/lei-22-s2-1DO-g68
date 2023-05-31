package pt.ipp.isep.dei.esoft.project.domain.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\tiago\\OneDrive\\Ambiente de Trabalho\\esoft\\Projeto Integrador\\lei-22-s2-1do-g68\\src\\main\\java\\pt.ipp.isep.dei.esoft.project\\domain\\csv\\legacyRealStateUSAMoodle_MATCP_MDISC.csv";
        String line = "";
        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i=0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if(i>0) {
                    String type = data[6];
                    String area = data[7];
                    String distance = data[9];
                    // use data here
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}