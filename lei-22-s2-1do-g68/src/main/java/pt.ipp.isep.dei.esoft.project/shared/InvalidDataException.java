package pt.ipp.isep.dei.esoft.project.shared;

public class InvalidDataException extends IllegalArgumentException{
    public  InvalidDataException (String info){
        super(info);
    }
}
