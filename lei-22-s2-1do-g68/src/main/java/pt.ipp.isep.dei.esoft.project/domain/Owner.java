package pt.ipp.isep.dei.esoft.project.domain;

public class Owner extends User {
    public Owner(String name, String descptions, int taxNumber, String email, String password, String address, String phone, Roles roles) {
        super(name, descptions, taxNumber, email, password, address, phone, roles);
    }

    private void validateTaxNumber(int taxNumber){
        if(taxNumber < 100000000 || taxNumber > 999999999){
            throw new IllegalArgumentException("The tax number is not valid");
        }
    }

    private void validateOwner(String name, String descptions, int taxNumber, String email, String password, String address, String phone, Roles roles) {
        validateTaxNumber(taxNumber);

    }

}
