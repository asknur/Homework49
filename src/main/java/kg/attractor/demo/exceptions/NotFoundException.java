package kg.attractor.demo.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String prefix) {
        super(prefix + " not found");
    }
}
