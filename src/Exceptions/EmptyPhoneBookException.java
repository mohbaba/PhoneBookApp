package Exceptions;
public class EmptyPhoneBookException extends RuntimeException {
    public EmptyPhoneBookException(String message){
        super(message);
    }
}
