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
    public PurchaseResponse purchaseSeat(@RequestBody Seat seatRequest) {
        Seat seat = this.seatCinema.getSeat(String.format("%d-%d", seatRequest.getRow(), seatRequest.getColumn()));

        if (seat == null) {
            throw new SeatPurchaseException("The number of a row or a column is out of bounds!");
        } else if (seat.isPurchased()) {
            throw new SeatPurchaseException("The ticket has been already purchased!");
        }

        String uuid = this.seatCinema.purchaseSeat(seat);
        return new PurchaseResponse(uuid, seat);
    }

    @PostMapping("/return")
    public ReturnResponse returnSeat(@RequestBody Token tokenRequest) {
        Seat seat = this.seatCinema.returnSeat(tokenRequest.getToken());

        if (seat == null) {
            throw new SeatPurchaseException("Wrong token!");
        }

        return new ReturnResponse(seat);
    }
}
