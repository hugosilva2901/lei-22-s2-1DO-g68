package pt.ipp.isep.dei.esoft.project.domain;

public class Admin extends User{

    private Admin(String name, String descptions, int taxNumber, String email, String password, String address, String phone) {
        super(name, descptions, taxNumber, email, password, address, phone, Roles.ADIMIN);
    }


}
