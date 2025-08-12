package kg.attractor.demo.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import kg.attractor.demo.service.ErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.ErrorResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {
//    private final ErrorService errorService;
//
//
//    @ExceptionHandler(NotFoundException.class)
//    public ErrorResponse handleNotFoundException(Exception ex) {
//        return ErrorResponse.builder(ex, HttpStatus.NOT_FOUND, ex.getMessage()).build();
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponseBody> validationHandler(MethodArgumentNotValidException ex) {
//        return new ResponseEntity<>(errorService.makeResponse(ex.getBindingResult()), HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(Model model, HttpServletRequest request) {
        model.addAttribute("status",  HttpStatus.NOT_FOUND.value());
        model.addAttribute("reason", HttpStatus.NOT_FOUND.getReasonPhrase());
        model.addAttribute("details", request);
        return "errors/error";
    }

}
