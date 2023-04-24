package pt.ipp.isep.dei.esoft.project.domain;

public class Agent extends User{

    private static Agent instance = new Agent();

    private Agent() {
        super("agent", "agente imobiliario", 254054706, "tiago@email.com", "agent", "rua de santa ana", "925092102", Roles.AGENT);
    }
    public static Agent getInstance() {
        return instance;
    }
}
