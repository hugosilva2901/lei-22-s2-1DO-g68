package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagesOfClientRepository {
    Map<Client, List<String>> messages=new HashMap<>();
    Map<EmployeeProject,List<String>> messagesOfEmployee=new HashMap<>();
    Map<String,List<String>> MessageOfVisitByEmail=new HashMap<>();
    public void  addMessage(Client client, String message) {
        List<String> messagesOfClient = new ArrayList<>();
        if (messages.get(client) != null) {
            messagesOfClient = messages.get(client);
        }
        messagesOfClient.add(message);
        messages.put(client,messagesOfClient);
    }

    public List<String> getMessage(Client client) {
        return messages.get(client);
    }

    public void addMessageOfVisit(String email,String message){
        List<String> messagesOfClient = new ArrayList<>();
        if (MessageOfVisitByEmail.get(email) != null) {
            messagesOfClient = MessageOfVisitByEmail.get(email);
        }
        messagesOfClient.add(message);
        MessageOfVisitByEmail.put(email,messagesOfClient);
    }
}
