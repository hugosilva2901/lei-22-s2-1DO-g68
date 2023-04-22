package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.Optional;



public class Admin extends User{

    private static Admin instance= new Admin();

    private Admin() {
        super("admin", "administrador do projeto", 26903076, "hugo@email.com", "amdmin", "rua calvario", "910634405", Roles.ADIMIN);
    }
    public static Admin getInstance() {
        return instance;
    }




}
