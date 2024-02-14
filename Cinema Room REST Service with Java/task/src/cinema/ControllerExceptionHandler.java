package cinema;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleSeatPurchaseException(RuntimeException e) {

        ErrorResponse body = new ErrorResponse(e.getMessage());
        HttpStatusCode httpCode = HttpStatus.BAD_REQUEST;

        if (e.getMessage().equals("The password is wrong!")) {
            httpCode = HttpStatus.UNAUTHORIZED;
        }

        return new ResponseEntity<>(body, httpCode);
    }
}
