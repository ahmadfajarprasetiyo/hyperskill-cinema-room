package cinema;

public class StatsResponse {
    private final int income;
    private final int available;
    private final int purchased;

    StatsResponse(int income, int available, int purchased) {
        this.income = income;
        this.available = available;
        this.purchased = purchased;
    }

    public int getIncome() {
        return income;
    }

    public int getAvailable() {
        return available;
    }

    public int getPurchased() {
        return purchased;
    }
}
