package kg.attractor.demo.service.impl;

import kg.attractor.demo.exceptions.ErrorResponseBody;
import kg.attractor.demo.service.ErrorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ErrorServiceImpl implements ErrorService {

    @Override
    public ErrorResponseBody makeResponse(BindingResult bindingResult) {
        log.info("Creating error response");
        Map<String, List<String>> reasons = new HashMap<>();
        bindingResult.getFieldErrors().stream()
                .filter(e -> e.getDefaultMessage() != null)
                .forEach(e -> {
                    List<String> errors = new ArrayList<>();
                errors.add(e.getDefaultMessage());
                if (!reasons.containsKey(e.getField())) {
                    reasons.put(e.getField(), errors);
                }
                });
        return ErrorResponseBody.builder()
                .title("Validation errors")
                .response(reasons)
                .build();
    }
}
