package cinema;

public class ReturnResponse {
    private final Seat ticket;

    ReturnResponse(Seat ticket) {
        this.ticket = ticket;
    }

    public Seat getTicket() {
        return ticket;
    }
}
