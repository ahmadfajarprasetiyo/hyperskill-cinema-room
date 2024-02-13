package cinema;

import org.springframework.web.bind.annotation.*;

@RestController
public class SeatController {

    @GetMapping("/seats")
    public SeatCinema getSeat() {
        return new SeatCinema(9,9);
    }
}
