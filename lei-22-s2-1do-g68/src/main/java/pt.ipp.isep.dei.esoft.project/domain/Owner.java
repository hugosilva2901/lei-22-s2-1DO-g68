package pt.ipp.isep.dei.esoft.project.domain;

public class Owner extends User{

    private static Owner instance= new Owner();

    private Owner() {
        super("owner", "dono da propriedade", 254054706, "tiago@email.com", "owner", "rua de santa ana", "925092102", Roles.OWNER);
    }
    public static Owner getInstance() {
        return instance;
    }
}
