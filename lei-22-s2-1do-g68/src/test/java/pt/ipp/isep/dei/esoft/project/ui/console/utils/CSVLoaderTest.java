package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InvalidPropertiesFormatException;

import static org.junit.jupiter.api.Assertions.*;

class CSVLoaderTest {
    CSVLoader csvLoader;


    @Test
    void testConstructor01(){
        assertDoesNotThrow(()->csvLoader = new CSVLoader("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodle.csv"));
    }
    @Test
    void testConstructor02(){
        assertThrows(InvalidPropertiesFormatException.class, () -> {
            new CSVLoader("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodle.txt");
        });
    }
    @Test
    void testConstructor03(){
        assertThrows(InvalidPropertiesFormatException.class, () -> {
            new CSVLoader("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodleTest.txt");
        });    }
    @Test
    void testConstructor04() throws Exception {

        assertThrows(InvalidPropertiesFormatException.class, () -> {
            new CSVLoader("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodleTest2.txt");
        });    }
    }
