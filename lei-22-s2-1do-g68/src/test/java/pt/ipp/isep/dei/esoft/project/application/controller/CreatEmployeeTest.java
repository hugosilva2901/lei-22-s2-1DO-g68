package pt.ipp.isep.dei.esoft.project.application.controller;

import org.testng.annotations.Test;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class CreatEmployeeTest {

    @Test
    void ensureCreateEmployeeWorks() {

        //Arrange
        //Get Repositories
        Repositories repositories = Repositories.getInstance();
        StoreRepository storeRepository = repositories.getStoreRepository();
        Store store = new Store("Store","9155555", "Rua do Teste", "vatnumber", "Portugal",5);
        storeRepository.addStore(store);
        CreatEmployeeController controller = new CreatEmployeeController();
        Optional<EmployeeProject> newTask = controller.createEmployee("name", "ajent", 265903075,"email.com"
                ,"hugo","rua dp calvario","910634405", Roles.AGENT,500, store);
        Optional<EmployeeProject> newTask1 = controller.createEmployee("name", "ajent", 265903076,"email.com"
                ,"hugo","rua dp calvario","910634405", Roles.STOREMANAGER,500, store);

        assertFalse(newTask.isEmpty());


    }

    @Test
    void ensureCreateEmployeeWorks1() {
        //Arrange
        //Get Repositories
        Repositories repositories = Repositories.getInstance();
        StoreRepository storeRepository = repositories.getStoreRepository();
        Store store = new Store("Store","9155555", "Rua do Teste", "vatnumber", "Portugal",5);
        storeRepository.addStore(store);
        CreatEmployeeController controller = new CreatEmployeeController();
        Optional<EmployeeProject> newTask2 = controller.createEmployee("name", "ajent", 265903077,"email.com"
                ,"hugo","rua dp calvario","910634405", Roles.STOREMANAGER,500, store);
        Optional<EmployeeProject> newTask3 = controller.createEmployee("name", "ajent", 265903077,"email.com"
                ,"hugo","rua dp calvario","910634405", Roles.STOREMANAGER,500, store);
        // É suposto dar erro porque o employee já existe
        assertFalse(newTask2.isEmpty());
    }
}
