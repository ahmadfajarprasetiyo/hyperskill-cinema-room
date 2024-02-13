package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SeatController {
    final int sizeSeat = 9;
    SeatCinema seatCinema = new SeatCinema(sizeSeat, sizeSeat);

    @GetMapping("/seats")
    public SeatCinema getSeat() {
        return this.seatCinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<Object> purchaseSeat(@RequestBody Seat seatRequest) {
        Seat seat = this.seatCinema.getSeat(String.format("%d-%d", seatRequest.getRow(), seatRequest.getColumn()));

        if (seat == null) {
            return new ResponseEntity<>(new SeatPurchaseError("The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        } else if (seat.isPurchased()) {
            return new ResponseEntity<>(new SeatPurchaseError("The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
        }


        seat.purchased();
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }
}
