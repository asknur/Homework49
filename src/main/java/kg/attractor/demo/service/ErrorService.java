package kg.attractor.demo.service;

import kg.attractor.demo.exceptions.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {
    ErrorResponseBody makeResponse(BindingResult bindingResult);
}
