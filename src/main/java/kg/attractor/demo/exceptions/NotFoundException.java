package kg.attractor.demo.exceptions;

import java.util.NoSuchElementException;

public class NotFoundException extends NoSuchElementException {
    public NotFoundException(String prefix) {
        super(prefix + " not found");
    }
}
