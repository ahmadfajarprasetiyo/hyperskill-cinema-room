package cinema;

public class PurchaseResponse {

    private final String token;
    private final Seat ticket;

    PurchaseResponse(String token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public Seat getTicket() {
        return ticket;
    }

    public String getToken() {
        return token;
    }
}
