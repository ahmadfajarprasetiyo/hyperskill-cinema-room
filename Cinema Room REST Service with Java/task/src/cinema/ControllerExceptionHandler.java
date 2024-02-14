package cinema;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(SeatPurchaseException.class)
    public ResponseEntity<ErrorResponse> handleSeatPurchaseException(SeatPurchaseException e) {

        ErrorResponse body = new ErrorResponse(e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
