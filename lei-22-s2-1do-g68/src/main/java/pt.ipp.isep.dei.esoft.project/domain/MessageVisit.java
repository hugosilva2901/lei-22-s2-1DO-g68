package pt.ipp.isep.dei.esoft.project.domain;

public class MessageVisit {
    private String message;
    private String nameEmployee;
    private String phoneEmployee;
    private String Property;
    private StatusOfMessage statusOfMessage;

    private String reson;

    public MessageVisit(String message, String nameEmployee, String phoneEmployee, String property, StatusOfMessage statusOfMessage) {
        this.message = message;
        this.nameEmployee = nameEmployee;
        this.phoneEmployee = phoneEmployee;
        Property = property;
        this.statusOfMessage = StatusOfMessage.NOTANSWERED;
        reson= "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public StatusOfMessage getStatusOfMessage() {
        return statusOfMessage;
    }

    public void putStatusOfMessage(StatusOfMessage statusOfMessage) {
        if (statusOfMessage.equals(StatusOfMessage.ACCEPTED)) {
            this.statusOfMessage = statusOfMessage;
        }else {
            System.out.println("Message not accepted, you didn't justify");
        }

    }
    public void putStatusOfMessage(StatusOfMessage statusOfMessage,String reson) {
        if (statusOfMessage.equals(StatusOfMessage.ACCEPTED)) {
            this.statusOfMessage = statusOfMessage;
        }else if (statusOfMessage.equals(StatusOfMessage.REJECTED)){
            this.statusOfMessage = statusOfMessage;
            this.reson=reson;
        }
    }

        public String getProperty() {
        return Property;
    }

    public void setProperty(String property) {
        Property = property;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }
}
