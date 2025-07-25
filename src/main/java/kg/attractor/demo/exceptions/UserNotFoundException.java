package kg.attractor.demo.exceptions;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super("User");
    }
}
