package cinema;

import java.util.ArrayList;
import java.util.List;

public class SeatCinema {
    private int rows;
    private int columns;

    private List<Seat> seats;

    SeatCinema(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seats = new ArrayList<>();

        for (int i = 1; i <= this.rows; i++) {
            for (int j = 1; j <= this.columns; j++) {
                this.seats.add(new Seat(i, j));
            }
        }
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
