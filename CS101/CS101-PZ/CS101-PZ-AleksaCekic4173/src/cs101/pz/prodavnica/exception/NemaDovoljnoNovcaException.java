package cs101.pz.prodavnica.exception;

public class NemaDovoljnoNovcaException extends Exception{
    
    public NemaDovoljnoNovcaException(){
        super("Nemate dovoljno novca da izvrsite kupovinu!!!");
    }
    
    public NemaDovoljnoNovcaException(String message){
        super(message);
    }
}
