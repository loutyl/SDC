package sdc.Exceptions;

public class UnknownVariableException extends ProcessingException {

    public UnknownVariableException(){
        super();
    }

    public UnknownVariableException(String message){
        super(message);
    }
}
