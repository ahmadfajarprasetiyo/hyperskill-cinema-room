package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SeatCinema {
    final private int rows;
    final private int columns;
    final private List<Seat> seats;
    final private Map<String, Seat> mapSeats;

    SeatCinema(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.mapSeats = new ConcurrentHashMap<>();
        this.seats = new ArrayList<>();

        for (int i = 1; i <= this.rows; i++) {
            for (int j = 1; j <= this.columns; j++) {
                int price = 8;
                if (i <= 4) {
                    price = 10;
                }
                Seat seat = new Seat(i, j, price);
                this.seats.add(seat);
                this.mapSeats.put(String.format("%d-%d", i, j), seat);
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

    public Seat getSeat(String key) {
        return this.mapSeats.get(key);
    }
}
