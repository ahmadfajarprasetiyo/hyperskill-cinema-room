package cinema;

public class SeatPurchaseError {
    final private String error;
    SeatPurchaseError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
