package powerup.v1.usecases.exception;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException(){
        super("ID not found!");
    }
    public IdNotFoundException(String message) {
        super(message);
    }
}
