package Exceptions;

public class JmbgException extends Exception {
    
    
    public JmbgException(){
        super("JMBG IMA TACNO 13 BROJA");
    }
    
    public JmbgException(String poruka){
        super(poruka);
    }
}
