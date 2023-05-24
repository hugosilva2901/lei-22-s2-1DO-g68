package pt.ipp.isep.dei.esoft.project.shared;

import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.Roles;
import pt.ipp.isep.dei.esoft.project.domain.Store;

public class Constant {

    public final static Roles[] ROLE_AGENT = {Roles.AGENT};
    public final static String PROPERTY_NAME_BY_DEFAULT = "NO_NAME";
    public final static String AIR_CONDITIONER ="Air Conditioner";
    public final static String CENTRAL_HEATER ="Central Heater";


    public final static Store DEFAULT_STORE = new Store("Legacy Store","0000000","a123456@gmail.com","00000","NO ADDRESS",0);
    public final static EmployeeProject DEFAULT_AGENT = new EmployeeProject("Legacy Agent","None",100000000,"legacy@realstateUSA.com","123","","0000000000",ROLE_AGENT,0,DEFAULT_STORE);


}
