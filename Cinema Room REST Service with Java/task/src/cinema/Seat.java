package cinema;

import com.fasterxml.jackson.annotation.*;

public class Seat {
    int row;
    int column;
    int price;
    boolean purchased;

    Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.purchased = false;
    }

    Seat() {}

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }
    @JsonIgnore
    public boolean isPurchased() {
        return purchased;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void purchased() {
        this.purchased = true;
    }

    public void returnPurchased() {
        this.purchased = false;
    }
}
