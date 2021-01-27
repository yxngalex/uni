package Exceptions;

public class EmptyFieldException extends Exception {
    
    public EmptyFieldException(){
        super("POPUNITE POLJA ZA PRIJAVU!!!");
    }
    public EmptyFieldException(String message){
        super(message);
    }
}
