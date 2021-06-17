package exceptions;

public class UserCredentialsException extends Exception {
    public UserCredentialsException(String message) {
        super(message);
    }

    public UserCredentialsException() {
        super("Uneti korisnik nije ispravan");
    }
}
